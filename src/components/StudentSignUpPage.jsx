import React, {useState} from "react";
import Navbar from "./navbar1"
import {Routes, Route, useNavigate, createSearchParams, Navigate} from 'react-router-dom';
import Button from '@mui/material/Button';
export default function StudentSignUpPage(){
    const navigate = useNavigate();
    const [headingText, setHeadingText] = useState("Sign Up To The System");
    const [mouseOver, setMouseOver] = useState(false);
    const [error, setError] = useState(false);
    const [Username, setName] = useState(null);
    const [id, setId] = useState(null);
    const [surname, setSurname] = useState(null);
    const [password, setPassword] = useState(null);
    const [passwordAgain, setPasswordAgain] = useState(null);
    const [email, setEmail] = useState(null);
    const [emailAgain, setEmailAgain] = useState(null);
    function handleClick() {
        if(Username == null || id == null || surname == null || password == null || passwordAgain == null || email == null || emailAgain == null)
        {
            setHeadingText("Check boxes there are some empty ones");
            setError(true);
        }
        else if( email !== emailAgain)
        {
            setHeadingText("E-mail is not correct");
            setError(true);
        }
        else if( password !== passwordAgain)
        {
            setHeadingText("Password is not correct");
            setError(true);
        }

        else
        {
            let userID = id;
            let userMail = email;
            let toDoListId =(Math.floor(Math.random() * 1000000));
            let department = "";
            let placementGrade = 0.0;
            let coordinatorId = 0;
            let applicationId = 0;
            let userType = "student";

            let name = Username + " " + surname;
            const student = {userID,name,userType,password,userMail,applicationId,coordinatorId,department,placementGrade, toDoListId}
            fetch("http://localhost:8080/student/createStudent",{
                method:"POST",
                headers: {"Content-Type": "application/json"},
                body:JSON.stringify(student)

            }).then(()=>{
                console.log("New Student added")
            })
        }

        let userID = id;
        navigate(
                {
                    pathname: '/',
                    search: createSearchParams({
                        id: userID
                    }).toString()
                });
    }


    function handleChangeName(event){
        setName(event.target.value);
    }
    function handleChangeID(event){
        setId(event.target.value);
    }
    function handleChangePassword(event){
        setPassword(event.target.value);
    }
    function handleChangeSurname(event){
        setSurname(event.target.value);
    }
    function handleChangePasswordAgain(event){
        setPasswordAgain(event.target.value);
    }
    function handleChangeEmail(event){
        setEmail(event.target.value);
    }
    function handleChangeEmailAgain(event){
        setEmailAgain(event.target.value);
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
            <div className="LogInPageDiv">
                <h1 className={error ? "error" : ""}>{headingText}</h1>
                <table className="signupTable">
                    <tr>
                        <td><label >ID:</label ></td>
                        <td>
                            <input
                                className="LogInText"
                                onChange={handleChangeID}
                                required
                                maxLength="8" size="20"
                                type="text" placeholder="ID"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label >Name:</label></td>
                        <td>
                            <input
                                className="LogInText"
                                onChange={handleChangeName}
                                required
                                maxLength="8" size="20"
                                type="text" placeholder="Name"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label >Surname:</label></td>
                        <td>
                            <input
                            className="LogInText"
                            onChange={handleChangeSurname}
                            required
                            maxLength="8" size="20"
                            type="text" placeholder="Surname"/>
                        </td>
                    </tr>

                    <tr>
                        <td><label>E-Mail:</label></td>
                        <td>
                            <input
                                className="LogInText"
                                onChange={handleChangeEmail}
                                size="20"
                                type="text" placeholder="******@bilkent.ug.edu.tr"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>E-Mail(Again):</label></td>
                        <td>
                            <input
                                className="LogInText"
                                onChange={handleChangeEmailAgain}
                                type="text" placeholder="******@bilkent.ug.edu.tr"/>
                        </td>
                    </tr>

                    <tr>
                        <td><label>Password: </label></td>
                        <td>
                            <input
                            className="LogInText"
                            onChange={handleChangePassword}
                            required
                            minLength="4" maxLength="8" size="20"
                            type="password" placeholder="Password"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label >Password(Again):</label></td>
                        <td>
                            <input
                                className="LogInText"
                                onChange={handleChangePasswordAgain}
                                required
                                maxLength="8" size="20"
                                type="password" placeholder="Password"/>
                        </td>
                    </tr>
                </table>
                <Button
                    variant = "contained"
                    className="LogInButton"
                    style={{backgroundColor: mouseOver ?  "gray" : "black"}}
                    onClick={handleClick}
                    onMouseOver={handleMouse}
                    onMouseOut={handleMouseOut}>
                    Sign Up</Button>
            </div>
        </div>
    )
}