package com.axelor.hiberDemo.app;  
  
import javax.persistence.*;


import com.axelor.hiberDemo.db.Student;

import java.util.*;

public class App {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("myJpaUnit");
		EntityManager em = emfactory.createEntityManager();
		
		create(em);
		read(em);
		update(em);
		//delete(em);
		em.close();
		emfactory.close();
		
	}
	
	private static void create(EntityManager em) {
		System.out.println("Creating Student records");
		
		em.getTransaction().begin();

		Student s1 = new Student();
		s1.setId(1l);
		s1.setName("Rajvi");
		em.persist(s1);
		
		Student s2 = new Student();
		s2.setId(2l);
		s2.setName("Rajvi T");
		em.persist(s2);
		
		em.getTransaction().commit();
		
		
	}
	private static void read(EntityManager em) {
		
		/*em.getTransaction().begin();
		Student s1 = em.find(Student.class, 1l);
		Student s2 = em.find(Student.class, 2l);
		System.out.println(s1.getName());
		System.out.println(s2.getName());
		
		em.getTransaction().commit();*/
		
		Query q=em.createQuery(" from Student s");
		
		List<Student> list = q.getResultList();
		Iterator<Student> itr=list.iterator();
		
		while(itr.hasNext()) {
			Student s1=itr.next();
		System.out.println("Student ID:" + s1.getId());
		System.out.println("\t Student NAME: " + s1.getName());
			
		}
		
	}
	private static void update(EntityManager em) {
		System.out.println("Updating record");
		
		em.getTransaction().begin();
		
		Student existingUser = new Student();
		
		existingUser.setId(2l);
		existingUser.setName("Rajvi Tandel");
		
		em.merge(existingUser);
		
		em.getTransaction().commit();
	
		
	}
	private static void delete(EntityManager em) {
		
		Student s = em.find(Student.class, 1l);
		
		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();
		
	}
	
}

			
			


		
		
		
		
		

