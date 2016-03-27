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
	private Date warrantyExpiry;
	private Date invoiceDate;
	private Integer invoiceNum;
	private Integer salesOrderNum;
	private Integer itemSKU;
	
	public ProductInfo(){
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

	public Date getWarrantyExpiry() {
		return warrantyExpiry;
	}

	public void setWarrantyExpiry(Date warrantyExpiry) {
		this.warrantyExpiry = warrantyExpiry;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
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
