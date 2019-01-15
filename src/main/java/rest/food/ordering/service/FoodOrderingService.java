package rest.food.ordering.service;

import java.util.List;

import rest.food.ordering.dbo.FoodDBO;
import rest.food.ordering.dbo.FoodOrderDBO;
import rest.food.ordering.dbo.ServingLocationDBO;

public interface FoodOrderingService {

	public List<ServingLocationDBO> listAllServingLocationWRTCity();
	
	public List<FoodDBO> listAllFoodDtls();

	public void saveServingLocations(List<ServingLocationDBO> lstServingLocationDBO);

	public void saveFoodDtls(List<FoodDBO> lstFoodDBO);
	
	public boolean checkExitanceOfEmailId(String emailId);

	public void saveOrderDetails(FoodOrderDBO foodOrderDBO);

	public void sendMail(String emailId);
	
}
