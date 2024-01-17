import React, { useState } from 'react';
import './Home.scss';
import HomeMenu from '../menu/home-menu/HomeMenu';
import Vault from '../menu/vault/Vault';

const ID_PREFIX = 'home-';

function Home() {

  const [isOpen, setIsOpen] = useState(false);

  const handleOpen = () => {
    setIsOpen(!isOpen);
  }

  return (
    <div className={ID_PREFIX + 'all'}>

      <div>
        <div>
          <h1 className='text-glow'>Daily 梦境</h1>
          <div className='text-glow'>Explore your worlds!</div>
        </div>
        <img className={'img-glow-bright ' + ID_PREFIX + 'img'} src={process.env.PUBLIC_URL + "/Images/space.png"} alt="Home Img" draggable="false" />
      </div>

      <Vault isOpen={isOpen} onOpen={handleOpen} ></Vault>
      <HomeMenu onOpen={handleOpen} isOpen={isOpen} ></HomeMenu>

    </div>
  );
}

export default Home;