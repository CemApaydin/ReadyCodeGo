import React, {useState} from "react";
import Navbar from "./navbar1";
import {useNavigate, useSearchParams} from "react-router-dom";

export default function InstructorSignUpPage(){
    const navigate = useNavigate();
    const [searchParam] = useSearchParams();
    const [headingText, setHeadingText] = useState("Sign Up To The System");
    const [mouseOver, setMouseOver] = useState(false);
    const [error, setError] = useState(false);
    const [key, setKey] = useState(null);
    const [Username, setName] = useState(null);
    const [id, setId] = useState(null);
    const [surname, setSurname] = useState(null);
    const [password, setPassword] = useState(null);
    const [passwordAgain, setPasswordAgain] = useState(null);
    const [email, setEmail] = useState(null);
    const [emailAgain, setEmailAgain] = useState(null);
    function handleClick() {
        if(key == null || Username == null || id == null || surname == null || password == null || passwordAgain == null || email == null || emailAgain == null)
        {
            setHeadingText("Check boxes there is some empty ones");
            setError(true);
        }
        else if( email != emailAgain)
        {
            setHeadingText("E-mail is not correct");
            setError(true);
        }
        else if( password != passwordAgain)
        {
            setHeadingText("Password is not correct");
            setError(true);
        }
        else
        {
            let userType = (searchParam.get("signUpType"));
            let userID = id;
            let userMail = email;
            let toDoListId =(Math.floor(Math.random() * 1000000));

            let name = Username + " " + surname;
            if( userType === "instructor") {
                const instructor = {userID,name,userType,password,userMail,toDoListId}
                fetch("http://localhost:8080/instructor/createInstructor",{
                    method:"POST",
                    headers: {"Content-Type": "application/json"},
                    body:JSON.stringify(instructor)

                }).then(()=>{
                    console.log("New instructor added")
                })

            }
            else if( userType === "coordinator") {
                const coordinator = {userID,name,userType,password,userMail,toDoListId}
                fetch("http://localhost:8080/coordinator/createCoordinator",{
                    method:"POST",
                    headers: {"Content-Type": "application/json"},
                    body:JSON.stringify(coordinator)

                }).then(()=>{
                    console.log("New coordinator added")
                })

            }
            else if( userType === "facultyboardmember") {
                const facultyboardmember = {userID,name,userType,password,userMail,toDoListId}
                fetch("http://localhost:8080/facultyboardmember/createFacultyBoardMember",{
                    method:"POST",
                    headers: {"Content-Type": "application/json"},
                    body:JSON.stringify(facultyboardmember)

                }).then(()=>{
                    console.log("New coordinator added")
                })

            }
            navigate('/');
        }

    }

    function handleChangeKey(event){
        setKey(event.target.value);
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
                        <td><label >Key:</label></td>
                        <td>
                            <input
                                className="LogInText"
                                onChange={handleChangeKey}
                                required
                                maxLength="8" size="8"
                                type="text" placeholder="Key"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label >ID:</label></td>
                        <td>
                            <input
                                className="LogInText"
                                onChange={handleChangeID}
                                required
                                maxLength="8" size="8"
                                type="text" placeholder="ID:"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label >Name:</label></td>
                        <td>
                            <input
                                className="LogInText"
                                onChange={handleChangeName}
                                required
                                maxLength="8" size="8"
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
                                maxLength="8" size="8"
                                type="text" placeholder="Surname"/>
                        </td>
                    </tr>

                    <tr>
                        <td><label>E-Mail</label></td>
                        <td>
                            <input
                                className="LogInText"
                                onChange={handleChangeEmail}
                                type="text" placeholder="******@bilkent.ug.edu.tr"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label>E-Mail (Again)</label></td>
                        <td>
                            <input
                                className="LogInText"
                                onChange={handleChangeEmailAgain}
                                type="text" placeholder="******@bilkent.ug.edu.tr"/>
                        </td>
                    </tr>

                    <tr>
                        <td><label>password </label></td>
                        <td>
                            <input
                                className="LogInText"
                                onChange={handleChangePassword}
                                required
                                minLength="4" maxLength="8" size="10"
                                type="text" placeholder="Password"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label >password (Again)</label></td>
                        <td>
                            <input
                                className="LogInText"
                                onChange={handleChangePasswordAgain}
                                required
                                maxLength="8" size="8"
                                type="text" placeholder="Password"/>
                        </td>
                    </tr>
                </table>
                <button
                    className="LogInButton"
                    style={{backgroundColor: mouseOver ?  "red" : "white"}}
                    onClick={handleClick}
                    onMouseOver={handleMouse}
                    onMouseOut={handleMouseOut}>
                    Sign Up</button>
            </div>
        </div>



    )
}