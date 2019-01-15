package rest.food.ordering.dao;

import java.util.List;

import rest.food.ordering.dbo.FoodDBO;
import rest.food.ordering.dbo.FoodOrderDBO;
import rest.food.ordering.dbo.ServingLocationDBO;

public interface FoodOrderingDao {

	public List<ServingLocationDBO> listAllServingLocation();
	
	public List<FoodDBO> listAllFoodDtls();
	
	public void saveServingLocation(List<ServingLocationDBO> lstServingLocationDBO);

	public void saveFoodDtls(List<FoodDBO> lstFoodDBO);

	public boolean checkExitanceOfEmailId(String emailId);

	public void saveFoodOrder(FoodOrderDBO foodOrderDBO);
}
