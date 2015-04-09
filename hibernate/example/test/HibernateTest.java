//package com.zht.framework.hibernate.example.test;
//
//import net.sf.ehcache.hibernate.HibernateUtil;
//
//import org.hibernate.Session;
//
//public class HibernateTest {
//	
//	
//	 public static void main(String[] args) {  
////	      addProfileByUser();  
////	      addUserByProfile();  
//	        deleteFromUser();  
//	    }  
//	      
////	    public static void deleteFromUser()  
////	    {  
////	        Session session = HibernateUtil.getSessionFactory().openSession();  
////	        session.getTransaction().begin();  
////	        session.delete(session.load(User.class, new Integer(1)));  
////	        session.getTransaction().commit();  
////	    }  
//	      
//	    public static void addProfileByUser()  
//	    {         
//	        Profile p = new Profile();  
//	        p.setAddress("yunnan");  
//	        p.setEmail("sdfds@1236.com");  
//	          
//	        User user = new User();  
//	        user.setName("zyp");  
//	        user.setPassword("123");  
//	          
//	        //注意这里是双向关系  
//	        user.setProfile(p);  
//	        p.setUser(user);  
//	          
//	        Session session = HibernateUtil.getSessionFactory().openSession();  
//	        session.getTransaction().begin();  
//	        session.save(user);  
//	        session.getTransaction().commit();  
//	          
//	    }  
//	      
//	    public static void addUserByProfile()  
//	    {  
//	        Profile p = new Profile();  
//	        p.setAddress("yunnan");  
//	        p.setEmail("sdfds@1236.com");  
//	          
//	        User user = new User();  
//	        user.setName("zyp");  
//	        user.setPassword("123");  
//	          
//	        //注意这里是双向关系  
//	        user.setProfile(p);  
//	        p.setUser(user);  
//	          
//	        Session session = HibernateUtil.getSessionFactory().openSession();  
//	        session.getTransaction().begin();  
//	        //保存profile  
//	        session.save(p);  
//	        session.getTransaction().commit();  
//	    }  
//}
