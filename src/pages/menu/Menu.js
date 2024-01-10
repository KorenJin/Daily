import React from "react";
import "./Menu.css";
import routes from "../routes/Routes";
import { useNavigate } from "react-router-dom";

function Menu() {

    const navigate = useNavigate();

    const handleClick = (route) => {
        let button = document.getElementById(route.name.toLowerCase() + "link");
        if (button) {
            // If the sidebar is open, close it and remove 'animation' class from the button
            let menu = document.getElementById("sidebar-menu-whole");
            if (menu) {
                if (menu.classList.contains("open")) {
                    menu.classList.remove("open");
                    let button = document.getElementById("sidebar-button");
                    if (button) {
                        button.classList.remove("animation");
                    }
                }
            }
            button.classList.add("animatesidebarlink");
            // Animation time = 0.3s = 300ms
            setTimeout(() => {
                button.classList.remove("animatesidebarlink");
            }, 300);
            // Redirect to the route.path
            setTimeout(() => {
                navigate(route.path);
            }, 100);
        }
    }

    const openMenu = () => {
        console.log("openMenu");
        let open = false;
        
        // Sidebar menu
        let menu = document.getElementById("sidebar-menu-whole");
        if (menu) {
            // Add "open" class if the menu is closed
            if (!menu.classList.contains("open")) {
                menu.classList.add("open");
                open = true;
            }
            // Remove "open" class if the menu is open
            else {
                menu.classList.remove("open");
            }
        }

        // Sidebar button animation
        let button = document.getElementById("sidebar-button");
        if (button) {
            // Add "animation" class if the menu is closed
            if (open) {
                button.classList.add("animation");
            }
            // Remove "animation" class if the menu is open
            else {
                button.classList.remove("animation");
            }
        }

    };
    return (
        <>
        
        <div className={`sidebar-menu`} id="sidebar-menu-whole">
            <div id="homelinkcontainer" onClick={() => handleClick({ path: '/', name: 'Home' })} >
                <div className="sidebarlink textglow" id="homelink"> Home </div>
                <img id="homeicon" className="imgglow sidebaricon" src={process.env.PUBLIC_URL + "/Images/earth.png"} alt="saturn" />
            </div>
            {
                routes.map((route, index) => (
                        <div key={index} id = {route.name.toLowerCase() + "linkcontainer"} onClick={() => handleClick(route)}>
                            <div className="sidebarlink textglow" id={route.name.toLowerCase() + "link"} >
                                {route.name}
                            </div>
                            <img id={route.name.toLowerCase() + "icon"} className="imgglow sidebaricon" src={process.env.PUBLIC_URL + "/Images/" + route.icon + ".png"} alt={route.icon} />
                        </div>

                ))
            }
        </div>


        <div id="squarewrapper" className="boxglow-bright"></div>
        <div id="sidebar-button" className="boxglow-bright" onClick={openMenu}>
            <img src={process.env.PUBLIC_URL + "/Images/angle-right.png"} alt="sidebar-button" />
        </div>
        

        </>
    );
}

export default Menu;