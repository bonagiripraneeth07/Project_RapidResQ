package com.RapidResQ.RapidResQ.Controller;

import com.RapidResQ.RapidResQ.Model.Police;
import com.RapidResQ.RapidResQ.Model.PoliceLogin;
import com.RapidResQ.RapidResQ.Services.PoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("police")
public class PoliceController {
   @Autowired
   private PoliceService policeService;
    @GetMapping("hellopolice")
    public String hello(){
        return "hello police";
    }
    @PostMapping("register")
    public String register(@RequestBody Police police ){
      return   policeService.register(police);
    }
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody PoliceLogin policeLogin){

         return policeService.login(policeLogin);
    }
    @GetMapping("test")
    public String test(){
        return "from police";
    }
    @GetMapping("getAllMarkers")
    public List<Police> getAllMarkers(){
        return policeService.getAllMarkers();
    }
}
