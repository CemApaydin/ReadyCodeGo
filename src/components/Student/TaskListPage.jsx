import React, {useState} from "react";
import Navbar from "./StudentNavbar";
import OperationNavbar from "./OperationNavbar";
import {useSearchParams} from "react-router-dom";

export default function TaskListPage(){
    const [task, setTask] = useState([]);
    const [task1, setTask1] = useState([]);
    const [task2, setTask2] = useState([]);
    const [taskTaken, setTaskTaken] = useState([]);
    const [taskTaken1, setTaskTaken1] = useState([]);
    const [taskTaken2, setTaskTaken2] = useState([]);
    const [searchParam] = useSearchParams();
    const [id] = useState(searchParam.get("id"));
    async function getTasksGiven() {
        if (task.length === 0) {
            await fetch("http://localhost:8080/user/getToDo/" + id)
                .then(res => res.json())
                .then(async (todoListID) => {
                    await fetch("http://localhost:8080/toDoList/getLast/" + todoListID)
                        .then(res => res.json())
                        .then(async (result) => {
                            let number = 0;

                            for (let i = 0; i < result.length; i++) {
                                console.log(result[i]);
                                await fetch("http://localhost:8080/task/" + result[i])
                                    .then(res => res.json())
                                    .then(
                                        (taskObject) => {

                                            if (number === 0) {
                                                setTask(taskObject);

                                            } else if (number === 1) {
                                                setTask1(taskObject);

                                            } else if (number === 2) {
                                                setTask2(taskObject);

                                            }
                                        })
                                number++;
                                if (number === 3) {
                                    break;
                                }
                            }

                        })
                })

        }
    }
    getTasksGiven();
    function Task1(props)
    {

        if(props.taskObject.length === 0)
        {
            return null;
        }
        else
        {
            let backGround;
            let font;
            if(props.taskObject.taskStatus === "Waiting")
            {
                backGround = "#256D85";
                font = true;
            }
            else if(props.taskObject.taskStatus === "Accepted")
            {
                backGround = "#285430";
                font = true;
            }

            else if(props.taskObject.taskStatus === "Rejected")
            {
                backGround = "#940000";
                font = true;
            }
            return(
                <div className="taskCard">
                    <table  className="taskCardTableMain"  style={{backgroundColor: backGround}}>
                        <tr>
                            <td>
                                <table className="taskCardTableLeft">
                                    <tr style={{outline: "thin solid"}}>
                                        <td>
                                            <p style={{color: font ? "yellow" : "red"}}>Task ID: </p>
                                        </td>
                                        <td>
                                            <p style={{color: font ? "white" : ""}}>{props.taskObject.taskId} </p>
                                        </td>
                                    </tr>
                                    <tr style={{outline: "thin solid"}}>
                                        <td>
                                            <p style={{color: font ? "yellow" : "red"}}>Task Name: </p>
                                        </td>
                                        <td>
                                            <p style={{color: font ? "white" : ""}}>{props.taskObject.taskName} </p>
                                        </td>
                                    </tr>
                                    <tr style={{outline: "thin solid"}}>
                                        <td>
                                            <p style={{color: font ? "yellow" : "red"}}>Task Statue: </p>
                                        </td>
                                        <td>
                                            <p style={{color: font ? "white" : ""}}>{props.taskObject.taskStatus} </p>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td>
                                <button className="taskButton">SeeCommentsPDF</button>
                            </td>
                            <td>
                                <table className="taskCardTableRight">
                                    <tr style={{outline: "thin solid"}}>
                                        <td>
                                            <p style={{color: font ? "yellow" : "red"}}>Task End Date: </p>
                                        </td>
                                        <td>
                                            <p style={{color: font ? "white" : ""}}>{props.taskObject.dueDate} </p>
                                        </td>
                                    </tr>
                                    <tr style={{outline: "thin solid"}}>
                                        <td>
                                            <p style={{color: font ? "yellow" : "red"}}>Remaining Time: </p>
                                        </td>
                                        <td>
                                            <p style={{color: font ? "white" : ""}}>20 days </p>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>

                    <hr/>
                </div>
            );
        }

    }
    return (
        <div>
            <Navbar/>
            <OperationNavbar/>
            <h2>Given Tasks</h2>
            <hr/>
            <Task1 taskObject = {task}/>
            <Task1 taskObject = {task1}/>
            <Task1 taskObject = {task2}/>
        </div>
    )
}