package com.RapidResQ.RapidResQ.Repositoy;

import com.RapidResQ.RapidResQ.Model.DriverDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Driver;
@Repository
public interface DriverRepo extends JpaRepository<DriverDetails,Integer> {
}
