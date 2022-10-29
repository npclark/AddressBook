/*
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Oct 28, 2022
 */

package model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="contact")
public class Contact {
	@Id
	@GeneratedValue
	private int id; 			// unique identifier for each Contact
	private String phoneNum;	// Contact's phone number
	private String name;		// Contact's name
	private State state;		// State that contact lives in
	
	// Constructors
	public Contact() {
		super();
	}
	public Contact(int id, String phoneNum, String name, State state) {
		this.id = id;
		this.phoneNum = phoneNum;
		this.name = name;
		this.state = state;
	}
	public Contact(String name) {
		this.name = name;
	}
	public Contact(String phoneNum, boolean isPhone) {
		this.phoneNum = phoneNum;
	}
	
	// Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", phoneNum=" + phoneNum + ", name=" + name + "]";
	}
}
