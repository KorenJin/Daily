import React from 'react';
import './Home.css';

function Home() {
  return (
    <div id="homecontainer">
      <h1>Daily</h1>
      <div>Explore your worlds!</div>
      <img id="saturn" src={process.env.PUBLIC_URL + "/Images/homepage/saturn.png"} alt="saturn" />
    </div>
  );
}

export default Home;