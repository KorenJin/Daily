import React from "react";
import "./Vault.scss";
import routes from "../../routes/Routes";
import { useNavigate } from "react-router-dom";

const ID_PREFIX = "vault-";

function Vault({ isOpen, onOpen }) {

    const navigate = useNavigate();

    const handleClick = (route, index) => {
        // Necessary html elements
        let button = document.getElementsByClassName(ID_PREFIX + "button")[index];
        if (button) {
            onOpen();
            // Open button
            button.classList.add("open");
            // Close vault and button: 300ms
            setTimeout(() => {
                button.classList.remove("open");
            }, 300);
            // Navigate to route
            setTimeout(() => {
                navigate(route.path);
            }, 100);
        }
    }

    const className = ID_PREFIX + "all" + (isOpen ? " open" : "");

    return (
        <div className={className}>

            {
                routes.map((route, index) => (
                        <div className={ID_PREFIX + "button text-glow"} key={index} onClick={() => handleClick(route, index)} >
                            <div> {route.name} </div>
                            <img className="icon img-glow" src={process.env.PUBLIC_URL + "/Images/" + route.icon + ".png"} alt={route.icon} />
                        </div>

                ))
            }

        </div>

    );
}

export default Vault;