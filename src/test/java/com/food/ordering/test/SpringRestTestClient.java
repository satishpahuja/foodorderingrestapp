package com.food.ordering.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import rest.food.ordering.dbo.FoodDBO;
import rest.food.ordering.dbo.FoodOrderDBO;
import rest.food.ordering.dbo.FoodOrderDetailsDBO;
import rest.food.ordering.dbo.ServingLocationDBO;
import rest.food.ordering.enums.PaymentMethod;
import rest.food.ordering.enums.PaymentStatus;

public class SpringRestTestClient {

	public static final String REST_SERVICE_URI = "http://localhost:8081/foodorderingrestapp";

	/* GET *1
	 */
	private static void saveServingLocations(List<ServingLocationDBO> lstServingLocation){
		try {
			RestTemplate restTemplate = new RestTemplate();
			MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
			restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
			restTemplate.postForLocation(REST_SERVICE_URI+"/saveservinglocations/",lstServingLocation);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
	}

	private static void listServingLocations(){

		RestTemplate restTemplate = new RestTemplate();

		String jsonStringServingLocation = restTemplate.getForObject(REST_SERVICE_URI+"/getservinglocations/", String.class);

		System.out.println(jsonStringServingLocation);
	}

	private static void saveFoodDetails(List<FoodDBO> lstFoodDBO) {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
		restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
		restTemplate.postForLocation(REST_SERVICE_URI+"/savefooddtls/",lstFoodDBO);
	}

	private static void listAllFoodDetails() {
		RestTemplate restTemplate = new RestTemplate();
		String jsonFoodDetails = restTemplate.getForObject(REST_SERVICE_URI+"/getfooddtls/", String.class);
		System.out.println(jsonFoodDetails+"--+jsonFoodDetails");
	}

	private static void saveFoodOrderDetails(){
		try {
			//			ServingLocationDBO servingLocation=new ServingLocationDBO();
			//			servingLocation.setLocationId(1);
			//			
			//			FoodDBO foodDBO=new FoodDBO();
			//			foodDBO.setFoodID(1);
			//
			//			FoodOrderDBO foodOrderDBO=new FoodOrderDBO();
			//			
			//			Set<FoodOrderDetailsDBO> setFoodOrderDetailsDBO=new HashSet<FoodOrderDetailsDBO>();
			//			
			//			foodOrderDBO.setCustomerId("123456789");
			//			foodOrderDBO.setFoodOrderId("123456789");
			//			foodOrderDBO.setPaymentMethod(PaymentMethod.CASH);
			//			foodOrderDBO.setPurchaseTimeStamp(new Date());
			//			foodOrderDBO.setPaymentStatus(PaymentStatus.SUCCESS);
			//			foodOrderDBO.setServingLocation(servingLocation);
			//			foodOrderDBO.setTotalPrice(95.00);
			//			
			//			FoodOrderDetailsDBO foodOrderDetailsDBO=new FoodOrderDetailsDBO();
			//			foodOrderDetailsDBO.setFoodQuantity(5);
			//			foodOrderDetailsDBO.setFood(foodDBO);
			//			foodOrderDetailsDBO.setFoodOrder(foodOrderDBO);
			//			setFoodOrderDetailsDBO.add(foodOrderDetailsDBO);
			//			
			//			foodOrderDBO.setSetOfOrderDetails(setFoodOrderDetailsDBO);
			//			
						RestTemplate restTemplate = new RestTemplate();
						MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
						restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
			//			
			//			//JSONObject jsonObj = new JSONObject( foodOrderDBO );
			// System.out.println( jsonObj );

			FoodOrderDBO	foodOrderDBO=new FoodOrderDBO();
			Boolean booResponse = restTemplate.postForObject(REST_SERVICE_URI+"/submitorderandsendmail/",foodOrderDBO,Boolean.class);

			System.out.println("Response after submitting order details"+booResponse);
			//restTemplate.postForLocation(REST_SERVICE_URI+"/saveservinglocations/",lstServingLocation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String args[]){
		System.out.println("-------Menu-------");
		System.out.println("1.	Save Serving Locations");
		System.out.println("2.	List All Serving Locations");
		System.out.println("3.	Save Food Details");
		System.out.println("4.	List All Food Details");
		System.out.println("5.	Save Address WRT Customer");
		System.out.println("6.	Save Food Order");
		System.out.println("7.	Save Customer");
		System.out.println("8.	Update Customer Mobile No");
		System.out.println("9.	Update Customer Email id");
		System.out.println("10.	Update Password");
		System.out.println("11.	Save Food Order Details");
		System.out.println("12.	Exit");

		Scanner reader = new Scanner(System.in);  

		char ch='y';

		while(ch=='y'||ch=='Y'){
			System.out.println("Enter your choice: ");
			String choice = reader.nextLine();

			switch(choice){
			case "1":
				List<ServingLocationDBO> lstServingLocation=new ArrayList<ServingLocationDBO>();
				System.out.println("Enter no of Locations");
				int countOfLocations=Integer.parseInt(reader.nextLine());
				System.out.println("Enter "+countOfLocations+ " Locations");
				for (int i = 1; i <= countOfLocations; i++) {
					String locationName=reader.nextLine();
					ServingLocationDBO servingLocation=new ServingLocationDBO();
					servingLocation.setLocationName(locationName);
					lstServingLocation.add(servingLocation);
				}
				saveServingLocations(lstServingLocation);
				break;
			case "2":
				listServingLocations();
				break;
			case "3":
				System.out.println("Enter Food Count");
				int countOfFood=Integer.parseInt(reader.nextLine());
				List<FoodDBO> lstFoodDBO=new ArrayList<FoodDBO>();
				for (int i = 1; i <= countOfFood; i++) {
					System.out.println("Enter "+i+"Food Name");
					String foodName=reader.nextLine();

					System.out.println("Enter "+i+"Food Category");
					String foodCategory=reader.nextLine();

					System.out.println("Enter "+i+"Food Price");
					Double foodPrice=Double.parseDouble(reader.nextLine());

					FoodDBO foodDBO=new FoodDBO();
					foodDBO.setFoodName(foodName);
					foodDBO.setFoodCategory(foodCategory);
					foodDBO.setPrice(foodPrice);
					lstFoodDBO.add(foodDBO);
				}
				saveFoodDetails(lstFoodDBO);
				break;
			case "4":
				listAllFoodDetails();
				break;
			case "5":
				break;
			case "6":
				break;
			case "7":
				break;
			case "8":
				break;
			case "9":
				break;
			case "10":
				break;
			case "11":
				saveFoodOrderDetails();
				break;
			case "12":
				ch='n';
				break;
			}
		}
		reader.close();
	}

}