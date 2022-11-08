/**
* Alexander Perez Oliva - aperezoliva
* CIS175
* Oct 31, 2022
*/
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author krazy
 *
 */
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private LocalDate tripDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private State state;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Contact> contactList;
	
	public ListDetails() {
		super();
	}
	
	public ListDetails(int id, String listName, LocalDate tripDate, State state, List<Contact> contactList) {
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.state = state;
		this.contactList = contactList;
	}
	
	public ListDetails(int id, String listName, LocalDate tripDate, State state) {
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
		this.state = state;
	}
	
	public ListDetails(int id, String listName, LocalDate tripDate) {
		this.id = id;
		this.listName = listName;
		this.tripDate = tripDate;
	}
	
	public ListDetails(int id, String listName) {
		this.id = id;
		this.listName = listName;
	}
	
	public ListDetails(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	@Override
	public String toString() {
		return "ListDetails [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", state=" + state
				+ ", contactList=" + contactList + "]";
	}
	
}
