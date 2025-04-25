package com.RapidResQ.RapidResQ.Repositoy;

import com.RapidResQ.RapidResQ.Model.Police;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliceRepo extends JpaRepository<Police,Integer> {

    Police findByUserName(String userName);
}
