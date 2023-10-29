package com.example.citybikeproject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class CitybikeController {

	@Autowired
	public StationRepository stationRepository;
	@Autowired
	public JourneyRepository journeyRepository;
	
	@GetMapping("/stations")
    public List<Station> getStations() {
        return (List<Station>) stationRepository.findAll();
    }
    
    @GetMapping("/{stationId}")
    public ResponseEntity<Station> getStationById(@PathVariable Long stationId) {
        Optional<Station> station = stationRepository.findById(stationId);
        
        if (station.isPresent()) {
            return ResponseEntity.ok(station.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/journey/{stationId}")
    public ResponseEntity<Map<String, Object>> getStationInfo(@PathVariable Long stationId) {
    	Map<String, Object> response = new HashMap<>();
    	response.put("Total number of departures: ", CitybikeService.getTotalDistanceForDepartureStation(stationId));
        response.put("Total number of retruns: ", CitybikeService.getTotalDistanceForRetrunStation(stationId));
        response.put("Station name: ", CitybikeService.getStationName(stationId));
        response.put("Station address:", CitybikeService.getStationAddress(stationId));
        response.put("Average dictance of journeys from this Station", CitybikeService.getAvgDictance(stationId));
        response.put("Average duration of journeys from this Station", CitybikeService.getAvgDuration(stationId));
        return ResponseEntity.ok(response);
    }
    
    
}
