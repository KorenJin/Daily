import React from 'react';
import './Home.css';
import Menu from '../menu/Menu';

function Home() {
  return (
    <div id="homecontainer">
    
      <div id="homecontent">
        <div id="hometext">
          <h1 className='textglow'>Daily 梦境</h1>
          <div className='textglow'>Explore your worlds!</div>
        </div>
        <img id="homeimg" className='imgglow' src={process.env.PUBLIC_URL + "/Images/space.png"} alt="earth" />
      </div>
      
      <Menu></Menu>

    </div>
  );
}

export default Home;