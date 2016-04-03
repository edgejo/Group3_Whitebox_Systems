package orderinfo;

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
	
	public ProductInfo(){
	}
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((componentType == null) ? 0 : componentType.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((invoiceDate == null) ? 0 : invoiceDate.hashCode());
		result = prime * result + ((invoiceNum == null) ? 0 : invoiceNum.hashCode());
		result = prime * result + ((itemSKU == null) ? 0 : itemSKU.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((modelNum == null) ? 0 : modelNum.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((rebateValue == null) ? 0 : rebateValue.hashCode());
		result = prime * result + ((salesOrderNum == null) ? 0 : salesOrderNum.hashCode());
		result = prime * result + ((serialNum == null) ? 0 : serialNum.hashCode());
		result = prime * result + ((warrantyExpiry == null) ? 0 : warrantyExpiry.hashCode());
		result = prime * result + ((warrantyPeriod == null) ? 0 : warrantyPeriod.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductInfo other = (ProductInfo) obj;
		if (componentType == null) {
			if (other.componentType != null)
				return false;
		} else if (!componentType.equals(other.componentType))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (invoiceDate == null) {
			if (other.invoiceDate != null)
				return false;
		} else if (!invoiceDate.equals(other.invoiceDate))
			return false;
		if (invoiceNum == null) {
			if (other.invoiceNum != null)
				return false;
		} else if (!invoiceNum.equals(other.invoiceNum))
			return false;
		if (itemSKU == null) {
			if (other.itemSKU != null)
				return false;
		} else if (!itemSKU.equals(other.itemSKU))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (modelNum == null) {
			if (other.modelNum != null)
				return false;
		} else if (!modelNum.equals(other.modelNum))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (rebateValue == null) {
			if (other.rebateValue != null)
				return false;
		} else if (!rebateValue.equals(other.rebateValue))
			return false;
		if (salesOrderNum == null) {
			if (other.salesOrderNum != null)
				return false;
		} else if (!salesOrderNum.equals(other.salesOrderNum))
			return false;
		if (serialNum == null) {
			if (other.serialNum != null)
				return false;
		} else if (!serialNum.equals(other.serialNum))
			return false;
		if (warrantyExpiry == null) {
			if (other.warrantyExpiry != null)
				return false;
		} else if (!warrantyExpiry.equals(other.warrantyExpiry))
			return false;
		if (warrantyPeriod == null) {
			if (other.warrantyPeriod != null)
				return false;
		} else if (!warrantyPeriod.equals(other.warrantyPeriod))
			return false;
		return true;
	}
	
}
