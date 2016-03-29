package orderinfo;

import java.util.Date;

public class ProductInfo {
	private String componentType;
	private String manufacturer;
	private String description;
	private String modelNum;
	private String serialNum;
	private Double rebateValue;
	private Double price;
	private String warrantyPeriod;
	private String warrantyExpiry;
	private String invoiceDate;
	private Integer invoiceNum;
	private Integer salesOrderNum;
	private Integer itemSKU;
	
	public ProductInfo(String componentType, String manufacturer, String description, 
			String modelNum, String serialNum, Double rebateValue, Double price, 
			String warrantyPeriod, String warrantyExpiry, String invoiceDate, Integer invoiceNum, 
			Integer salesOrderNum, Integer itemSKU){
		this.componentType = componentType;
		this.manufacturer = manufacturer;
		this.description = description;
		this.modelNum = modelNum;
		this.serialNum = serialNum;
		this.rebateValue = rebateValue;
		this.price = price;
		this.warrantyPeriod = warrantyPeriod;
		this.warrantyExpiry = warrantyExpiry;
		this.invoiceDate = invoiceDate;
		this.invoiceNum = invoiceNum;
		this.salesOrderNum = salesOrderNum;
		this.itemSKU = itemSKU;
	}

	public String getComponentType() {
		return componentType;
	}

	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModelNum() {
		return modelNum;
	}

	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public Double getRebateValue() {
		return rebateValue;
	}

	public void setRebateValue(Double rebateValue) {
		this.rebateValue = rebateValue;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getWarrantyPeriod() {
		return warrantyPeriod;
	}

	public void setWarrantyPeriod(String warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}

	public String getWarrantyExpiry() {
		return warrantyExpiry;
	}

	public void setWarrantyExpiry(String warrantyExpiry) {
		this.warrantyExpiry = warrantyExpiry;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Integer getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(Integer invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public Integer getSalesOrderNum() {
		return salesOrderNum;
	}

	public void setSalesOrderNum(Integer salesOrderNum) {
		this.salesOrderNum = salesOrderNum;
	}

	public Integer getItemSKU() {
		return itemSKU;
	}

	public void setItemSKU(Integer itemSKU) {
		this.itemSKU = itemSKU;
	}
}
