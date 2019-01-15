package rest.food.ordering.dbo;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import rest.food.ordering.enums.PaymentMethod;
import rest.food.ordering.enums.PaymentStatus;

@Entity
@Table(name="FOOD_ORDER")
public class FoodOrderDBO {

	@Id
	@Column(name="FOOD_ORDER_ID",nullable = false)
	private String foodOrderId;

	@Column(name="CUSTOMER_ID",nullable = false, length = 100)
	private String customerId;
	
	@Column(name="PAYMENT_METHOD",nullable = false)
	@Enumerated(EnumType.STRING)
	private  PaymentMethod paymentMethod;

	@Column(name="PAYMENT_STATUS",nullable = false)
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;

	@Column(name="PURCHASE_TIME_STAMP",nullable = false)
	private Date purchaseTimeStamp;

	@Column(name="TOTAL_PRICE",nullable = false)
	private double totalPrice;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="foodOrder", cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<FoodOrderDetailsDBO> setOfOrderDetails;

	@OneToOne
	@JoinColumn(name="SERVING_LOCATION",nullable = false)
	private ServingLocationDBO servingLocation;

	public Set<FoodOrderDetailsDBO> getSetOfOrderDetails() {
		return setOfOrderDetails;
	}


	public void setSetOfOrderDetails(Set<FoodOrderDetailsDBO> setOfOrderDetails) {
		this.setOfOrderDetails = setOfOrderDetails;
	}

	public String getFoodOrderId() {
		return foodOrderId;
	}

	public void setFoodOrderId(String foodOrderId) {
		this.foodOrderId = foodOrderId;
	}


	public ServingLocationDBO getServingLocation() {
		return servingLocation;
	}


	public void setServingLocation(ServingLocationDBO servingLocation) {
		this.servingLocation = servingLocation;
	}


	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Date getPurchaseTimeStamp() {
		return purchaseTimeStamp;
	}

	public void setPurchaseTimeStamp(Date purchaseTimeStamp) {
		this.purchaseTimeStamp = purchaseTimeStamp;
	}

}
