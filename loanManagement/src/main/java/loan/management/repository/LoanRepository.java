package loan.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import loan.management.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>  {

	Boolean existsByLoannumber(String loannumber);
	
	List<Loan> findByFirstname(String fname);
	List<Loan> findByLastname(String lname);
	List<Loan> findByLoannumber(String number);
	List<Loan> findByFirstnameAndLastname(String fname,String lname);
	List<Loan> findByFirstnameAndLoannumber(String fname,String number);
	List<Loan> findByLastnameAndLoannumber(String lname,String number);
	List<Loan> findByFirstnameAndLastnameAndLoannumber(String fname,String lname,String number);
}
