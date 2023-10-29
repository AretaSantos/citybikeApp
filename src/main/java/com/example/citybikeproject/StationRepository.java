package com.example.citybikeproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Long>{
	
	@Query("SELECT station_name FROM Station WHERE id = :stationId")
    String getStationName(@Param("stationId") Long stationId);
	
	@Query("SELECT station_address FROM Station WHERE id = :stationId")
    String getStationAddress(@Param("stationId") Long stationId);

}
