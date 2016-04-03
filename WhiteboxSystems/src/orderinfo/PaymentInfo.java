package orderinfo;

public class PaymentInfo {
	
	private String paymentMethod;
	private Double totalValue;
	// path to PDF file
	private String deliveryConfirmationFile;
	
	public PaymentInfo(String paymentMethod, Double totalValue, String deliveryConfirmationFile) {
		super();
		this.paymentMethod = paymentMethod;
		this.totalValue = totalValue;
		this.deliveryConfirmationFile = deliveryConfirmationFile;
	}
	
	public PaymentInfo() {
		this("None", 0.0, "");
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public Double getTotalValue() {
		return totalValue;
	}
	
	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	public String getDeliveryConfirmationFile() {
		return deliveryConfirmationFile;
	}
	
	public void setDeliveryConfirmationFile(String deliveryConfirmationFile) {
		this.deliveryConfirmationFile = deliveryConfirmationFile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deliveryConfirmationFile == null) ? 0 : deliveryConfirmationFile.hashCode());
		result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
		result = prime * result + ((totalValue == null) ? 0 : totalValue.hashCode());
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
		PaymentInfo other = (PaymentInfo) obj;
		if (deliveryConfirmationFile == null) {
			if (other.deliveryConfirmationFile != null)
				return false;
		} else if (!deliveryConfirmationFile.equals(other.deliveryConfirmationFile))
			return false;
		if (paymentMethod == null) {
			if (other.paymentMethod != null)
				return false;
		} else if (!paymentMethod.equals(other.paymentMethod))
			return false;
		if (totalValue == null) {
			if (other.totalValue != null)
				return false;
		} else if (!totalValue.equals(other.totalValue))
			return false;
		return true;
	}	
	
}
