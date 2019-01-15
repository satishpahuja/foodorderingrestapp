package rest.food.ordering.dbo;

import java.math.BigInteger;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class CustomerDBO {
	
	@Id
	@GeneratedValue(generator = "CUST_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "CUST_SEQ", sequenceName = "CUSTOMER_SEQUENCE", allocationSize=1,initialValue=10000)
	@Column(name="CUSTOMER_ID",nullable = false)
	private BigInteger customerID;
	
	@Column(name="CUSTOMER_NAME",nullable = false, length = 100)
	private String customerName;
	
	@Column(name="EMAIL_ID",nullable = false, length = 100)
	private String 	emailId;
	
	@Column(name="PASSWORD",nullable = false, length = 100)
	private String password;
	
	@Column(name="MOBILE_NO",nullable = false, length = 10)
	private String mobileNo;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="customer", cascade = CascadeType.ALL)
	Set<AddressDBO> setAddress;

	
	public BigInteger getCustomerID() {
		return customerID;
	}

	public void setCustomerID(BigInteger customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Set<AddressDBO> getSetAddress() {
		return setAddress;
	}

	public void setSetAddress(Set<AddressDBO> setAddress) {
		this.setAddress = setAddress;
	}
}
