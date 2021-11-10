/* eslint-disable react-hooks/exhaustive-deps */
import axios from 'axios'
import React, { useState, useEffect } from 'react'
import background from './images/background.jfif';
import { Link, useParams } from 'react-router-dom'


function ProductDetail(props) {
    const param = useParams()
    const [gun, setGun] = useState({})
    const [rated, setRate] = useState({})

    const gunRequest = `http://localhost:8080/api/gun/${param.id}`;
    const rateRequest = `http://localhost:8080/api/rate/${param.id}`;

    const requestOne = axios.get(gunRequest);
    const requestTwo = axios.get(rateRequest);
    useEffect(() => {
         axios.all([requestOne, requestTwo])
            .then(axios.spread((...res) => {
                setGun(res[0].data)
                setRate(res[1].data)
                console.log(rated)
            }))
    }, [])

    return (
        <>
            <div className="container" style={{
                marginTop: "2%"
            }}>
                <div className="row">
                    <div className="col-4">
                        <img src={background} alt='gun-img' style={{
                            height: "inherit",
                            width: "inherit"
                        }}></img>
                    </div>
                    <div className="col-8">
                        <div className="row">
                            <div className="col border border-primary"> id</div>
                            <div className="col border border-primary"> {param.id}</div>
                        </div>
                        <div className="row">
                            <div className="col border border-primary"> Name</div>
                            <div className="col border border-primary"> {gun.gun_name}</div>
                        </div>
                        <div className="row">
                            <div className="col border border-primary"> Description</div>
                            <div className="col border border-primary"> {gun.gun_description}</div>
                        </div>
                        <div className="row">
                            <div className="col border border-primary"> Capacity</div>
                            <div className="col border border-primary"> {gun.capacity} bullets</div>
                        </div>
                        <div className="row">
                            <div className="col border border-primary"> Weight</div>
                            <div className="col border border-primary"> {gun.weight} grams</div>
                        </div>
                        <div className="row">
                            <div className="col border border-primary"> Price</div>
                            <div className="col border border-primary"> {gun.gun_price} $</div>
                        </div>
                        <div className="row">
                            <div className="col border border-primary"> Average Rating :</div>
                            <div className="col border border-primary"> {rated.rate}</div>
                        </div>
                    </div>
                </div>
            </div>
            <hr></hr>
            <Rating />
        </>
    )
}

function Rating() {
    const param = useParams()
    const [rating, setRating] = useState([])
    useEffect(() => {
        axios.get(`http://localhost:8080/api/rate`, {
            params: {
                gun_id: param.id,
            }
        }).then((res) => {      
            if (res.data.length > 0) {
                setRating(res.data)
            }
        })
    }, [])
    return (
        <div style={{textAlign : "center"}}>
            {sessionStorage.length === 0 ? 
            <p>If you want to rate this product then please <Link to="/login">Log in</Link></p> 
            : <p>Your rating</p> }
            <h2 style={{ textAlign: "center" }}>Rating</h2>

            {rating.length > 0 ? (
                <table className="table" style={{
                    margin: "auto",
                    width: "80vw",
                    marginTop: "2%"
                }}>
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Rated point</th>
                        </tr>
                    </thead>
                    <tbody>
                        {rating.map((rate, index) => (
                            <tr>
                                <th scope="row" key={index}>{index + 1}</th>
                                <td>{rate.user_name}</td>
                                <td>{rate.rate_point}</td>
                            </tr>
                        ))
                        }
                    </tbody>
                </table>
            ) : <h1 style={{textAlign : "center"}}> No Rating!</h1>
            }
        </div>
    )
}


export default ProductDetail
