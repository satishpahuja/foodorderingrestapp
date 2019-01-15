package rest.food.ordering.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.food.ordering.dao.FoodOrderingDao;
import rest.food.ordering.dbo.FoodDBO;
import rest.food.ordering.dbo.FoodOrderDBO;
import rest.food.ordering.dbo.ServingLocationDBO;

@Service("foodOrderingService")
public class FoodOrderingServiceImpl implements FoodOrderingService{
	
	@Autowired
	FoodOrderingDao foodOrderingDao;

	public List<ServingLocationDBO> listAllServingLocationWRTCity() {
		List<ServingLocationDBO> lstServinglocationDBO=foodOrderingDao.listAllServingLocation();
		return lstServinglocationDBO;
	}

	public List<FoodDBO> listAllFoodDtls() {
		List<FoodDBO> lstFoodDtls=foodOrderingDao.listAllFoodDtls();
		return lstFoodDtls;
	}

	@Override
	public void saveServingLocations(List<ServingLocationDBO> lstServingLocationDBO) {
		foodOrderingDao.saveServingLocation(lstServingLocationDBO);
	}

	@Override
	public void saveFoodDtls(List<FoodDBO> lstFoodDBO) {
		foodOrderingDao.saveFoodDtls(lstFoodDBO);
	}

	@Override
	public boolean checkExitanceOfEmailId(String emailId) {
		return foodOrderingDao.checkExitanceOfEmailId(emailId);
	}

	@Override
	public void saveOrderDetails(FoodOrderDBO foodOrderDBO) {
		foodOrderingDao.saveFoodOrder(foodOrderDBO);
	}

	@Override
	public void sendMail(String toEmailId) {
		//Setting up configurations for the email connection to the Google SMTP server using TLS
        Properties props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        //Establishing a session with required user details
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("orderfoddie@gmail.com", "foddie@2019");
            }
        });
        try {
            //Creating a Message object to set the email content
            MimeMessage msg = new MimeMessage(session);
            //Storing the comma seperated values to email addresses
            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
            addresses in an array of InternetAddress objects*/
            InternetAddress[] address = InternetAddress.parse(toEmailId, true);
            //Setting the recepients from the address variable
            msg.setRecipients(Message.RecipientType.TO, address);
            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
            msg.setSubject("Order Confirmation Mail " + timeStamp);
            msg.setSentDate(new Date());
            msg.setText("Your order has been placed successfully");
            msg.setHeader("XPriority", "1");
            Transport.send(msg);
            System.out.println("Mail has been sent successfully");
        } catch (MessagingException mex) {
            System.out.println("Unable to send an email" + mex);
        }
		
	}
}
