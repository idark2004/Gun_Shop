import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import React from 'react';
import { NavLink } from "react-router-dom";
import {faFacebookF, faGithub, faInstagram, faLinkedin} from '@fortawesome/free-brands-svg-icons'

function Navbar() {
    let activeStyle = {
        color: "red"
    }
    return (

        <div>
            <nav className="navbar mx-0 sticky-top navbar-expand-lg navbar-light bg-light">
                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                        <li className="nav-item active">
                            <NavLink className="nav-link" to="/"
                                style={({ isActive }) =>
                                    isActive ? activeStyle : undefined
                                }>Home </NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink className="nav-link" to="/product"
                                style={({ isActive }) =>
                                    isActive ? activeStyle : undefined}>Products</NavLink>
                        </li>
                        {sessionStorage.length === 0 ? (<>
                            <li className="nav-item">
                            <NavLink className="nav-link" to="/register"
                                style={({ isActive }) =>
                                    isActive ? activeStyle : undefined}>Register</NavLink>
                        </li>
                        <li className="nav-item">
                            <NavLink className="nav-link" to="/login"
                                style={({ isActive }) =>
                                    isActive ? activeStyle : undefined}>Login</NavLink>
                        </li>
                        </>) : <p>User : {sessionStorage.getItem('Email')}</p>}
                        
                    </ul>
                </div>
            </nav>
        </div>
    )
}

//footer
function Footer() {
    return (
        <footer className="bg-dark text-center text-white" style={{position: "fixed",
            bottom: 0,
            left: 0,
            height : "fit-content",
            marginTop : "-50px",
            width : "100%"}}>        

            <div className="container p-4">

                <section className="mb-4">

                    <a className="btn btn-outline-light btn-floating m-1" href="https://www.facebook.com/idark2004" role="button"
                    ><FontAwesomeIcon icon={faFacebookF}/></a>


                    <a className="btn btn-outline-light btn-floating m-1" href="https://github.com/idark2004" role="button"
                    ><FontAwesomeIcon icon={faGithub}/></a>


                    <a className="btn btn-outline-light btn-floating m-1" href="https://www.linkedin.com/in/ph%C3%A1t-h%E1%BB%93-h%E1%BB%AFu-015357166" role="button"
                    ><FontAwesomeIcon icon={faLinkedin}/></a>


                    <a className="btn btn-outline-light btn-floating m-1" href="https://www.instagram.com/hphats/" role="button"
                    ><FontAwesomeIcon icon={faInstagram}/></a>
                </section>

                <section className="mb-4">
                    <p>
                        This is a ecommerce project named : Gun Shop
                    </p>
                </section>

            </div>

            <div className="text-center p-3" style={{ backgroundColor: "rgba(0, 0, 0, 0.2)" }}>
                © 2021 Copyright : 
                <a className="text-white" href="https://github.com/idark2004"> Ho Huu Phat</a>
            </div>

        </footer>

    )
}

export {
    Navbar,
    Footer }
