package loan.management.loanManagement.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import loan.management.controller.AuthController;
import loan.management.model.User;
import loan.management.payload.request.LoginRequest;
import loan.management.payload.response.JwtResponse;
import loan.management.repository.RoleRepository;
import loan.management.repository.UserRepository;
import loan.management.security.jwt.JwtUtils;
import loan.management.security.services.UserDetailsServiceImpl;


@RunWith(SpringRunner.class)

class AuthControllerTest {

	
    @InjectMocks
    AuthController authController;
    
    JwtResponse jwtResponse;

    UserDetails userdetails;
	AuthenticationManager authenticationManager;

    @Mock
    JwtUtils jwtUtils;

    @Mock
    UserDetailsServiceImpl userDetailsServiceImpl;

 

    @Mock
    UserRepository userRepository;
    @Mock
    RoleRepository roleRepository;

    @Mock
    LoginRequest loginrequest;
    
    @BeforeEach
    public void setUp()  {
        MockitoAnnotations.initMocks(this);
    }
	@Test
	void loginTest() {
		LoginRequest loginRequest= new LoginRequest("gabriel","gabriel");
	}

}
