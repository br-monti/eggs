package br.inatel.fetin.fetindoctor.session;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.international.StatusMessage;
import org.jboss.seam.international.StatusMessages;

import br.inatel.fetin.fetindoctor.dao.PrescriptionDao;
import br.inatel.fetin.fetindoctor.dao.PrescriptionRemedyDao;
import br.inatel.fetin.fetindoctor.entity.Clinic;
import br.inatel.fetin.fetindoctor.entity.Doctor;
import br.inatel.fetin.fetindoctor.entity.Patient;
import br.inatel.fetin.fetindoctor.entity.Prescription;
import br.inatel.fetin.fetindoctor.entity.PrescriptionRemedy;
import br.inatel.fetin.fetindoctor.entity.PrescriptionRemedyId;
import br.inatel.fetin.fetindoctor.entity.PrescriptionType;
import br.inatel.fetin.fetindoctor.entity.Remedy;
import br.inatel.fetin.fetindoctor.http.SendParametersServer;
import br.inatel.fetin.fetindoctor.model.PrescriptionReportModel;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperRunManager;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Transactional;

@Name("prescriptionHome")
public class PrescriptionHome extends EntityHome<Prescription> {

	private static final int PrescriptionWhiteCommon = 1;
	private static final int PrescriptionWhiteSpecial = 2;
	private static final int PrescriptionBlueB1 = 3;
	
	private static final long serialVersionUID = 1L;
	
	public static final String STYLE_BY_SELECTED_ROW = "text-align: center; background-color: #fffd6b;";
	public static final String STYLE_DEFATULT = "text-align: center;";
	boolean isSelected = false;
	
	@In StatusMessages statusMessages;
	
	@In(create = true)	DoctorHome doctorHome;
	@In(create = true)	PrescriptionTypeHome prescriptionTypeHome;
	@In(create = true)	PatientHome patientHome;
	@In(create = true)	ClinicHome clinicHome;
	
	@In(create = true)	RemedyHome remedyHome;
	@In(create = true)	PrescriptionRemedyHome prescriptionRemedyHome;	
	
	@In(create = true) PrescriptionDao prescriptionDao;
	@In(create = true) PrescriptionRemedyDao prescriptionRemedyDao;
	
	//@In(create = true, value  = "prescriptionListModel") PrescriptionListModel model;
	//@In(create = true, value  = "prescriptionReportModel") PrescriptionReportModel reportmodel;
	
	private boolean remedyChanges = false;
	private ArrayList<PrescriptionRemedy> prescriptionRemedyList = null;
	
	public String selectedTab = "doctor";
	
	@In(create = true, value = "prescriptionReportModel") PrescriptionReportModel prescriptionReportModel;
	SendParametersServer sendParametersServer;

	@Transactional
	@Override
	public String persist() { 
		joinTransaction();
		try { 
			// Registrando a entidade atual 
			Prescription prescription = getInstance(); 
			prescriptionDao.insert(prescription); 
			persistRemedies(prescription); 
			getEntityManager().flush(); 
			createdMessage(); 
			raiseAfterTransactionSuccessEvent(); 
			} catch (Exception e) { 
				statusMessages.addFromResourceBundle(StatusMessage.Severity.WARN, "Prescription.error"); 
				return "exception"; 
				} 
		return "persisted";
		}
	
	@Transactional
	@Override
	public String update() { 
		joinTransaction();
		try { 
			// Registrando a entidade atual 
			Prescription prescription = getInstance(); 
			prescriptionDao.insert(prescription); 
			updateRemedy(prescription); 
			getEntityManager().flush(); 
			updatedMessage(); 
			raiseAfterTransactionSuccessEvent(); 
			} catch (Exception e) { 
				statusMessages.addFromResourceBundle(StatusMessage.Severity.WARN, "Prescription.error"); 
				return "exception"; 
				} 
		return "updated";
		}
	
	//Remedy methods
	
	private void loadPrescriptionRemedy(Prescription prescription) { 
		prescriptionRemedyList = new ArrayList<PrescriptionRemedy>(); 
		
		Set<PrescriptionRemedy> prescriptionRemedies = prescription.getPrescriptionRemedies(); 
		
		for (PrescriptionRemedy prescriptionRemedy : prescriptionRemedies) {
			PrescriptionRemedy newPrescriptionRemedy = new PrescriptionRemedy();
			newPrescriptionRemedy.setRemedy(prescriptionRemedy.getRemedy());
			newPrescriptionRemedy.setObservation(prescriptionRemedy.getObservation());
			newPrescriptionRemedy.setQuantityTotal(prescriptionRemedy.getQuantityTotal());

			prescriptionRemedyList.add(newPrescriptionRemedy);
		}
	}
	
