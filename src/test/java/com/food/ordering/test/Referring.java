package com.food.ordering.test;

public class Referring {
	/* POST */
	/*private static void listServingLocation(String city) {

		System.out.println("Testing listServingLocation");
		RestTemplate restTemplate = new RestTemplate();
		String listServingLocations =  restTemplate.postForObject(REST_SERVICE_URI+"/getservinglocations/", city, String.class);
		if(listServingLocations!=null){
			System.out.println("City--"+listServingLocations);
		}else{
			System.out.println("No Serving Location");
		}
	}

	 POST 
	private static void listFoodDtls() {

		System.out.println("Testing listFoodDtls");
		RestTemplate restTemplate = new RestTemplate();
		String listFoodDtls =  restTemplate.getForObject(REST_SERVICE_URI+"/getfooddtls/",String.class);
		if(listFoodDtls!=null){
			System.out.println("listFoodDtls--"+listFoodDtls);
		}else{
			System.out.println("No Food Dtls");
		}
	}*/

	/* GET */
	//	private static void getUser(){
	//		System.out.println("Testing getUser API----------");
	//		RestTemplate restTemplate = new RestTemplate();
	//        User user = restTemplate.getForObject(REST_SERVICE_URI+"/user/1", User.class);
	//        System.out.println(user);
	//	}

	/* POST */
	//    private static void createUser() {
	//		System.out.println("Testing create User API----------");
	//    	RestTemplate restTemplate = new RestTemplate();
	//        User user = new User(0,"Sarah",51,134);
	//        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/user/", user, User.class);
	//        System.out.println("Location : "+uri.toASCIIString());
	//    }

	/* PUT */
	//    private static void updateUser() {
	//		System.out.println("Testing update User API----------");
	//        RestTemplate restTemplate = new RestTemplate();
	//        User user  = new User(1,"Tomy",33, 70000);
	//        restTemplate.put(REST_SERVICE_URI+"/user/1", user);
	//        System.out.println(user);
	//    }

	/* DELETE */
	//    private static void deleteUser() {
	//		System.out.println("Testing delete User API----------");
	//        RestTemplate restTemplate = new RestTemplate();
	//        restTemplate.delete(REST_SERVICE_URI+"/user/3");
	//    }


	/* DELETE */
	//    private static void deleteAllUsers() {
	//		System.out.println("Testing all delete Users API----------");
	//        RestTemplate restTemplate = new RestTemplate();
	//        restTemplate.delete(REST_SERVICE_URI+"/user/");
	//    }

}
