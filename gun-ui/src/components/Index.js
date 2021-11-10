import React from 'react';
import { Link } from 'react-router-dom';
import './css/Index.css'

function Homepage() {
    return (
        <div className="justify-content-center content">
            <div id="welcome">Welcome to my shop</div>
            <Link className="btn btn-primary" id="bt" to='/product' >Shop now!</Link>
        </div>
    )
}

export default Homepage
