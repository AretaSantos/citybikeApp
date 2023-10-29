package com.example.citybikeproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitybikeService {
	
    private static JourneyRepository journeyRepository;
    private static StationRepository stationrepository;
	
	@Autowired
    public void JourneyService(JourneyRepository journeyRepository) {
        CitybikeService.journeyRepository = journeyRepository;
    }
	@Autowired void StationService(StationRepository stationrepository) {
		CitybikeService.stationrepository = stationrepository;
	}

    public static Integer getTotalDistanceForDepartureStation(Long stationId) {
        return journeyRepository.sumDistanceByDepartureStation(stationId);
    }
    
    public static Integer getTotalDistanceForRetrunStation(Long stationId) {
        return journeyRepository.sumDistanceByReturnStation(stationId);
    }
    
    public static String getStationName(Long stationId) {
        return stationrepository.getStationName(stationId);
    }
    
    public static String getStationAddress(Long stationId) {
        return stationrepository.getStationAddress(stationId);
    }
    
    public static Integer getAvgDictance(Long stationId) {
    	return journeyRepository.avgDistance(stationId);
    }
    
    public static Integer getAvgDuration(Long stationId) {
    	return journeyRepository.avgDuration(stationId);
    }

}
