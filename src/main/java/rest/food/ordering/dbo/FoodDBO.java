package rest.food.ordering.dbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FOOD")
public class FoodDBO {

	@Id
	@GeneratedValue(generator = "FOOD_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "FOOD_SEQ", sequenceName = "FOOD_SEQUENCE", allocationSize=1,initialValue=1)
	@Column(name="FOOD_ID",nullable = false)
	private long foodID;

	@Column(name="FOOD_NAME",nullable = false, length = 100)
	private String foodName;

	@Column(name="FOOD_CATEGORY",nullable = false, length = 100)
	private String foodCategory;

	@Column(name="FOOD_PRICE",nullable = false)
	private double price;

	public long getFoodID() {
		return foodID;
	}
	public void setFoodID(long foodID) {
		this.foodID = foodID;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodCategory() {
		return foodCategory;
	}
	
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
