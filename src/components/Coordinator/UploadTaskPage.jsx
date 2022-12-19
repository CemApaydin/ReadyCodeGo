import Navbar from "./CoordinatorNavbar";
import OperationNavbar from "./OperationNavbar";
import React, {useState} from "react";
import {useSearchParams} from "react-router-dom";

export default function CoordinatorUploadTaskPage(){
    const [task, setTask] = useState([]);
    const [task1, setTask1] = useState([]);
    const [task2, setTask2] = useState([]);
    const [searchParam] = useSearchParams();
    const [id] = useState(searchParam.get("id"));
    const [selectedFile, setSelectedFile] = useState();
    const [isSelected, setIsSelected] = useState(false);

    async function getTasksTaken() {
        if (task.length === 0) {
            await fetch("http://localhost:8080/user/getToDo/" + id)
                .then(res => res.json())
                .then(async (todoListID) => {
                    await fetch("http://localhost:8080/toDoList/getTaken/" + todoListID)
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
    getTasksTaken();
    function handleClick1() {
        let taskID = task.taskId;
        const today = new Date();
        let uploadDate;
        uploadDate = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
        let uploaderId = id;
        const document ={ uploadDate, uploaderId}
        fetch("http://localhost:8080/document/createDocument",{
            method:"POST",
            headers: {"Content-Type": "application/json"},
            body:JSON.stringify(document)

        }).then(async (result) => {
            const documentID = await result.json()
            await fetch("http://localhost:8080/task/addAttachment/" + taskID, {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(documentID)

            })
            const formData = new FormData();

            formData.append('file', selectedFile);
            formData.append('userID', id);
            formData.append('documentID', documentID);

            await fetch("http://localhost:8080/filestorage/upload", {
                method: "POST",
                body: formData,

            })
        })
        let newStatus = "Submitted"
        fetch("http://localhost:8080/task/updateStatus/" + taskID, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: newStatus

        }).then(async (result) => {
        })
    }
    function handleClick2() {
        let taskID = task1.taskId;
        const today = new Date();
        let uploadDate;
        uploadDate = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
        let uploaderId = id;
        const document ={ uploadDate, uploaderId}
        fetch("http://localhost:8080/document/createDocument",{
            method:"POST",
            headers: {"Content-Type": "application/json"},
            body:JSON.stringify(document)

        }).then(async (result) => {
            const documentID = await result.json()
            await fetch("http://localhost:8080/task/addAttachment/" + taskID, {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(documentID)

            })
            const formData = new FormData();

            formData.append('file', selectedFile);
            formData.append('userID', id);
            formData.append('documentID', documentID);

            await fetch("http://localhost:8080/filestorage/upload", {
                method: "POST",
                body: formData,

            })
        })
        let newStatus = "Submitted"
        fetch("http://localhost:8080/task/updateStatus/" + taskID, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: newStatus

        }).then(async (result) => {
        })
    }
    function handleClick3() {
        let taskID = task2.taskId;
        const today = new Date();
        let uploadDate;
        uploadDate = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
        let uploaderId = id;
        const document ={ uploadDate, uploaderId}
        fetch("http://localhost:8080/document/createDocument",{
            method:"POST",
            headers: {"Content-Type": "application/json"},
            body:JSON.stringify(document)

        }).then(async (result) => {
            const documentID = await result.json()
            await fetch("http://localhost:8080/task/addAttachment/" + taskID, {
                method: "POST",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(documentID)

            })
            const formData = new FormData();

            formData.append('file', selectedFile);
            formData.append('userID', id);
            formData.append('documentID', documentID);

            await fetch("http://localhost:8080/filestorage/upload", {
                method: "POST",
                body: formData,

            })
        })
        let newStatus = "Submitted"
        fetch("http://localhost:8080/task/updateStatus/" + taskID, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: newStatus

        }).then(async (result) => {
        })
    }
    function changeHandler(event) {
        setSelectedFile(event.target.files[0]);
        setIsSelected(true);
    }
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
            else if(props.taskObject.taskStatus === "Submitted")
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
                                <table>
                                    <tr>
                                        <button className="taskButton">SeeCommentsPDF</button>
                                    </tr>
                                    <tr>
                                        <label >Task PDF:</label>
                                        <input type="file" name="file" onChange={changeHandler} />
                                    </tr>
                                    <tr>
                                        <button className="taskButton"
                                                onClick={handleClick1}
                                        >Upload PDF</button>

                                    </tr>
                                    <tr>
                                        {isSelected ? (
                                            <>
                                                <p>Filename: {selectedFile.name}</p>
                                            </>
                                        ):( <p>Filename: none</p>)}

                                    </tr>
                                </table>

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
    function Task2(props)
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
            else if(props.taskObject.taskStatus === "Submitted")
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
                                <table>
                                    <tr>
                                        <button className="taskButton">SeeCommentsPDF</button>
                                    </tr>
                                    <tr>
                                        <label >Task PDF:</label>
                                        <input type="file" name="file" onChange={changeHandler} />
                                    </tr>
                                    <tr>
                                        <button className="taskButton"
                                                onClick={handleClick2}
                                        >Upload PDF</button>

                                    </tr>
                                    <tr>
                                        {isSelected ? (
                                            <>
                                                <p>Filename: {selectedFile.name}</p>
                                            </>
                                        ):( <p>Filename: none</p>)}

                                    </tr>
                                </table>

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
    function Task3(props)
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
            else if(props.taskObject.taskStatus === "Submitted")
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
                                <table>
                                    <tr>
                                        <button className="taskButton">SeeCommentsPDF</button>
                                    </tr>
                                    <tr>
                                        <label >Task PDF:</label>
                                        <input type="file" name="file" onChange={changeHandler} />
                                    </tr>
                                    <tr>
                                        <button className="taskButton"
                                                onClick={handleClick3}
                                        >Upload PDF</button>

                                    </tr>
                                    <tr>
                                        {isSelected ? (
                                            <>
                                                <p>Filename: {selectedFile.name}</p>
                                            </>
                                        ):( <p>Filename: none</p>)}

                                    </tr>
                                </table>

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
            <h2>Taken Tasks</h2>
            <hr/>
            <Task1 taskObject = {task}/>
            <Task2 taskObject = {task1}/>
            <Task3 taskObject = {task2}/>
        </div>
    )
}