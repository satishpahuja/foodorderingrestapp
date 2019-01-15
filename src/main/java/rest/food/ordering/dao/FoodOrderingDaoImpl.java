package rest.food.ordering.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import rest.food.ordering.controller.FoodOrderingController;
import rest.food.ordering.dbo.AddressDBO;
import rest.food.ordering.dbo.CustomerDBO;
import rest.food.ordering.dbo.FoodDBO;
import rest.food.ordering.dbo.FoodOrderDBO;
import rest.food.ordering.dbo.FoodOrderDetailsDBO;
import rest.food.ordering.dbo.ServingLocationDBO;
import rest.food.ordering.enums.PaymentMethod;
import rest.food.ordering.enums.PaymentStatus;
import rest.food.ordering.utils.HibernateUtils;


public class FoodOrderingDaoImpl implements FoodOrderingDao{

	private static final Logger log = Logger.getLogger(FoodOrderingController.class);
	
	private static final SessionFactory sessionFactory=HibernateUtils.getSessionFactoryObject();

	public void saveServingLocation(List<ServingLocationDBO> lstServingLocation) {
		Session session = null;
		Transaction tx = null;
		try {
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			for (ServingLocationDBO servingLocation : lstServingLocation) {
				System.out.println(lstServingLocation+"lstServingLocation");
				session.save(servingLocation);
			}
			System.out.println("Before committing");
			tx.commit();
			System.out.println("After committing");
		} catch(RuntimeException e){
			e.printStackTrace();
			try{
				tx.rollback();
			}catch(RuntimeException rbe){
				throw rbe;
			}
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<ServingLocationDBO> listAllServingLocation() {
		try {
			Session session=sessionFactory.openSession();
			Criteria criteria=session.createCriteria(ServingLocationDBO.class);

			List<ServingLocationDBO> lstServingLocations = criteria.list();
			System.out.println("List Size is--"+lstServingLocations.size());
			return lstServingLocations;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void saveFoodDtls(List<FoodDBO> lstFood) {
		Session session = null;
		Transaction tx = null;
		try {
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			for (FoodDBO food : lstFood) {
				session.save(food);
			}
			tx.commit();
		} catch(RuntimeException e){
			e.printStackTrace();
			try{
				tx.rollback();
			}catch(RuntimeException rbe){
				throw rbe;
			}
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<FoodDBO> listAllFoodDtls() {
		try {
			Session session=sessionFactory.openSession();
			List<FoodDBO> lstFoodDtls=session.createCriteria(FoodDBO.class).list();
			System.out.println("Size--"+lstFoodDtls.size());
			return lstFoodDtls;
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void saveAddressWRTCustomer(AddressDBO address,long customerId) {
		Session session = null;
		Transaction tx = null;
		try {
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(address);
			tx.commit();
		} catch(RuntimeException e){
			e.printStackTrace();
			try{
				tx.rollback();
			}catch(RuntimeException rbe){
				throw rbe;
			}
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}	

	public void saveFoodOrder(FoodOrderDBO foodOrder) {
		Session session = null;
		Transaction tx = null;
		try {
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			System.out.println("Food Order is"+foodOrder+"---"+foodOrder.getSetOfOrderDetails());
			log.debug("Food Order is"+foodOrder+"---"+foodOrder.getSetOfOrderDetails());
			session.save(foodOrder);
			tx.commit();
		} catch(RuntimeException e){
			e.printStackTrace();
			try{
				tx.rollback();
			}catch(RuntimeException rbe){
				throw rbe;
			}
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}	

	public void saveCustomer(CustomerDBO customer) {
		Session session = null;
		Transaction tx = null;
		try {
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(customer);
			tx.commit();
		} catch(RuntimeException e){
			e.printStackTrace();
			try{
				tx.rollback();
			}catch(RuntimeException rbe){
				throw rbe;
			}
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}	

	public void updateCustomerMobileNo(String customerID, String mobileNo) {
		Session session = null;
		Transaction tx = null;
		try {
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query=session.createQuery("update Customer set mobileNo=:mobileNo where customerID=:customerID");
			query.setParameter("mobileNo", mobileNo);
			query.setParameter("customerID", customerID);
			int result=query.executeUpdate();
			System.out.println("Result is--"+result);
			tx.commit();
		} catch(RuntimeException e){
			e.printStackTrace();
			try{
				tx.rollback();
			}catch(RuntimeException rbe){
				throw rbe;
			}
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}	

	public void updateCustomerEmailId(String customerID, String emailId) {
		Session session = null;
		Transaction tx = null;
		try {
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query=session.createQuery("update Customer set emailId=:emailId where customerID=:customerID");
			query.setParameter("emailId", emailId);
			query.setParameter("customerID", customerID);
			int result=query.executeUpdate();
			System.out.println("Result is--"+result);
			tx.commit();
		} catch(RuntimeException e){
			e.printStackTrace();
			try{
				tx.rollback();
			}catch(RuntimeException rbe){
				throw rbe;
			}
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}	

	public void updatePassword(String customerID, String password) {
		Session session = null;
		Transaction tx = null;
		try {
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query=session.createQuery("update Customer set password=:password where customerID=:customerID");
			query.setParameter("emailId", password);
			query.setParameter("customerID", customerID);
			int result=query.executeUpdate();
			System.out.println("Result is--"+result);
			tx.commit();
		} catch(RuntimeException e){
			e.printStackTrace();
			try{
				tx.rollback();
			}catch(RuntimeException rbe){
				throw rbe;
			}
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}

	@Override
	public boolean checkExitanceOfEmailId(String emailId) {

		Session session = null;
		Transaction tx = null;
		try {
			session=sessionFactory.openSession();
			tx = session.beginTransaction();
			Object isExist=session.createCriteria(CustomerDBO.class).add(Restrictions.eq("emailId", emailId)).setProjection(Projections.property(emailId)).uniqueResult();
			if(isExist!=null)
				return true;
			else
				return false;
		} catch(RuntimeException e){
			e.printStackTrace();
			try{
				tx.rollback();
			}catch(RuntimeException rbe){
				throw rbe;
			}
			throw e;
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}
}
