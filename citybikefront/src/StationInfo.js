import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';
import './App.css';

function StationInfo() {
  const { stationId } = useParams();
  const [stationData, setStationData] = useState(null);
  const navigate = useNavigate();

  const goBack = () => {
    navigate(-1); 
  };

  useEffect(() => {
    axios.get(`http://localhost:8080/journey/${stationId}`)
      .then(response => {
        setStationData(response.data);
      })
      .catch(error => {
        console.error('Error fetching station details:', error);
      });
  }, [stationId]);

  if (!stationData) {
    return <div>Loading...</div>;
  }

  return (
  <div className="station-info-container">
      <h2>Station Details</h2>
      <div className="station-info-details">
        <p>Station Name: {stationData["Station name: "]}</p>
        <p>Address: {stationData["Station address:"]}</p>
        <p>Average distance of journey from this station: {stationData["Average dictance of journeys from this Station"]} meters</p>
        <p>Average duration of journey from this station: {stationData["Average duration of journeys from this Station"]} seconds</p>
        <p>Total Number of departures from this station: {stationData["Total number of departures: "]}</p>
        <p>Total Number of returns to this station: {stationData["Total number of retruns: "]}</p>
    </div>
    <button onClick={goBack} className="back-button">Go Back</button>
  </div>
  );
}

export default StationInfo;
