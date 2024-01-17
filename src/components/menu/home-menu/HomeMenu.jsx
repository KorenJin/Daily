import React from "react";
import "./HomeMenu.scss";

const ID_PREFIX = "home-menu-";

function HomeMenu( { onOpen, isOpen } ) {

    // const toggleVault = () => {
    //     // Toggle vault: 300ms
    //     onOpen();
    //     // Necessary html elements
    //     let button = document.getElementsByClassName(ID_PREFIX + "circle")[0];
    //     if (button) {
    //         // Sidebar button animation
    //         if (isOpen) {
    //             button.classList.remove("open");
    //         } else {
    //             button.classList.add("open");
    //         }
    //     }
    
    // };

    const circleClassName = "box-glow-bright " + ID_PREFIX + "circle" + (isOpen ? " open" : "")
    
    return (

        <>
            <div className={"box-glow-bright " + ID_PREFIX + "square"} ></div>

            <div className={circleClassName} onClick={onOpen}>
                <img src={process.env.PUBLIC_URL + "/Images/angle-right.png"} alt="sidebar-button" draggable="false" />
            </div>
        </>

    );
}

export default HomeMenu;