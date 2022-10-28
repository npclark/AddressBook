/**
 * @author Noah Clark - npclark
 * CIS175 Fall 2022
 * Oct 15, 2022
 */

package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

public class Contact {
	
	
	private int id; 			// unique identifier for each Contact
	private String phoneNum;	// Contact's phone number
	private String name;		// Contact's name
	private State state;		// State that contact lives in
}
