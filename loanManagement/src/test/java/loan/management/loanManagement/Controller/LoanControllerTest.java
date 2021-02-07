package loan.management.loanManagement.Controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import loan.management.controller.LoanController;
import loan.management.model.Loan;
import loan.management.payload.request.AddLoanRequest;
import loan.management.payload.response.MessageResponse;
import loan.management.repository.LoanRepository;




@RunWith(SpringRunner.class)
//@SpringBootTest
//@WebMvcTest(LoanController.class)

public class LoanControllerTest {

    
    @InjectMocks
    LoanController loanController;
 
    
    @Mock
    LoanRepository loanRepository;
   
    
    @Mock
    MessageResponse messageResponse;
   
    @Mock
    AddLoanRequest addLoanRequest;
    
    @BeforeEach
    public void setUp()  {
        MockitoAnnotations.initMocks(this);
        List<Loan> loans = new ArrayList<>();
        loans.add(new Loan("gabriel", "beveira", "Loan001","addressone", "addresstwo","city",
			"state", " country", " postal", 45, 2));
        loans.add(new Loan("gabriel", "beveira", "Loan002","addressone", "addresstwo","city",
    			"state", " country", " postal", 45, 2));
        loans.add(new Loan("gabriel", "beveira", "Loan003","addressone", "addresstwo","city",
    			"state", " country", " postal", 45, 2));
        loans.get(0).setId((long)1);
        loans.get(1).setId((long)2);
        loans.get(2).setId((long)3);
        when(loanRepository.findAll()).thenReturn(loans);
    }
    
	@Test
	public void getLoanDetailByIdTest() throws Exception {
	
		long id=1;
		Optional<Loan> loan= Optional.of(new Loan("gabriel", "beveira", "Loan001","addressone", "addresstwo","city",
			"state", " country", " postal", 45, 2));
		
		 when(loanRepository.findById(id)).thenReturn(loan);
		 loanController.getSingleLoan(id);
	        assertEquals(loan.get(),loanController.getSingleLoan(id));
	}
	
	@Test
	public void getSpecificLoanListTest() {
		  
        List<Loan> loans = new ArrayList<>();
        loans.add(new Loan("gabriel", "beveira", "Loan001","addressone", "addresstwo","city",
    			"state", " country", " postal", 45, 2));
        loans.add(new Loan("gabriel", "beveira", "Loan002","addressone", "addresstwo","city",
    			"state", " country", " postal", 45, 2));
      
      
        loans.get(0).setId((long)1);
        loans.get(1).setId((long)2);
        when(loanRepository.findByFirstname("gabriel")).thenReturn(loans);
        List<Loan> result = loanController.getSpecificLoanList("gabriel", "", "");
        assertEquals(loanRepository.findByFirstname("gabriel"),result);
	}
	
	@Test
	public void getAddLoanTest()throws Exception {
		Loan loan= new Loan("gabriel", "beveira", "Loan001","addressone", "addresstwo","city",
				"state", " country", " postal", 45, 2);
		
		
		//when(loanRepository.save(loan)).thenReturn(loan);
		
		AddLoanRequest add_loan=new AddLoanRequest(loan.getFirstname(), loan.getLastname(), loan.getLoannumber(),loan.getAddressone(),
				loan.getAddresstwo(),loan.getCity(),loan.getState(),loan.getCountry(),loan.getPostal(),loan.getAmount(),loan.getTerm());
		System.out.println(add_loan);
	    ResponseEntity response=loanController.addLoan(add_loan);
	    
		
		int status_code = response.getStatusCodeValue();
		  assertEquals(200,status_code);
	}

	 @Test
	    public void DeletionTest() throws Exception {
		 List<Loan> loans = loanRepository.findAll();
		 
			long id=1;
			Optional<Loan> loan= Optional.of(new Loan("gabriel", "beveira", "Loan004","addressone", "addresstwo","city",
				"state", " country", " postal", 45, 2));
			
			 ObjectMapper m = new ObjectMapper();
		
			
			 when(loanRepository.findById((long)3)).thenReturn(loan);
	 
			 ResponseEntity response =  loanController.deleteLoan((long)3);
			 
			 ObjectMapper mapper = new ObjectMapper();
			
			assertEquals(mapper.writeValueAsString(response.getBody()),m.writeValueAsString(loan.get()));
	      
	    }

	 @Test
	 public void loanUpdationTest() throws Exception {
			Loan loan= new Loan("gabriel", "beveira", "Loan001","addressone", "addresstwo","city",
					"state", " country", " postal", 45, 2);
			
		
			
		    ResponseEntity response=loanController.updateLoan((long)1,loan);
		    assertEquals(response.getBody(),loan);
	 }


}


