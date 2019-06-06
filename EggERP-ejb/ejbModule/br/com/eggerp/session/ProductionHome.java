package br.com.eggerp.session;

import br.com.eggerp.dao.ProductionDao;
import br.com.eggerp.dao.ProductionsDao;
import br.com.eggerp.entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.international.StatusMessage;
import org.jboss.seam.international.StatusMessages;

@Name("productionHome")
public class ProductionHome extends EntityHome<Production> {

	private static final long serialVersionUID = 1L;

	@In StatusMessages statusMessages;

	@In(create = true) BaseEggHome baseEggHome;
	
	@In(create = true) ProductHome productHome;
	@In(create = true) ProductionsHome productionsHome;
	
	@In(create = true) ProductionDao productionDao;
	@In(create = true) ProductionsDao productionsDao;
	
	private boolean productChanges =  false;
	private ArrayList<Productions> productionsList = null;
	
	public String selectedTab = "baseEgg";
	
	@Transactional
	@Override
	public String persist() { 
		joinTransaction();
		try { 
			// Registrando a entidade atual 
			Production production = getDefinedInstance(); 
			productionDao.insert(production); 
			persistProductions(production); 
			getEntityManager().flush(); 
			createdMessage(); 
			raiseAfterTransactionSuccessEvent(); 
			} catch (Exception e) { 
				statusMessages.addFromResourceBundle(StatusMessage.Severity.WARN, "Production.error"); 
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
			Production production = getDefinedInstance(); 
			productionDao.insert(production); 
			updateProduction(production); 
			getEntityManager().flush(); 
			updatedMessage(); 
			raiseAfterTransactionSuccessEvent(); 
			} catch (Exception e) { 
				statusMessages.addFromResourceBundle(StatusMessage.Severity.WARN, "Prescription.error"); 
				return "exception"; 
				} 
		return "updated";
		}
	
	//Productions methods
	
	private void loadProductions(Production production) { 
		productionsList = new ArrayList<Productions>(); 
		
		Set<Productions> productions = production.getProductions(); 
		
		for (Productions productionProduct : productions) {
			Productions newProductionProduct = new Productions();
			newProductionProduct.setProduct(productionProduct.getProduct());
			newProductionProduct.setProductionQuantity(productionProduct.getProductionQuantity());
			newProductionProduct.setBalance(productionProduct.getBalance());

			productionsList.add(newProductionProduct);
		}
	}
	
	private void addRemedy() { 
		Product product = productHome.getDefinedInstance(); 
		
		if (product != null) {
			Productions productions = new Productions();
			productions.setProduct(product);

			productChanges = true;
			productionsList.add(productions);
	
			productHome.clearInstance();
		}
	}
	
	private void persistProductions(Production production) { 
		if (productChanges) { 
			for (Productions productions : productionsList) { 
				Product product = new Product();
				product = productions.getProduct();
				
				ProductionsId id = new ProductionsId();
				id.setProductionId(production.getId());
				id.setProductId(productions.getProduct().getId());
				id.setId(product.getId());
				
				productions.setId(id);
				productions.setProduction(production);
				productions.setProduct(product);
				productionsDao.insert(productions);
			}
		}
	}
	
	private void updateProduction(Production production) { 
		if (productChanges) { 
			// Removendo todos os relacionamentos 
			Set<Productions> productions = production.getProductions(); 
			for (Productions productionProduct : productions) { 
				productionsDao.delete(productionProduct); 
				} 
			persistProductions(production); 
			} 
		}

	public void removeProduct(Productions productions) { 

		productChanges = true; 
		productionsList.remove(productions); 
				
		}
	
	@Override 
	public void setInstance(Production instance) { 
		if (instance != null) { 
			loadProductions(instance); 
			} 
		super.setInstance(instance); 
		}
	
	public void setProductionId(Integer id) {
		setId(id);
	}

	public Integer getProductionId() {
		return (Integer) getId();
	}

	@Override
	protected Production createInstance() {
		Production production = new Production();
		return production;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		addRemedy();
		BaseEgg baseEgg = baseEggHome.getDefinedInstance();
		if (baseEgg != null) {
			getInstance().setBaseEgg(baseEgg);
		}
	}

	public boolean isWired() {
		if (getInstance().getBaseEgg() == null)
			return false;
		return true;
	}

	public Production getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Productions> getProductions() {
		return getInstance() == null ? null : new ArrayList<Productions>(getInstance().getProductions());
	}
	
	public String getSelectedTab() {
		return selectedTab;
	}
	
	public void setSelectedTab(String selectedTab) {
		this.selectedTab = selectedTab;
	}
	
	// RemedyHome,ArrayList getters e setters
	public ProductHome getProductHome() {
		return productHome;
	}

	public void setProductHome(ProductHome productHome) {
		this.productHome = productHome;
	}

	
	public ArrayList<Productions> getProductionsList() {
		return productionsList;
	}

	public void setProductionsList(
			ArrayList<Productions> productionProductList) {
		this.productionsList = productionProductList;
	}

}