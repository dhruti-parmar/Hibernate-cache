package com.hibernet.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.User;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
//    	User user = new User();
//
//    	user.setId(103);
//    	user.setName("Drasti");
//    	user.setAge(21);


    	Configuration cfg = new Configuration();
    	cfg.configure().addAnnotatedClass(User.class);
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session session1 = sf.openSession();
    	session1.beginTransaction();

    	User user1 = session1.get(User.class, 101);
    	System.out.println(user1);

    	session1.getTransaction().commit();
    	session1.close();

    	Session session2 = sf.openSession();
    	session2.beginTransaction();

    	User user2 = session2.get(User.class, 101);
    	System.out.println(user2);

    	session2.getTransaction().commit();
    	session2.close();
    }
}
