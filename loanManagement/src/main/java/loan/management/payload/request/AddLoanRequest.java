package loan.management.payload.request;

public class AddLoanRequest {
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
	public AddLoanRequest(String firstname, String lastname, String loannumber, String addressone, String addresstwo,
			String city, String state, String country, String postal, long amount, int term) {
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
	
}
