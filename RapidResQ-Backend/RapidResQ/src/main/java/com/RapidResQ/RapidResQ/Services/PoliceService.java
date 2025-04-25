package com.RapidResQ.RapidResQ.Services;

import com.RapidResQ.RapidResQ.Model.Ambulance;
import com.RapidResQ.RapidResQ.Model.Coordinates;
import com.RapidResQ.RapidResQ.Model.Police;
import com.RapidResQ.RapidResQ.Model.PoliceLogin;
import com.RapidResQ.RapidResQ.Repositoy.CoordinatesRepo;
import com.RapidResQ.RapidResQ.Repositoy.PoliceRepo;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;

@Service
public class PoliceService {
        @Autowired
        private PoliceRepo policeRepo;
        @Autowired
        private CoordinatesRepo coordinatesRepo;
    @Autowired
    private AuthenticationManager authenticationManager;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    @Autowired
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    public String register(Police police) {
        Police checkPolice = policeRepo.findByUserName(police.getUserName());
        if (checkPolice==null)
        {
           coordinatesRepo.save(police.getCoordinates());
            police.setPassword(encoder.encode(police.getPassword()));
            System.out.println(police.getPassword());
            Police police1 =  policeRepo.save(police);
             return "Success";
        }else{
            return "failed";
        }
    }

    public ResponseEntity<String> login(PoliceLogin policeLogin) {
        Police  police_Account_Check = policeRepo.findByUserName(policeLogin.getUserName());

        if(police_Account_Check==null){
            return new ResponseEntity<>("404", HttpStatus.NOT_FOUND);
        }
        if(passwordEncoder().matches(CharBuffer.wrap(policeLogin.getPassword()),police_Account_Check.getPassword())){
            System.out.println("password is correct " + police_Account_Check.getPassword());
            return new ResponseEntity<>("Successful",HttpStatus.FOUND);
        }else{
            System.out.println("not right password");
            System.out.println(police_Account_Check.getPassword());
            return new ResponseEntity<>("Wrong Credentials",HttpStatus.UNAUTHORIZED);
        }
    }

    public List<Police> getAllMarkers() {
    return policeRepo.findAll();
    }
}
