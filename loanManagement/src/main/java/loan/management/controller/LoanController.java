package loan.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loan.management.model.Loan;
import loan.management.payload.request.AddLoanRequest;
import loan.management.payload.response.MessageResponse;
import loan.management.repository.LoanRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/loan")
public class LoanController {

	@Autowired
	LoanRepository loanRepository;

	@PostMapping("/addloan")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addLoan(@RequestBody AddLoanRequest addLoanRequest){
		if (loanRepository.existsByLoannumber(addLoanRequest.getLoannumber())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Loannumber is already taken!"));
		}
		
		Loan loan = new Loan(addLoanRequest.getFirstname(),addLoanRequest.getLastname(),addLoanRequest.getLoannumber(),
				addLoanRequest.getAddressone(),addLoanRequest.getAddresstwo(),addLoanRequest.getCity(),addLoanRequest.getState(),
				addLoanRequest.getCountry(),addLoanRequest.getPostal(),addLoanRequest.getAmount(),addLoanRequest.getTerm());
		
		loanRepository.save(loan);
		
		return ResponseEntity.ok(new MessageResponse("Loan Added successfully!"));
	}
	
	@GetMapping("loanlist/{fname}&{lname}&{number}")
	public List<Loan> getSpecificLoanList(@PathVariable String fname,@PathVariable String lname,@PathVariable String number ){
		if(!fname.equals("") && !lname.equals("") && !number.equals("")){
			return loanRepository.findByFirstnameAndLastnameAndLoannumber(fname,lname,number);
		}
		else if(!fname.equals("") && !lname.equals("")){
			return loanRepository.findByFirstnameAndLastname(fname,lname);
		}
		else if(!fname.equals("") && !number.equals("")){
			return loanRepository.findByFirstnameAndLoannumber(fname,number);
		}
		else if(!lname.equals("") && !number.equals("")){
			return loanRepository.findByLastnameAndLoannumber(lname,number);
		}
		else if(!fname.equals("")){
			return loanRepository.findByFirstname(fname);
		}
		else if(!lname.equals("")){
			return loanRepository.findByLastname(lname);
		}
		else if(!number.equals("")){
			return loanRepository.findByLoannumber(number);
		}
		return null;
	}
	
	@GetMapping("/singleloan/{id}")
	public Loan getSingleLoan(@PathVariable long id ){
		return loanRepository.findById(id).get();
		//return todoService.findById(id);
	}
	
	@PutMapping("/update/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Loan> updateLoan(@PathVariable long id,@RequestBody Loan loan){
	
		Loan updated = loanRepository.save(loan);
		return new ResponseEntity<Loan>(loan,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Loan> deleteLoan(@PathVariable long id){
		Loan deleted = loanRepository.findById(id).get();
		loanRepository.deleteById(id);
		
		//return ResponseEntity.noContent().build();
		return new ResponseEntity<Loan>(deleted,HttpStatus.OK);
	}
}
