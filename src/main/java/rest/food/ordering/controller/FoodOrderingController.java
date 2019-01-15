package rest.food.ordering.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rest.food.ordering.dbo.FoodDBO;
import rest.food.ordering.dbo.FoodOrderDBO;
import rest.food.ordering.dbo.ServingLocationDBO;
import rest.food.ordering.service.FoodOrderingService;


@RestController
public class FoodOrderingController {

	private static final Logger log = Logger.getLogger(FoodOrderingController.class);

	@Autowired
	FoodOrderingService foodOrderingService;  //Service which will do all data retrieval/manipulation work

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/saveservinglocations/", method = RequestMethod.POST)
	public void saveServingLocations(@RequestBody List<ServingLocationDBO> lstServingLocationDBO) {
		try {
			foodOrderingService.saveServingLocations(lstServingLocationDBO);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getservinglocations/", method = RequestMethod.GET)
	public ResponseEntity<List<ServingLocationDBO>> listAllServingLocationWRTCity() {
		try {
			List<ServingLocationDBO> lstServingLocationDBO=foodOrderingService.listAllServingLocationWRTCity();
			return new ResponseEntity<List<ServingLocationDBO>>(lstServingLocationDBO,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<ServingLocationDBO>>(HttpStatus.NO_CONTENT);
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/savefooddtls/", method = RequestMethod.POST)
	public ResponseEntity<Void> saveFoodDtls(@RequestBody List<FoodDBO> lstFoodDBO) {
		try {
			foodOrderingService.saveFoodDtls(lstFoodDBO);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getfooddtls/", method = RequestMethod.GET)
	public ResponseEntity<List<FoodDBO>> listAllFoodDtls() {
		try {
			List<FoodDBO> lstFoodDtls=foodOrderingService.listAllFoodDtls();
			return new ResponseEntity<List<FoodDBO>>(lstFoodDtls,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<FoodDBO>>(HttpStatus.NO_CONTENT);
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/checkExistanceOfEmailId/", method = RequestMethod.POST)
	public boolean checkExistanceOfEmailId(@RequestBody String emailId) {
		try {
			System.out.println("Email ID"+emailId);
			return foodOrderingService.checkExitanceOfEmailId(emailId);
		} catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/submitorderandsendmail/", method = RequestMethod.POST)
	public boolean submitOrderAndSendMail(@RequestBody FoodOrderDBO foodOrderDBO ) {
		try {
			log.debug("Food Ordering DBO"+foodOrderDBO);
			System.out.println("Food Ordering DBO"+foodOrderDBO);
			String emailId="satishpahuja91@gmail.com";
			foodOrderingService.saveOrderDetails(foodOrderDBO);
			foodOrderingService.sendMail(emailId);
		} catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}


	//-------------------Retrieve All Users--------------------------------------------------------

	//	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	//	public ResponseEntity<List<User>> listAllUsers() {
	//		List<User> users = foodOrderingService.findAllUsers();
	//		if(users.isEmpty()){
	//			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	//		}
	//		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	//	}


	//-------------------Retrieve Single User--------------------------------------------------------

	//	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	//	public ResponseEntity<User> getUser(@PathVariable("id") long id) {
	//		System.out.println("Fetching User with id " + id);
	//		User user = foodOrderingService.findById(id);
	//		if (user == null) {
	//			System.out.println("User with id " + id + " not found");
	//			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	//		}
	//		return new ResponseEntity<User>(user, HttpStatus.OK);
	//	}



	//-------------------Create a User--------------------------------------------------------

	//	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	//	public ResponseEntity<Void> createUser(@RequestBody User user, 	UriComponentsBuilder ucBuilder) {
	//		System.out.println("Creating User " + user.getName());
	//
	//		if (foodOrderingService.isUserExist(user)) {
	//			System.out.println("A User with name " + user.getName() + " already exist");
	//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	//		}
	//
	//		foodOrderingService.saveUser(user);
	//
	//		HttpHeaders headers = new HttpHeaders();
	//		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
	//		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	//	}
	//
	//	
	//	//------------------- Update a User --------------------------------------------------------
	//	
	//	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	//	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
	//		System.out.println("Updating User " + id);
	//		
	//		User currentUser = foodOrderingService.findById(id);
	//		
	//		if (currentUser==null) {
	//			System.out.println("User with id " + id + " not found");
	//			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	//		}
	//
	//		currentUser.setName(user.getName());
	//		currentUser.setAge(user.getAge());
	//		currentUser.setSalary(user.getSalary());
	//		
	//		foodOrderingService.updateUser(currentUser);
	//		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	//	}
	//
	//	//------------------- Delete a User --------------------------------------------------------
	//	
	//	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	//	public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
	//		System.out.println("Fetching & Deleting User with id " + id);
	//
	//		User user = foodOrderingService.findById(id);
	//		if (user == null) {
	//			System.out.println("Unable to delete. User with id " + id + " not found");
	//			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	//		}
	//
	//		foodOrderingService.deleteUserById(id);
	//		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	//	}
	//
	//	
	//	//------------------- Delete All User --------------------------------------------------------
	//	
	//	@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	//	public ResponseEntity<User> deleteAllUsers() {
	//		System.out.println("Deleting All Users");
	//
	//		foodOrderingService.deleteAllUsers();
	//		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	//	}


}
