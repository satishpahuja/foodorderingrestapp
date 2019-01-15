package rest.food.ordering.utils;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.client.RestClientException;

import rest.food.ordering.dao.FoodOrderingDaoImpl;
import rest.food.ordering.dbo.FoodDBO;
import rest.food.ordering.dbo.FoodOrderDBO;
import rest.food.ordering.dbo.FoodOrderDetailsDBO;
import rest.food.ordering.dbo.ServingLocationDBO;
import rest.food.ordering.enums.PaymentMethod;
import rest.food.ordering.enums.PaymentStatus;

public class Test {
	
	public static void main(String args[]) {
	
		try {
			ServingLocationDBO servingLocation=new ServingLocationDBO();
			servingLocation.setLocationId(1);
			
			FoodDBO foodDBO=new FoodDBO();
			foodDBO.setFoodID(1);

			FoodOrderDBO foodOrderDBO=new FoodOrderDBO();
			
			Set<FoodOrderDetailsDBO> setFoodOrderDetailsDBO=new HashSet<FoodOrderDetailsDBO>();
			
			foodOrderDBO.setCustomerId("123456789");
			foodOrderDBO.setFoodOrderId("123456789");
			foodOrderDBO.setPaymentMethod(PaymentMethod.CASH);
			foodOrderDBO.setPurchaseTimeStamp(new Date());
			foodOrderDBO.setPaymentStatus(PaymentStatus.SUCCESS);
			foodOrderDBO.setServingLocation(servingLocation);
			foodOrderDBO.setTotalPrice(95.00);
			
			FoodOrderDetailsDBO foodOrderDetailsDBO=new FoodOrderDetailsDBO();
			foodOrderDetailsDBO.setFoodQuantity(5);
			foodOrderDetailsDBO.setFood(foodDBO);
			foodOrderDetailsDBO.setFoodOrder(foodOrderDBO);
			setFoodOrderDetailsDBO.add(foodOrderDetailsDBO);
			
			foodOrderDBO.setSetOfOrderDetails(setFoodOrderDetailsDBO);
			
			new FoodOrderingDaoImpl().saveFoodOrder(foodOrderDBO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
