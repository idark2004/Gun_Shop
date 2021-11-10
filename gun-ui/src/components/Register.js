
import axios from 'axios';
import React, { useState } from 'react';
import moment from 'moment';


function Register() {
    const [user, setUser] = useState({
        email : '',
        password : '',
        username : '',
        birth_date : ''
    });

    const handleChange = (e) =>{
        const name = e.target.name;
        const value = e.target.value;
        setUser(
            user => ({
                ...user,
                [name]:value
            })
        )
    }

    const submitHandle = (event) => {
        event.preventDefault();
        console.log(user);
        axios.post('http://localhost:8080/api/user',{
            email : user.email,
            user_name : user.username,
            pass_word : user.password,
            birth_date : user.birth_date
        }).then((response) =>{
            console.log(response)
            window.location ='/login'
        })
    }
    return (
        <div className="form-control flex-container center" style={{
            width : "80vw",
            margin : "auto",
            marginTop : "6%"
        }}>
            <form className="flex-item" onSubmit={e => submitHandle(e)}>
                <div className="row">
                    <div className="col-sm">                    
                    <label htmlFor="exampleInputEmail1" className="form-label">Email address</label>
                    </div>
                    <div className="col-sm">
                    <input type="email" className="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" value={user.email} onChange={handleChange}/>                        
                    </div>
                </div>
                <div className="row">
                    <div className="col-sm">
                    <label htmlFor="exampleInputPassword1" className="form-label">Password</label>
                    </div>
                    <div className="col-sm">
                    <input type="password" className="form-control" minLength = "4" maxLength = "8" name="password" id="exampleInputPassword1" value={user.password} onChange={handleChange} />
                    </div>
                </div>
                <div className="row">
                    <div className="col-sm">
                    <label htmlFor="inputUserName" className="form-label">User Name</label>
                    </div>
                    <div className="col-sm">
                    <input type="text" className="form-control" name="username" pattern ="[A-Za-z]{2,}" title="Name need to have at least 2 characters" id="inputUserName" value={user.username} onChange={handleChange} />
                    </div>
                </div>
                <div className="row">
                    <div className="col-sm">
                    <label htmlFor="inputBirthDate" className="form-label">Birth Date</label>
                    </div>
                    <div className="col-sm">
                    <input type="date" className="form-control" name="birth_date" id="inputBirthDate"  maxdate={moment().format("MM-DD-YYYY")} value={user.birth_date} onChange={handleChange} />
                    </div>
                </div>

                <button type="submit" className="btn btn-primary">Submit</button>
            </form>
        </div>
    )
}

export default Register

