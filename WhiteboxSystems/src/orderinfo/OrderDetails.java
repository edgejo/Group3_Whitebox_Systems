package orderinfo;

import java.util.*;

public class OrderDetails {	
	
	private Integer buildID;
	private CustomerInfo customerInfo;
	private PaymentInfo paymentInfo;
	private Collection<ProductInfo> components;
	
	public OrderDetails() {
		this.customerInfo = new CustomerInfo();
		this.paymentInfo = new PaymentInfo();
		this.components = new ArrayList<ProductInfo>();
	}
	
	public Integer getBuildID() {
		return buildID;
	}
	
	public void setBuildID(Integer buildID) {
		this.buildID = buildID;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public Collection<ProductInfo> getComponents() {
		return components;
	}

	public void setComponents(Collection<ProductInfo> components) {
		this.components = components;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buildID == null) ? 0 : buildID.hashCode());
		result = prime * result + ((components == null) ? 0 : components.hashCode());
		result = prime * result + ((customerInfo == null) ? 0 : customerInfo.hashCode());
		result = prime * result + ((paymentInfo == null) ? 0 : paymentInfo.hashCode());
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
		OrderDetails other = (OrderDetails) obj;
		if (buildID == null) {
			if (other.buildID != null)
				return false;
		} else if (!buildID.equals(other.buildID))
			return false;
		if (components == null) {
			if (other.components != null)
				return false;
		} else if (!components.equals(other.components))
			return false;
		if (customerInfo == null) {
			if (other.customerInfo != null)
				return false;
		} else if (!customerInfo.equals(other.customerInfo))
			return false;
		if (paymentInfo == null) {
			if (other.paymentInfo != null)
				return false;
		} else if (!paymentInfo.equals(other.paymentInfo))
			return false;
		return true;
	}
	
}
