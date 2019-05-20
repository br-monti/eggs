package org.domain.egg2.session;

import org.domain.egg2.dao.ProductionDao;
import org.domain.egg2.dao.ProductionProductDao;
import org.domain.egg2.entity.*;
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
	@In(create = true) ProductionProductHome productionProductHome;
	
	@In(create = true) ProductionDao productionDao;
	@In(create = true) ProductionProductDao productionProductDao;
	
	private boolean productChanges =  false;
	private ArrayList<ProductionProduct> productionProductList = null;
	
	public String selectedTab = "baseEgg";
	
	@Transactional
	@Override
	public String persist() { 
		joinTransaction();
		try { 
			// Registrando a entidade atual 
			Production production = getInstance(); 
			productionDao.insert(production); 
			persistProductions(production); 
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
			Production production = getInstance(); 
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
	
	//Remedy methods
	
	private void loadProductionProduct(Production production) { 
		productionProductList = new ArrayList<ProductionProduct>(); 
		
		Set<ProductionProduct> productionProducts = production.getProductionProducts(); 
		
		for (ProductionProduct productionProduct : productionProducts) {
			ProductionProduct newProductionProduct = new ProductionProduct();
			newProductionProduct.setProduct(productionProduct.getProduct());
			newProductionProduct.setQuantityProduction(productionProduct.getQuantityProduction());
			newProductionProduct.setQuantityBalance(productionProduct.getQuantityBalance());

			productionProductList.add(newProductionProduct);
		}
	}
	
	private void addRemedy() { 
		Product product = productHome.getDefinedInstance(); 
		
		if (product != null) {
			ProductionProduct productionProduct = new ProductionProduct();
			productionProduct.setProduct(product);

			productChanges = true;
			productionProductList.add(productionProduct);
	
			productHome.clearInstance();
		}
	}
	
	private void persistProductions(Production production) { 
		if (productChanges) { 
			for (ProductionProduct productionProduct : productionProductList) { 
				Product product = new Product();
				product = productionProduct.getProduct();
				
				ProductionProductId id = new ProductionProductId();
				id.setProductionId(production.getId());
				id.setProductId(productionProduct.getProduct().getId());
				
				productionProduct.setId(id);
				productionProduct.setProduction(production);
				productionProduct.setProduct(product);
				productionProductDao.insert(productionProduct);
			}
		}
	}
	
	private void updateProduction(Production production) { 
		if (productChanges) { 
			// Removendo todos os relacionamentos 
			Set<ProductionProduct> productionProducts = production.getProductionProducts(); 
			for (ProductionProduct productionProduct : productionProducts) { 
				productionProductDao.delete(productionProduct); 
				} 
			persistProductions(production); 
			} 
		}

	public void removeProduct(ProductionProduct productionProduct) { 

		productChanges = true; 
		productionProductList.remove(productionProduct); 
				
		}
	
	@Override 
	public void setInstance(Production instance) { 
		if (instance != null) { 
			loadProductionProduct(instance); 
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

	public List<ProductionProduct> getProductionProducts() {
		return getInstance() == null ? null : new ArrayList<ProductionProduct>(getInstance().getProductionProducts());
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

	
	public ArrayList<ProductionProduct> getProductionProductList() {
		return productionProductList;
	}

	public void setProductionProductList(
			ArrayList<ProductionProduct> productionProductList) {
		this.productionProductList = productionProductList;
	}

}
