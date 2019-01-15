
package rest.food.ordering.dbo;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class AddressDBO {

	@Id
	@GeneratedValue(generator = "ADD_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ADD_SEQ", sequenceName = "ADDRESS_SEQUENCE", allocationSize=1,initialValue=1)
	@Column(name="ADDRESS_ID",nullable = false)
	private BigInteger addressId;

	@Column(name="ADDRESS_WITH_LAND_MARK",nullable = false, length = 100)
	private String addressWithLandmark;

	@Column(name="PIN_CODE",nullable = false, length = 6)
	private String pinCode;

	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID", nullable=false)
	private CustomerDBO customer;


	public CustomerDBO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDBO customer) {
		this.customer = customer;
	}
	
	public BigInteger getAddressId() {
		return addressId;
	}

	public void setAddressId(BigInteger addressId) {
		this.addressId = addressId;
	}

	public String getAddressWithLandmark() {
		return addressWithLandmark;
	}

	public void setAddressWithLandmark(String addressWithLandmark) {
		this.addressWithLandmark = addressWithLandmark;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
}
