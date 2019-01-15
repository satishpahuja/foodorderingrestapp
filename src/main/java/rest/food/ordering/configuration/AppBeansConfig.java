package rest.food.ordering.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import rest.food.ordering.dao.FoodOrderingDao;
import rest.food.ordering.dao.FoodOrderingDaoImpl;

@Configuration
public class AppBeansConfig {

	@Bean
	public FoodOrderingDao getFoodOrderingDaoObj() {
		return new FoodOrderingDaoImpl();
	}
}
