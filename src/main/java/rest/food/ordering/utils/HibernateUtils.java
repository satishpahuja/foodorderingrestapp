package rest.food.ordering.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import rest.food.ordering.dbo.AddressDBO;
import rest.food.ordering.dbo.CustomerDBO;
import rest.food.ordering.dbo.FoodDBO;
import rest.food.ordering.dbo.FoodOrderDBO;
import rest.food.ordering.dbo.FoodOrderDetailsDBO;
import rest.food.ordering.dbo.ServingLocationDBO;

public class HibernateUtils {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactoryObject(){
		try{
			if(null==sessionFactory){
				synchronized (HibernateUtils.class) {
					if(null==sessionFactory){
						Properties prop=new Properties();
						Configuration cfg= new Configuration();
						try {
							prop.load(new FileInputStream("D:\\Development Folder\\Projects_Workspace\\foodorderingrestapp\\hibernate.properties"));
						} catch (IOException e) {
							e.printStackTrace();
						}
						cfg.addProperties(prop)
						.addPackage("rest.food.ordering.model")
						.addAnnotatedClass(AddressDBO.class)
						.addAnnotatedClass(CustomerDBO.class)
						.addAnnotatedClass(FoodDBO.class)
						.addAnnotatedClass(FoodOrderDBO.class)
						.addAnnotatedClass(FoodOrderDetailsDBO.class)
						.addAnnotatedClass(ServingLocationDBO.class);
						ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
								cfg.getProperties()).build();
						sessionFactory=cfg.buildSessionFactory(serviceRegistry);
					}
				}
			}
			return sessionFactory;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}
