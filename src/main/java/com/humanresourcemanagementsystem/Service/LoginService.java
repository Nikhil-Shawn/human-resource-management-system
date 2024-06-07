package com.humanresourcemanagementsystem.Service;

import com.humanresourcemanagementsystem.Dto.LoginDTO;
import com.humanresourcemanagementsystem.Entity.Person;
import com.humanresourcemanagementsystem.Repo.EmployeeRepository;
import com.humanresourcemanagementsystem.Repo.PersonRepository;
import com.humanresourcemanagementsystem.response.ResponseData;
import com.humanresourcemanagementsystem.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    public ResponseData loginEmployee(LoginDTO loginDTO) {
        if ("employee".equalsIgnoreCase(loginDTO.getPersonType())) {
            System.out.println("employee");
            return authenticateEmployee(loginDTO);
        } else {
            System.out.println("Person");
            return loginPerson(loginDTO);
        }
    }

    public ResponseData loginPerson(LoginDTO loginDTO) {
        return authenticatePerson(loginDTO);
    }

    private ResponseData authenticateEmployee(LoginDTO loginDTO) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
            );
        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage());
            return new ResponseData("Invalid credentials", false, null);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDTO.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("token", jwt);
        return new ResponseData("Login Success", true, responseData);
    }

    private ResponseData authenticatePerson(LoginDTO loginDTO) {
        try {
            Person person = personRepo.findByPersonEmail(loginDTO.getEmail());
            if (person == null || !passwordEncoder.matches(loginDTO.getPassword(), person.getPersonPassword())) {
                return new ResponseData("Invalid credentials", false, null);
            }

            if (!"applicant".equalsIgnoreCase(person.getPersonType())) {
                return new ResponseData("Invalid person type", false, null);
            }

            final UserDetails userDetails = new User(loginDTO.getEmail(), person.getPersonPassword(), new ArrayList<>());
            final String jwt = jwtUtil.generateToken(userDetails.getUsername());

            Map<String, Object> responseData = new HashMap<>();
            responseData.put("token", jwt);

            return new ResponseData("Login Success", true, responseData);
        } catch (Exception e) {
            return new ResponseData("Failed to authenticate", false, null);
        }
    }

    public void logoutEmployee(HttpServletResponse response) {
        jwtUtil.invalidateTokenCookie(response);
    }
}
