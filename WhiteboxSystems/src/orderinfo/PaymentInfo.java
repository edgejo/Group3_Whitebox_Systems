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
	public boolean equals(Object o){
        if (o == this) {
            return true;
        }
 
        if (!(o instanceof PaymentInfo)) {
            return false;
        }
         
        PaymentInfo paymentInfo = (PaymentInfo) o;
		
		return (this.getPaymentMethod().equals(paymentInfo.getPaymentMethod())
				&& this.getTotalValue().equals(paymentInfo.getTotalValue())
				&& this.getDeliveryConfirmationFile().equals(paymentInfo.getDeliveryConfirmationFile()));
	}
	
}
