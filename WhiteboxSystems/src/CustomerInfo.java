
import java.util.Date;

public class CustomerInfo {
	private String name;
	private String email;
	private String phoneNum;
	private String address;
	private Date deliveryDate;
	
	public CustomerInfo(String name, String email, String phoneNum, String address, Date deliveryDate) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNum = phoneNum;
		this.address = address;
		this.deliveryDate = deliveryDate;
	}
	
	public CustomerInfo(String name, String email, String phoneNum, String address) {
		this(name, email, phoneNum, address, new Date());
	}

	public CustomerInfo() {
		this("", "", "", "", new Date());
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
}
