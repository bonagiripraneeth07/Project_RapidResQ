package com.RapidResQ.RapidResQ.Services;

import com.RapidResQ.RapidResQ.Model.Ambulance;
import com.RapidResQ.RapidResQ.Model.AmbulanceUser;
import com.RapidResQ.RapidResQ.Repositoy.AmbulanceRepo;
import com.RapidResQ.RapidResQ.Repositoy.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.nio.CharBuffer;

@Service
public class AmbulanceServices {

    @Autowired
    private AmbulanceRepo ambulanceRepo;
    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    public ResponseEntity<String> registerUser(Ambulance ambulance)
    {
        String username =ambulance.getUserName();
        System.out.println(username);
        Ambulance checkAmbulance = ambulanceRepo.findByUserName(username);
        System.out.println(checkAmbulance);
        if(checkAmbulance==null){
            driverRepo.save(ambulance.getDriverDetails());
            ambulance.setPassword(encoder.encode(ambulance.getPassword()));
            System.out.println(ambulance.getPassword());
          Ambulance ambulance1 =  ambulanceRepo.save(ambulance);
            return new ResponseEntity<>( "Registration Successful",HttpStatus.CREATED);
        }else
        {
            System.out.println("user already exists");
            return    new ResponseEntity<>("Something Went Wrong",HttpStatus.BAD_REQUEST) ;
        }

    }

    public ResponseEntity<Ambulance> login(AmbulanceUser ambulanceUser) {
        Ambulance userExists = ambulanceRepo.findByUserName(ambulanceUser.getUserName());
        System.out.println(ambulanceUser.getUserName());
       if(userExists==null){
           return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
       }
           if(passwordEncoder().matches(CharBuffer.wrap(ambulanceUser.getPassword()),userExists.getPassword())){
               System.out.println("password is correct " + ambulanceUser.getPassword());
               return new ResponseEntity<>(userExists,HttpStatus.FOUND);
           }else{
               System.out.println("not right password");
               System.out.println(ambulanceUser.getPassword());
               return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
           }

       }

    }
