import java.util.*;

public class OrderDetails {	
	
	private int buildID;
	
	// customerInfo
	private String customerName;
	private String customerEmail;
	private String customerPhoneNumber;
	private String customerAddress;
	private Date deliveryDate;
	
	// paymentInfo
	private String paymentMethod;
	private Double totalValue;
	// path to PDF file
	private String deliveryConfirmation;
	
	// productInfo
	private Collection<ProductInfo> components;
	
	public OrderDetails(int buildID) {
		this.buildID = buildID;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
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

	public String getDeliveryConfirmation() {
		return deliveryConfirmation;
	}

	public void setDeliveryConfirmation(String deliveryConfirmation) {
		this.deliveryConfirmation = deliveryConfirmation;
	}

	public Collection<ProductInfo> getComponents() {
		return components;
	}

	public void setComponents(Collection<ProductInfo> components) {
		this.components = components;
	}

	public int getBuildID() {
		return buildID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