	private void addRemedy() { 
		Remedy remedy = remedyHome.getDefinedInstance(); 
		
		if (remedy != null) {
			PrescriptionRemedy prescriptionRemedy = new PrescriptionRemedy();
			prescriptionRemedy.setRemedy(remedy);

			remedyChanges = true;
			prescriptionRemedyList.add(prescriptionRemedy);
	
			remedyHome.clearInstance();
		}
	}
	
	private void persistRemedies(Prescription prescription) { 
		if (remedyChanges) { 
			for (PrescriptionRemedy prescriptionRemedy : prescriptionRemedyList) { 
				Remedy remedy = new Remedy();
				remedy = prescriptionRemedy.getRemedy();
				
				PrescriptionRemedyId id = new PrescriptionRemedyId();
				id.setPrescriptionId(prescription.getId());
				id.setRemedyId(prescriptionRemedy.getRemedy().getId());
				
				prescriptionRemedy.setId(id);
				prescriptionRemedy.setPrescription(prescription);
				prescriptionRemedy.setRemedy(remedy);
				prescriptionRemedyDao.insert(prescriptionRemedy);
			}
		}
	}
	
	private void updateRemedy(Prescription prescription) { 
		if (remedyChanges) { 
			// Removendo todos os relacionamentos 
			Set<PrescriptionRemedy> prescriptionRemedies = prescription.getPrescriptionRemedies(); 
			for (PrescriptionRemedy prescriptionRemedy : prescriptionRemedies) { 
				prescriptionRemedyDao.delete(prescriptionRemedy); 
				} 
			persistRemedies(prescription); 
			} 
		}

	public void removeRemedy(PrescriptionRemedy prescriptionRemedy) { 

				remedyChanges = true; 
				prescriptionRemedyList.remove(prescriptionRemedy); 
				
		}
		
	@Override public void setInstance(Prescription instance) { 
		if (instance != null) { 
			loadPrescriptionRemedy(instance); 
			} 
		super.setInstance(instance); 
		}

	
	public void setPrescriptionId(Integer id) {
		setId(id);
	}

	public Integer getPrescriptionId() {
		return (Integer) getId();
	}

	@Override
	protected Prescription createInstance() {
		Prescription prescription = new Prescription();
		return prescription;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		addRemedy();
		Doctor doctor = doctorHome.getDefinedInstance();
		if (doctor != null) {
			getInstance().setDoctor(doctor);
		}

		PrescriptionType prescriptionType = prescriptionTypeHome
				.getDefinedInstance();
		if (prescriptionType != null) {
			getInstance().setPrescriptionType(prescriptionType);
		}
		Patient patient = patientHome.getDefinedInstance();
		if (patient != null) {
			getInstance().setPatient(patient);
		}
		Clinic clinic = clinicHome.getDefinedInstance();
		if (clinic != null) {
			getInstance().setClinic(clinic);
		}
	}

	public boolean isWired() {
		if (getInstance().getDoctor() == null)
			return false;
		if (getInstance().getPrescriptionType() == null)
			return false;
		if (getInstance().getPatient() == null)
			return false;
		if (getInstance().getClinic() == null)
			return false;
		return true;
	}

	public Prescription getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<PrescriptionRemedy> getPrescriptionRemedies() {
		return getInstance() == null ? null
				: new ArrayList<PrescriptionRemedy>(getInstance()
						.getPrescriptionRemedies());
	}

	// RemedyHome,ArrayList getters e setters
	public RemedyHome getRemedyHome() {
		return remedyHome;
	}

	public void setRemedyHome(RemedyHome remedyHome) {
		this.remedyHome = remedyHome;
	}

	
	public ArrayList<PrescriptionRemedy> getPrescriptionRemedyList() {
		return prescriptionRemedyList;
	}

	public void setPrescriptionRemedyList(
			ArrayList<PrescriptionRemedy> prescriptionRemedyList) {
		this.prescriptionRemedyList = prescriptionRemedyList;
	}
	
