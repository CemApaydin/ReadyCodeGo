import React, {useEffect, useState} from "react";
import Navbar from "./navbar1"
import {Routes, Route, useNavigate, Navigate, createSearchParams} from 'react-router-dom';
import {useSearchParams} from "react-router-dom";
export default function LogInPage(){
    const navigate = useNavigate();
    const [searchParam] = useSearchParams();
    const [headingText, setHeadingText] = useState("Log In To System");
    const [LogInError, setLogInError] =useState(false);
    const [mouseOver, setMouseOver] = useState(false);
    const [id, setId] = useState(null);
    const [password, setPassword] = useState(null);
    const [type, setType] = useState(null);

    function handleClick() {
        setHeadingText("Submitted");
        if( type == "student")
        {
            fetch("http://localhost:8080/student/" +id,)
                .then(res=>res.json())
                .then(
                    (result) => {
                        if( result.password === password )
                        {

                            navigate(
                                {
                                    pathname: '/StudentMainPage',
                                    search: createSearchParams(
                                        {
                                            id: id,
                                        }).toString()
                                });
                        }
                        else
                        {
                            setHeadingText("Wrong Password");
                            setLogInError(true);
                        }
                    },
                    (error) => {
                        setHeadingText("Wrong ID");
                        setLogInError(true);
                    }
                )
        }

        else if( type === "coordinator")
        {
            console.log(type, id, password)
            navigate('/CoordinatorMainPage');
        }
        else if( type === "instructor")
        {
            console.log(type, id, password)
            navigate('/InstructorMainPage');
        }
        else if( type === "facultyBoard")
        {
            console.log(type, id, password)
            navigate('/FacultyMemberMainPage');
        }
    }

    function handleChangeType(event){
        setType(event.target.value);
    }
    function handleChangeId(event){
        setId(event.target.value);
    }
    function handleChangePassword(event){
        setPassword(event.target.value);
    }
    function handleMouse(){
        setMouseOver(true);
    }
    function handleMouseOut(){
        setMouseOver(false);
    }
    return(
            <div>
                <Navbar />
                <h1 className={LogInError ? "error" : ""}>{headingText}</h1>
                <label htmlFor="logInType">Choose log in type:

                    <select name="logInType" id="logInType" onChange={handleChangeType}>
                        <option value="empty">--Empty--</option>
                        <option value="student">Student</option>
                        <option value="facultyBoard">FacultyAdministrationBoard</option>
                        <option value="instructor">Instructor</option>
                        <option value="coordinator">Coordinator</option>
                    </select>
                </label>
                <br />
                <label htmlFor="name">

                <input
                    className="LogInText"
                    onChange={handleChangeId}
                    name="id" required size="10"
                    type="text" placeholder="ID"/>
                </label>
                <br />
                <label htmlFor="password">

                <input
                    className="LogInText"
                    onChange={handleChangePassword}
                    name="password" required size="10"
                    type="text" placeholder="Password"/>
                </label>
                <br />

                <button
                    className="LogInButton"
                    style={{backgroundColor: mouseOver ?  "red" : "white"}}
                    onClick={handleClick}
                    onMouseOver={handleMouse}
                    onMouseOut={handleMouseOut}>
                    Log In</button>

            </div>



    )
}

