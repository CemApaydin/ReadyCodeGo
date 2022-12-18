import React from "react";
import Navbar from "./StudentNavbar";
import OperationNavbar from "./OperationNavbar";
import ListItem from '@mui/material/ListItem';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';

export default function UploadTaskPage(){
    function Task(props)
    {
        let backGround;
        let font;
        if(props.taskStatue === "Wait")
        {
            backGround = "#256D85";
            font = true;
        }
        else if(props.taskStatue === "Accepted")
        {
            backGround = "#285430";
            font = true;
        }

        else if(props.taskStatue === "Rejected")
        {
            backGround = "#940000";
            font = true;
        }

        console.log(backGround);
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
                                        <p style={{color: font ? "white" : ""}}>{props.taskId} </p>
                                    </td>
                                </tr>
                                <tr style={{outline: "thin solid"}}>
                                    <td>
                                        <p style={{color: font ? "yellow" : "red"}}>Task Giver: </p>
                                    </td>
                                    <td>
                                        <p style={{color: font ? "white" : ""}}>{props.taskGiver} </p>
                                    </td>
                                </tr>
                                <tr style={{outline: "thin solid"}}>
                                    <td>
                                        <p style={{color: font ? "yellow" : "red"}}>Task Statue: </p>
                                    </td>
                                    <td>
                                        <p style={{color: font ? "white" : ""}}>{props.taskStatue} </p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <td>
                            <button className="taskButton2">SeeCommentsPDF</button>
                            <button className="taskButton2">UploadPDF</button>
                        </td>
                        <td>
                            <table className="taskCardTableRight">
                                <tr style={{outline: "thin solid"}}>
                                    <td>
                                        <p style={{color: font ? "yellow" : "red"}}>Task End Date: </p>
                                    </td>
                                    <td>
                                        <p style={{color: font ? "white" : ""}}>{props.taskEndDate} </p>
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
    return (
        <div>
            <Navbar/>
            <OperationNavbar/>
            <h1>Upload Task</h1>
            <Task taskId="1" taskGiver="Ercan Bahtiyaroğlu" taskStatue="Wait" taskEndDate="29/12/2022"/>
            <Task taskId="2" taskGiver="Salih demir" taskStatue="Wait" taskEndDate="29/12/2022"/>
            <Task taskId="3" taskGiver="Ali Ozturk" taskStatue="Rejected" taskEndDate="29/12/2022"/>
            <Task taskId="3" taskGiver="Emirhan Kurek" taskStatue="Rejected" taskEndDate="29/12/2022"/>
        </div>
    )
}