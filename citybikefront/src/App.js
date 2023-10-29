import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function App() {
  const [data, setData] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/stations')
      .then(response => {
        setData(response.data);
        console.log(response.data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  return (
    <div className="app-container">
      <h1 className="app-header">List of city bike stations</h1>
      <ul className="station-list">
      {data.map(item => (
        <Link to={`/stations/${item.id}`} className="station-link" key={item.id}>
          <li>
            {item.station_name}
          </li>
        </Link>
        ))}
      </ul>
    </div>
  );
}

export default App;
