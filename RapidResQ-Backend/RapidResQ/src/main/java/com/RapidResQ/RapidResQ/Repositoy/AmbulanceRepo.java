package com.RapidResQ.RapidResQ.Repositoy;

import com.RapidResQ.RapidResQ.Model.Ambulance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbulanceRepo extends JpaRepository<Ambulance,Integer> {

      Ambulance findByUserName(String username);
}
