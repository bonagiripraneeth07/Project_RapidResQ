package com.RapidResQ.RapidResQ.Controller;

import com.RapidResQ.RapidResQ.Model.Ambulance;
import com.RapidResQ.RapidResQ.Model.AmbulanceUser;
import com.RapidResQ.RapidResQ.Services.AmbulanceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

@RequestMapping("ambulance")
@CrossOrigin
@RestController
public class Ambulancecontroller {

    @Autowired
    private AmbulanceServices ambulanceServices;


    @GetMapping("/hello")
    public String hello(){
        return "hello from controller";
    }
    @PostMapping("/post/{var}")
    public String posthello(@PathVariable String var ){
        return var;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Ambulance ambulance)
    {
        System.out.println(ambulance.getAmbulanceNumber());
         return ambulanceServices.registerUser(ambulance);
    }

    @PostMapping("/login")
     public ResponseEntity<Ambulance> login(@RequestBody AmbulanceUser ambulanceUser)
    {
        return ambulanceServices.login(ambulanceUser);
    }
    @GetMapping("ambulancetest")
    public String test(){
        return "from ambulance";
    }
}