	private List<PrescriptionReportModel> getDataSource(Prescription prescription) {			
		
		prescriptionReportModel = new PrescriptionReportModel();
		
		
				
		for (PrescriptionRemedy prescriptionRemedy : getPrescriptionRemedies()) {
			
			if(prescription.getId() == (prescriptionRemedy.getPrescription().getId())){
												

				
				prescriptionReportModel.setField_doctor_name(prescriptionRemedy.getPrescription().getDoctor().getName());
				prescriptionReportModel.setField_doctor_speciality(prescriptionRemedy.getPrescription().getDoctor().getSpeciality());
				prescriptionReportModel.setField_doctor_crm(prescriptionRemedy.getPrescription().getDoctor().getCrm());
				prescriptionReportModel.setField_doctor_cpf(prescriptionRemedy.getPrescription().getDoctor().getCpf());
		
				prescriptionReportModel.setField_clinic_name(prescriptionRemedy.getPrescription().getClinic().getName());
				prescriptionReportModel.setField_clinic_address(prescriptionRemedy.getPrescription().getClinic().getAddress());
				prescriptionReportModel.setField_clinic_cnpj(prescriptionRemedy.getPrescription().getClinic().getCnpj());
		
				prescriptionReportModel.setField_patient_name(prescriptionRemedy.getPrescription().getPatient().getName());
				prescriptionReportModel.setField_patient_address(prescriptionRemedy.getPrescription().getPatient().getAddress());		
				prescriptionReportModel.setField_patient_sex(prescriptionRemedy.getPrescription().getPatient().getSex());
				prescriptionReportModel.setField_remedy1_name(prescriptionRemedy.getRemedy().getName());
				prescriptionReportModel.setField_remedy1_form(prescriptionRemedy.getRemedy().getForm());
				prescriptionReportModel.setField_remedy1_concentration(prescriptionRemedy.getRemedy().getConcentration());
				prescriptionReportModel.setField_remedy1_total(String.valueOf(prescriptionRemedy.getQuantityTotal()));
				prescriptionReportModel.setField_remedy1_observation(prescriptionRemedy.getObservation());
			
				prescriptionReportModel.setField_date(String.valueOf(prescriptionRemedy.getPrescription().getDate()));	
				prescriptionReportModel.setPrescriptionType(String.valueOf(prescriptionRemedy.getPrescription().getPrescriptionType().getId()));
				
				prescriptionReportModel.setField_acess_code(String.valueOf(prescriptionRemedy.getPrescription().getId()));
			}
		}
		
		

		
		List<PrescriptionReportModel> lista  = new ArrayList<PrescriptionReportModel>();		
		lista.add(prescriptionReportModel);
		return lista;


	}
	
	public void sendPharmacy(){
		
		Prescription prescription = getDefinedInstance();
		getDataSource(prescription);
		sendParametersServer = new SendParametersServer();
		
		sendParametersServer.sendPharmacy(prescriptionReportModel);
	}
	
	
	public void executeReport() {

		Prescription prescription = getDefinedInstance();
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		
		InputStream reportStream = facesContext.getExternalContext().getResourceAsStream(getPrescriptionName(prescription.getPrescriptionType().getId()));
		
		response.setContentType("application/pdf");
		
		response.setHeader("Content-disposition", "inline;filename=Receita "+prescription.getPatient().getName()+".pdf");
		
		try {
			ServletOutputStream servletOutputStream = response.getOutputStream();
			
			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(getDataSource(prescription));
			
			JasperRunManager.runReportToPdfStream(reportStream,	servletOutputStream, null, datasource);
			
			servletOutputStream.flush();
			
			servletOutputStream.close();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			facesContext.responseComplete();
		}
	}

	
	public String getPrescriptionName(int prescriprionTypeId){
		String name = null;
		
		switch (prescriprionTypeId) {
		case PrescriptionWhiteCommon:
			name = "/jasper/PrescriptionWhiteCommon.jasper";
			break;
			
		case PrescriptionWhiteSpecial:
			name = "/jasper/PrescriptionWhiteSpecial.jasper";
			break;
			
		case PrescriptionBlueB1:
			name = "/jasper/PrescriptionBlueB1.jasper";
			break;

		default:
			break;
		}
		
		return name;	
		
	}
	
//	public PrescriptionListModel getModel() {
//		return model;
//	}
//
//	public void setModel(PrescriptionListModel model) {
//		this.model = model;
//	}

	public String getSelectedTab() {
		return selectedTab;
	}
	
	public void setSelectedTab(String selectedTab) {
		this.selectedTab = selectedTab;
	}
	
	public String getStyleRowByEventInAlert() {
		
		String styleRow = STYLE_DEFATULT;
		
		if (isSelected){
			styleRow = STYLE_BY_SELECTED_ROW;
		}
		
		return styleRow;
		
	}

}
