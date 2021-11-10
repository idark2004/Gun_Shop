import React, { useState, useEffect } from 'react';
import './css/Product.css';
import background from './images/background.jfif';
import axios from 'axios';
import { Link } from 'react-router-dom';

function Product() {
    const [product, setProduct] = useState([])

    useEffect(() => {
        axios.get('http://localhost:8080/api/gun')
            .then((response) => {
                setProduct(response.data)

            })
    },[])
    return (
        <div className="container" id="product-content">
            <div className="row" style={{ width: "100vw", marginLeft: "2%" }}>                
                {product.map((data) => (
                    <div className="col-4" key={data.gun_id}>
                        <div className="card" style={{ width: "18rem", marginBottom: "2%" }}>
                            <Link to={`/product-detail/${data.gun_id}`}>
                            <img src={background} className="card-img-top" alt="pic" />                            
                            </Link>
                            <div className="card-body">
                                <h5 className="card-title">{data.gun_name}</h5>
                                <p className="card-text">{data.gun_description}</p>
                                <a href={`/product-detail/${data.gun_id}`} className="btn btn-primary">View detail</a>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    )
}

export default Product
