package loan.management.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(	name = "loan", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "loannumber")
		})
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public String firstname;
	public String lastname;
	public String loannumber;
	public String addressone;
	public String addresstwo;
	public String city;
	public String state;
	public String country;
	public String postal;
	public long amount;
	public int term;
	
	public Loan() {
	}

	
	
	public Loan(String firstname, String lastname, String loannumber, String addressone, String addresstwo, String city,
			String state, String country, String postal, long amount, int term) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.loannumber = loannumber;
		this.addressone = addressone;
		this.addresstwo = addresstwo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postal = postal;
		this.amount = amount;
		this.term = term;
	}



	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLoannumber() {
		return loannumber;
	}

	public void setLoannumber(String loannumber) {
		this.loannumber = loannumber;
	}

	public String getAddressone() {
		return addressone;
	}

	public void setAddressone(String addressone) {
		this.addressone = addressone;
	}

	public String getAddresstwo() {
		return addresstwo;
	}

	public void setAddresstwo(String addresstwo) {
		this.addresstwo = addresstwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}

