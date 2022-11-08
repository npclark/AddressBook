/**
* Alexander Perez Oliva - aperezoliva
* CIS175
* Oct 30, 2022
*/
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery; // Yeah no idea, I saw your other comment LOL 

import model.State;

/**
 * @author krazy
 *
 */
public class StateHelper {
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("AddressBook");
	
	public void insertState(State s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<State> showAllStates() {
		EntityManager em = emfactory.createEntityManager();
		List<State> allStates = em.createQuery("SELECT s FROM State s").getResultList();
		return allStates;
	}
	
	/* public State findState(String stateLookUp) { // Going to comment this out until we found a fix for importation of TypedQuery
		EntityManager em = emfactory.createEntityManager();		// My only guess is some issues
		em.getTransaction().begin();
		TypedQuery<State> typedQuery = em.createQuery("select s from State s where s.state = :state", State.class);
		typedQuery.setPArameter("selectedState". stateLookUp);
		typedQuery.setMaxResults(1);
		
		State foundState;
		
		try {
			foundState = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundState = new State(stateLookUp);
		}
		em.close();
		
		return foundState;
	} */
}
