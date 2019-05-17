package br.inatel.fetin.fetindoctor.http;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;




import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import br.inatel.fetin.fetindoctor.model.PrescriptionReportModel;
import br.inatel.fetin.fetindoctor.util.SendMessageGCM;

public class SendParametersServer {

	private String destination = "http://10.2.0.199:8080/TelitPharmacy2/Server";
	
	//private String destination = "http://192.168.0.103:8080/TelitPharmacy2/Server";
	
	public void sendPharmacy(PrescriptionReportModel model) {

		HttpClient client = new DefaultHttpClient();
		HttpPost getMethod = new HttpPost(destination);

		try {

			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
			nameValuePairs.add(new BasicNameValuePair("field_doctor_name", model.getField_doctor_name()));
			nameValuePairs.add(new BasicNameValuePair("field_doctor_speciality", model.getField_doctor_speciality()));
			nameValuePairs.add(new BasicNameValuePair("field_doctor_crm", model.getField_doctor_crm()));
			nameValuePairs.add(new BasicNameValuePair("field_doctor_cpf", model.getField_doctor_cpf()));
			
			nameValuePairs.add(new BasicNameValuePair("field_clinic_name", model.getField_clinic_name()));
			nameValuePairs.add(new BasicNameValuePair("field_clinic_address", model.getField_clinic_address()));
			nameValuePairs.add(new BasicNameValuePair("field_clinic_cnpj", model.getField_clinic_cnpj()));
			
			nameValuePairs.add(new BasicNameValuePair("field_patient_name", model.getField_patient_name()));
			nameValuePairs.add(new BasicNameValuePair("field_patient_sex", model.getField_patient_sex()));
			nameValuePairs.add(new BasicNameValuePair("field_patient_address", model.getField_patient_address()));
			
			nameValuePairs.add(new BasicNameValuePair("field_remedy1_name", model.getField_remedy1_name()));
			nameValuePairs.add(new BasicNameValuePair("field_remedy1_form", model.getField_remedy1_form()));
			nameValuePairs.add(new BasicNameValuePair("field_remedy1_concentration", model.getField_remedy1_concentration()));
			nameValuePairs.add(new BasicNameValuePair("field_remedy1_total", model.getField_remedy1_total()));
			nameValuePairs.add(new BasicNameValuePair("field_remedy1_observation", model.getField_remedy1_observation()));
			
			nameValuePairs.add(new BasicNameValuePair("field_date", model.getField_date()));
			
			nameValuePairs.add(new BasicNameValuePair("prescriptionType", model.getPrescriptionType()));
			
			nameValuePairs.add(new BasicNameValuePair("acessCode", model.getField_acess_code()));

			getMethod.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			client.execute(getMethod);

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SendMessageGCM  sendMessageGCM = new SendMessageGCM();
		sendMessageGCM.sendMessage(model.getField_doctor_name(), 
				model.getField_remedy1_total(), model.getField_remedy1_name(), model.getField_acess_code(),
				model.getField_date());
		
		//System.out.println(model.getField_date());

	}
}

