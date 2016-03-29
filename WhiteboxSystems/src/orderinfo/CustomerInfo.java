package orderinfo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerInfo {
	private String name;
	private String email;
	private String phoneNum;
	private String address;
	private String deliveryDate;
	
	public CustomerInfo(String name, String email, String phoneNum, String address, String deliveryDate) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNum = phoneNum;
		this.address = address;
		this.deliveryDate = deliveryDate;
	}
	
	public CustomerInfo(String name, String email, String phoneNum, String address) {
		this(name, email, phoneNum, address, getTodayDate());
	}

	public CustomerInfo() {
		this("", "", "", "", getTodayDate());
	}

	public static String getTodayDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		return sdf.format(date);
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
	
	public String getDeliveryDate() {
		return deliveryDate;
	}
	
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
}
