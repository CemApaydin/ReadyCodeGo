import Navbar from "./CoordinatorNavbar";
import OperationNavbar from "./OperationNavbar";

import React, {useState} from "react";
import {createSearchParams, useNavigate, useSearchParams} from "react-router-dom";
import Button from '@mui/material/Button';


export default function CoordinatorCreateTaskPage(){
    const [searchParam] = useSearchParams();
    const [headingText, setHeadingText] = useState("Create Task");
    const [mouseOver, setMouseOver] = useState(false);
    const [error, setError] = useState(false);
    const [key, setKey] = useState(null);
    const [taskName, setTaskName] = useState(null);
    const [comment, setComment] = useState(null);
    const [user, setUser] = useState([]);
    const [user1, setUser1] = useState([]);
    const [user2, setUser2] = useState([])
    const [dueDate, setDueDate] = useState(null);
    const [type, setType] = useState("empty");
    const [receiverID, setReceiverID] = useState(null);
    const [length, setLength] = useState(null);
    function formatDate(string){
        const options = {year: 'numeric', month: 'long', day: 'numeric'};
        return new Date(string).toLocaleDateString([],options);
    }
    function handleClick() {
        if(taskName === null || dueDate === null || receiverID === null || type === "empty" || comment === null)
        {
            setHeadingText("Check boxes there is some empty ones");
            setError(true);
        }
        else
        {
            setDueDate( formatDate(dueDate));
            let taskSenderId = (searchParam.get("id"));
            let taskReceiverId = receiverID;
            let text = comment;
            let taskStatus = "Waiting";
            let done = false;
            const task = {taskName,taskSenderId,taskReceiverId,text,taskStatus,dueDate,done}
            fetch("http://localhost:8080/task/createTask",{
                method:"POST",
                headers: {"Content-Type": "application/json"},
                body:JSON.stringify(task)

            }).then(()=>{
                console.log("New Task added")
                setHeadingText("Task Created")
            })
        }
    }

    function handleChangeComment(event){
        setComment(event.target.value);
    }
    function handleChangeName(event){
        setTaskName(event.target.value);
    }
    function handleChangeKey(event){
        setKey(event.target.value);
        setUser(null);
        setUser1(null);
        setUser2(null);
        getAll();
    }
    function handleChangeDueDate(event){
        setDueDate(event.target.value);
    }
    function handleChangeType(event){
        setUser(null);
        setUser1(null);
        setUser2(null);
        getAll();
        setType(event.target.value);
    }
    function handleMouse(){
        setMouseOver(true);
    }
    function handleMouseOut(){
        setMouseOver(false);
    }
    function getAll()
    {
        if( type !== "empty")
        {
            fetch("http://localhost:8080/"+ type +"/findAll")
                .then(res=>res.json())
                .then(
                    (result) => {
                        setLength(result.length);
                        let number = 0;
                        for( let i = 0; i < result.length; i++)
                        {
                            if( result[i].name.includes(key))
                            {
                                if( number === 0)
                                {
                                    setUser(result[i]);
                                    number++;
                                }
                                else if( number === 1)
                                {
                                    setUser1(result[i]);
                                    number++;
                                }
                                else if( number === 2)
                                {
                                    setUser2(result[i]);
                                    number++;
                                }

                                if(number === 3)
                                {
                                    break;
                                }
                            }
                        }
                    },
                );
        }


    }
    function handleChangeReceiver(event)
    {
        setReceiverID(event.target.value)
    }
    function userRender()
    {
        if( user === null)
            return <option value= "empty">--Empty--</option>
        else
            return <option value={ user.userID}>{ user.name}</option>
    }
    function userRender1()
    {
        if( user1 === null)
            return <option value= "empty">--Empty--</option>
        else
            return <option value={ user1.userID}>{ user1.name}</option>
    }
    function userRender2()
    {
        if( user2 === null)
            return <option value= "empty">--Empty--</option>
        else
            return <option value={ user2.userID}>{ user2.name}</option>
    }

    return (
        <div>
            <Navbar/>
            <OperationNavbar/>
            <div className="LogInPageDiv">
                <h1 className={error ? "error" : ""}>{headingText}</h1>
                <table className="signupTable">
                    <tr>
                        <td><label >Task Name:</label></td>
                        <td>
                            <input
                                className="LogInText"
                                onChange={handleChangeName}
                                required
                                maxLength="8" size="20"
                                type="text" placeholder=" Task Name"/>
                        </td>
                    </tr>
                    <tr>
                        <td><label >Task Due Date:</label></td>
                        <td>
                            <input
                                className="LogInText"
                                onChange={handleChangeDueDate}
                                required
                                maxLength="8" size="20"
                                type="date" placeholder="DD/MM/YYYY"/>
                        </td>
                    </tr>

                    <tr>
                        <td><label htmlFor="logInType">Choose user type:</label> </td>

                        <td>
                                <select className="LogInText" name="logInType" id="logInType" onChange={handleChangeType}>
                                    <option value="empty">--Select--</option>
                                    <option value="student">Student</option>
                                    <option value="facultyBoard">FacultyAdministrationBoard</option>
                                    <option value="instructor">Instructor</option>
                                    <option value="coordinator">Coordinator</option>
                                </select>

                        </td>
                    </tr>
                    <tr>
                        <td><label >Search key:</label></td>
                        <td>
                            <input
                                className="LogInText"
                                onChange={handleChangeKey}
                                required
                                maxLength="8" size="20"
                                type="text" placeholder="..."/>
                        </td>
                    </tr>
                    <tr>

                        <td><label htmlFor="logInType">Choose User: </label></td>

                            <td>
                                <select name="logInType" id="logInType" onChange={handleChangeReceiver}>
                                    {userRender()}
                                    {userRender1()}
                                    {userRender2()}
                                </select>
                            </td>
                    </tr>
                    <tr>
                        <td><label >Receiver ID:</label></td>
                        <td>
                            <p>{receiverID}</p>
                        </td>
                    </tr>
                    <tr>
                        <td><label >Task Comment:</label></td>
                        <td>
                            <input
                                className="LogInText"
                                onChange={handleChangeComment}
                                required
                                maxLength="8" size="20"
                                type="text" placeholder="..."/>
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
                    Submit</Button>
            </div>
        </div>
    )
}