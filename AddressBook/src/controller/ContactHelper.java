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
	
	// delete contact
	public void deleteContact(Contact toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListGame> typedQuery = em.createQuery("select c from Contact where c.name = : selectedName AND c.phoneNum = : selectedPhoneNum", Contact.class);
		
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedPhoneNum", toDelete.getPhoneNum());
		
		Contact result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().begin();
		em.close();
	}
	
	// update contact
	public void updateContact (Contact toUpdate) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toUpdate);
		em.getTransaction().commit();
		em.close();
	}
	
	// grabs all contacts currently in database
	public List<Contact> showAllContacts(){
		EntityManager em = emfactory.createEntityManager();
		List<Contact> allContacts = em.createQuery("SELECT c FROM Contact c").getResultList();
		return allContacts;
	}
	
	// look up functions
	public Contact searchByName(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contact> typedQuery = em.createQuery("Select ch from Contact ch where ch.name = : selectedName", Contact.class);
		
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Contact found;
		try {
			found = typedQuery.getSingleResult();
		} catch (NumberFormatException e) {
			found = new Contact(nameToLookUp); // if we can't find one, just make a new one
		}
		em.close();
		
		return found;
	}
	// basically a carbon copy of he last one, just swap name with phone number
	public Contact searchByPhone(String phoneToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contact> typedQuery = em.createQuery("Select ch from Contact ch where ch.phoneNum = : selectedPhone", Contact.class);
		
		typedQuery.setParameter("selectedPhone", phoneToLookUp);
		typedQuery.setMaxResults(1);
		
		Contact found;
		try {
			found = typedQuery.getSingleResult();
		} catch (NumberFormatException e) {
			boolean isPhone = false;
			found = new Contact(phoneToLookUp, isPhone); // pretty messy fix, can be better
		}
		em.close();
		
		return found;
	}
	// every contact is going to have a unique id by default, no need to make a case to make a new one
	public Contact searchById(int id) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Contact found = em.find(Contact.class, id);
		em.close();
		return found;
	}
	// multiple contacts can have the same state, ergo, list
	public List<Contact> searchByState(State state) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Contact> typedQuery = em.createQuery("Select c from Contact c where c.state = : selectedState", Contact.class);
		
		typedQuery.setParameter("selectedState", state);
		
		List<Contact> foundContacts = typedQuery.getResultList();
		em.close();
		
		return foundContacts;
	}
	
	// function just in case we need to clean anything up
	public void cleanUp() {
		emfactory.close();
	}
}
