package rest.food.ordering.dbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="FOOD_ORDER_DTLS")
public class FoodOrderDetailsDBO {
	
	@Id
	@GeneratedValue(generator = "FOOD_ORDER_DTLS_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "FOOD_ORDER_DTLS_SEQ", sequenceName = "FOOD_ORDER_DTLS_SEQUENCE", allocationSize=1)
	@Column(name="FOOD_ORDER_DETAILS_ID",nullable = false)
	private int foodOrderDetailsId;
	
	@Column(name="FOOD_QUANTITY",nullable = false)
	double foodQuantity;
	
	@ManyToOne
	@JoinColumn(name="FOOD_ORDER_ID",nullable = false)
	@JsonBackReference
	private FoodOrderDBO foodOrder;
	
	@ManyToOne
	@JoinColumn(name="FOOD_ID",nullable = false)
	private FoodDBO food;

	public double getFoodQuantity() {
		return foodQuantity;
	}

	public void setFoodQuantity(double foodQuantity) {
		this.foodQuantity = foodQuantity;
	}

	public FoodOrderDBO getFoodOrder() {
		return foodOrder;
	}

	public void setFoodOrder(FoodOrderDBO foodOrder) {
		this.foodOrder = foodOrder;
	}

	public FoodDBO getFood() {
		return food;
	}

	public void setFood(FoodDBO food) {
		this.food = food;
	}

	public long getFoodOrderDetailsId() {
		return foodOrderDetailsId;
	}

	public void setFoodOrderDetailsId(int foodOrderDetailsId) {
		this.foodOrderDetailsId = foodOrderDetailsId;
	}
}
