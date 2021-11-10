import axios from 'axios';
import React, { useState } from 'react'

function Login() {

    const [user, setUser] = useState({
        email: '',
        password: ''
    })

    const handleChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        setUser(
            user => ({
                ...user,
                [name]: value
            })
        )
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(user);
        axios.post('http://localhost:8080/api/login', null, {
            params: {
                email: user.email,
                password: user.password
            }
        }).then((response) => {
            console.log(response)
            alert('Login successfull');
            sessionStorage.setItem('Email', user.email)
            localStorage.setItem('Authorization', response.data.access_token);
            window.location='http://localhost:3000/';

        }).catch(error => {
            console.log(error)
            alert('Wrong email or password')
        })
    }
    return (
        <div style={{
            width : "60vw",
            margin : "auto",
            marginTop : "6%"
        }}>
            <form onSubmit={e => handleSubmit(e)}>
                <div className="form-group row">

                    <label htmlFor="inputEmail1" className="col-sm-2 col-form-label">Email address</label>
                    <div className='col-sm-10'>
                        <input type="email" className="form-control" name="email" id="inputEmail1" aria-describedby="emailHelp" value={user.email} onChange={handleChange} />
                    </div>

                </div>
                <div className="form-group row">

                    <label htmlFor="inputPassword" className="col-sm-2 col-form-label">Password</label>
                    <div className='col-sm-10'>
                        <input type="password" className="form-control" name="password" minLength = "4" maxLength = "8" id="inputPassword" value={user.password} onChange={handleChange} />
                    </div>

                </div>
                <button type="submit" className="btn btn-primary">Submit</button>
            </form>
        </div>
    )
}

export default Login
