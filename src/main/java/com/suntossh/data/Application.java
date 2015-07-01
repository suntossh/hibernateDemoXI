package com.suntossh.data;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.suntossh.data.entities.Address;
import com.suntossh.data.entities.Bank;
import com.suntossh.data.entities.TimeTest;
import com.suntossh.data.entities.User;

public class Application {

	
	public static void main_forBank_Success(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Bank bank = new Bank();
		Address address = new Address();
			bank.setName("BOA");
			bank.setCreatedBy("Santoshkumar");
			bank.setCreatedDate(new Date());
			bank.setLastUpdatedBy("Santosh");
			bank.setLastUpdatedDate(new Date());
			bank.setInternational(true);
			bank.setAddressType("PRIMARY");

			address.setCity("Jersey City");
			address.setState("NJ");
			address.setAddressLine1("Board walk ");
			address.setAddressLine2("Exchange place");
			address.setZipCode("07310");
			
			bank.setAddress(address);
		
			bank.getContacts().put("MANAGER","Santosh");
			bank.getContacts().put("CLAPPER","Pandey");
		session.save(bank);	
		transaction.commit();

		session.close();
	}
	
	public static void main_for_finance_user(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();


		Transaction transaction = session.beginTransaction();

		User user = new User();
		Address address = new Address();
		Address address2 = new Address();
			user.setBirthDate(getMyBirthDate());
			user.setCreatedBy("Santoshkumar");
			user.setCreatedDate(new Date());
			user.setEmailAddress("Suntossh.numerouno@gmail.com");
			user.setFirstName("Santosh");
			user.setLastName("Pandey");
			user.setLastUpdatedBy("Santosh");
			user.setLastUpdatedDate(new Date());

			address.setCity("Jersey City");
			address.setState("NJ");
			address.setAddressLine1("400 Vanilla Avnue");
			address.setAddressLine2("Grove St 6th Street");
			address.setZipCode("07306");
			
			address2.setCity("Jersey City");
			address2.setState("NJ");
			address2.setAddressLine1("30 Dream House");
			address2.setAddressLine2("Newport");
			address2.setZipCode("07310");
			
			
			user.getAddress().add(address);
			user.getAddress().add(address2);
		
		session.save(user);	
		transaction.commit();

		session.close();
	}
	
	public static Date getMyBirthDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR,1984);
		calendar.set(Calendar.MONTH,6);
		calendar.set(Calendar.DATE,22);
		return calendar.getTime();
		
	}
	
	public static void main(String[] args) {

		main_for_finance_user(null);
	}
	
}
