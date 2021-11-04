
import axios from 'axios';
import React, { useState } from 'react'


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
        })
    }
    return (
        <div className="form-control">
            <form onSubmit={e => submitHandle(e)}>
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
                    <input type="password" className="form-control" name="password" id="exampleInputPassword1" value={user.password} onChange={handleChange} />
                    </div>
                </div>
                <div className="row">
                    <div className="col-sm">
                    <label htmlFor="inputUserName" className="form-label">User Name</label>
                    </div>
                    <div className="col-sm">
                    <input type="text" className="form-control" name="username" id="inputUserName" value={user.username} onChange={handleChange} />
                    </div>
                </div>
                <div className="row">
                    <div className="col-sm">
                    <label htmlFor="inputBirthDate" className="form-label">Birth Date</label>
                    </div>
                    <div className="col-sm">
                    <input type="date" className="form-control" name="birth_date" id="inputBirthDate" value={user.birth_date} onChange={handleChange} />
                    </div>
                </div>

                <button type="submit" className="btn btn-primary">Submit</button>
            </form>
        </div>
    )
}

export default Register

