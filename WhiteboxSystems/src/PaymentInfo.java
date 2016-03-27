
public class PaymentInfo {
	
	public enum PaymentType{
		NONE, VISA, MASTERCARD, AMEX, INTERAC, CASH
	}
	
	private PaymentType paymentMethod;
	private Double totalValue;
	// path to PDF file
	private String deliveryConfirmationFile;
	
	public PaymentInfo(PaymentType paymentMethod, Double totalValue, String deliveryConfirmationFile) {
		super();
		this.paymentMethod = paymentMethod;
		this.totalValue = totalValue;
		this.deliveryConfirmationFile = deliveryConfirmationFile;
	}
	
	public PaymentInfo() {
		this(PaymentType.NONE, 0.0, "");
	}

	public PaymentType getPaymentMethod() {
		return paymentMethod;
	}
	
	public void setPaymentMethod(PaymentType paymentMethod) {
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
	
}
