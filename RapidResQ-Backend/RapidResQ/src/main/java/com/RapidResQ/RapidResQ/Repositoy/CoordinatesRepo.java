package com.RapidResQ.RapidResQ.Repositoy;

import com.RapidResQ.RapidResQ.Model.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinatesRepo extends JpaRepository<Coordinates,Integer> {
}
