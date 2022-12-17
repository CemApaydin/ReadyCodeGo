import React, {useEffect, useState} from "react";
import Navbar from "./navbar1"
import {Routes, Route, useNavigate, Navigate, createSearchParams} from 'react-router-dom';
import {useSearchParams} from "react-router-dom";
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Select from '@mui/material/Select';
import MenuItem from '@mui/material/MenuItem';
import Typography from '@mui/material/Typography';
import InputLabel from '@mui/material/InputLabel';
import FormControl from '@mui/material/FormControl';

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

        if( type === "student")
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
            fetch("http://localhost:8080/coordinator/" +id,)
                .then(res=>res.json())
                .then(
                    (result) => {
                        if( result.password === password )
                        {

                            navigate(
                                {
                                    pathname: '/CoordinatorMainPage',
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
        else if( type === "instructor")
        {
            fetch("http://localhost:8080/instructor/" +id,)
                .then(res=>res.json())
                .then(
                    (result) => {
                        if( result.password === password )
                        {

                            navigate(
                                {
                                    pathname: '/InstructorMainPage',
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
        else if( type === "facultyBoard")
        {
            fetch("http://localhost:8080/facultyboardmember/" +id,)
                .then(res=>res.json())
                .then(
                    (result) => {
                        if( result.password === password )
                        {

                            navigate(
                                {
                                    pathname: '/FacultyMemberMainPage',
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
        else if ( type === "empty")
        {
            setHeadingText("Select a log in type");
            setLogInError(true);
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
                <div className="LogInPageDiv">
                    <h1 className={LogInError ? "error" : ""}>{headingText}</h1>
                    <table className="loginTable">

                        <FormControl variant="standard" sx={{ m: 1, minWidth: 120 }}>
                            <InputLabel id="logInType">Select Type</InputLabel>
                        <Select name="logInType" id="logInType" label="Select User Type" size="25" onChange={handleChangeType}>
                            <MenuItem value="student">Student</MenuItem>
                            <MenuItem value="facultyBoard">FacultyAdministrationBoard</MenuItem>
                            <MenuItem value="instructor">Instructor</MenuItem>
                            <MenuItem value="coordinator">Coordinator</MenuItem>
                        </Select>
                        </FormControl>


                    <br />
                    <label htmlFor="name">
                        {/*<td><label >ID:</label ></td>*/}
                    <TextField
                        className="LogInText"
                        onChange={handleChangeId}
                        name="id"

                        autoFocus
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth

                        type="text" placeholder="Enter ID"/>
                    </label>
                    <br />
                    <label htmlFor="password">
                        {/*<td><label >Password:</label ></td>*/}
                    <TextField
                        className="LogInText"
                        onChange={handleChangePassword}
                        name="password" required size="20"

                        autoFocus
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth

                        type="password" placeholder="Enter Password"/>
                    </label>
                    <br />
                    </table>
                    <Button variant = "contained"
                        className="MainButton"
                        style={{backgroundColor: mouseOver ?  "gray" : "black"}}
                        onClick={handleClick}
                        onMouseOver={handleMouse}
                        onMouseOut={handleMouseOut}>
                        Log In</Button>
                </div>
            </div>



    )
}

