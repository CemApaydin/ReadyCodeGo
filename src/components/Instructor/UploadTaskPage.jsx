import Navbar from "../Instructor/InstructorNavbar";
import OperationNavbar from "../Instructor/OperationNavbar";
import React from "react";

export default function InstructorUploadTaskPage(){
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
                            <button className="taskButton">SeeCommentsPDF</button>
                            <button className="taskButton">UploadPDF</button>
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
            <Task taskId="1" taskGiver="Ercan Bahtiyaroğlu" taskStatue="Wait" taskEndDate="29/12/2022"/>
            <Task taskId="1" taskGiver="Ercan Bahtiyaroğlu" taskStatue="Wait" taskEndDate="29/12/2022"/>
            <Task taskId="3" taskGiver="Ercan Bahtiyaroğlu" taskStatue="Rejected" taskEndDate="29/12/2022"/>
            <Task taskId="3" taskGiver="Ercan Bahtiyaroğlu" taskStatue="Rejected" taskEndDate="29/12/2022"/>
        </div>
    )
}