/**
* Alexander Perez Oliva - aperezoliva
* CIS175
* Oct 30, 2022
*/
package model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author krazy
 *
 */
@Entity
@Table(name="states")
public class State {
	@Id
	@GeneratedValue
	private int id;
	private String state;
	
	public State() {
		super();
	}
	
	public State(int id, String state) {
		super();
		this.id = id;
		this.state = state;
	}
	
	public State(String state) {
		super();
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", state=" + state + "]";
	}
	
}
