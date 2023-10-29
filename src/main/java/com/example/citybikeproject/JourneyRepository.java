package com.example.citybikeproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, Long> {
	
	@Query("SELECT COUNT(j) FROM Journey j WHERE j.departureStation.id = :stationId")
	Integer sumDistanceByDepartureStation(@Param("stationId") Long stationId);

	@Query("SELECT COUNT(j) FROM Journey j WHERE j.returnStation.id = :stationId")
	Integer sumDistanceByReturnStation(@Param("stationId") Long stationId);

	@Query("SELECT AVG(distance) FROM Journey WHERE departureStation.id = :stationId")
	Integer avgDistance(@Param("stationId") Long stationId);

	@Query("SELECT AVG(duration) FROM Journey WHERE departureStation.id = :stationId")
	Integer avgDuration(@Param("stationId") Long stationId);

}
