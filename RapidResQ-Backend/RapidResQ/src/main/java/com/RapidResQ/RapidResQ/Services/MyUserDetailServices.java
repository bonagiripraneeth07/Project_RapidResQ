package com.RapidResQ.RapidResQ.Services;

import com.RapidResQ.RapidResQ.Model.Ambulance;
import com.RapidResQ.RapidResQ.Model.UserPricipal;
import com.RapidResQ.RapidResQ.Repositoy.AmbulanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailServices implements UserDetailsService {

    @Autowired
    private AmbulanceRepo ambulanceRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Ambulance checkAmbulance = ambulanceRepo.findByUserName(username);
        if (checkAmbulance==null) {
            System.out.println("User 404" );
            System.out.println(username );
            throw new UsernameNotFoundException("User 404");
        }
        return new UserPricipal(checkAmbulance);

    }
}
