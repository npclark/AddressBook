/*
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Oct 28, 2022
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery; // i have no earthly idea how to fix this

import model.Contact;

public class ContactHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressBook");
	
	// add a new contact to the database
	public void insertContact(Contact c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	// grabs all contacts currently in database
	public List<Contact> showAllContacts(){
		EntityManager em = emfactory.createEntityManager();
		List<Contact> allContacts = em.createQuery("SELECT c FROM Contact c").getResultList();
		return allContacts;
	}
	
	// finds a contact by searching for their name
	public Contact findContact(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contact> typedQuery = em.createQuery("Select ch from Contact ch where ch.name = : selectedName", Contact.class);
		
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Contact foundContact;
		try {
			foundContact = typedQuery.getSingleResult();
		} catch (NumberFormatException e) {
			foundContact = new Contact(nameToLookUp); // if we can't find one, just make a new one
		}
		em.close();
		
		return foundContact;
	}
}
