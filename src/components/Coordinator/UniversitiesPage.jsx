import Navbar from "./CoordinatorNavbar";
import OperationNavbar from "./OperationNavbar";
import React from "react";
export default function UniversitiesPage(){
    function Task(props)
    {
        let backGround;
        let font;
        if(props.taskStatue === "Wait")
        {
            backGround = "#256D85";
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
                                        <p style={{color: font ? "yellow" : "red"}}>Universit ID: </p>
                                    </td>
                                    <td>
                                        <p style={{color: font ? "white" : ""}}>{props.uniId} </p>
                                    </td>
                                </tr>
                                <tr style={{outline: "thin solid"}}>
                                    <td>
                                        <p style={{color: font ? "yellow" : "red"}}>University Name: </p>
                                    </td>
                                    <td>
                                        <p style={{color: font ? "white" : ""}}>{props.uniName} </p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <td>
                            <button className="taskButton2">Change Limit</button>
                            <button className="taskButton2">See Information</button>
                        </td>
                        <td>
                            <table className="taskCardTableRight">
                                <tr style={{outline: "thin solid"}}>
                                    <td>
                                        <p style={{color: font ? "yellow" : "red"}}>Current Occupation: </p>
                                    </td>
                                    <td>
                                        <p style={{color: font ? "white" : ""}}>{props.occupation} </p>
                                    </td>
                                </tr>
                                <tr style={{outline: "thin solid"}}>
                                    <td>
                                        <p style={{color: font ? "yellow" : "red"}}>Student Limit: </p>
                                    </td>
                                    <td>
                                        <p style={{color: font ? "white" : ""}}> 5 </p>
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
            <h1>Universities</h1>
            <Task uniId="1" uniName="Sydney University" taskStatue="Wait" occupation="4"/>
            <Task uniId="2" uniName="Münich University" taskStatue="Rejected" occupation="5"/>
            <Task uniId="3" uniName="Berlin University" taskStatue="Rejected" occupation="2"/>
            <Task uniId="4" uniName="Signapur University" taskStatue="Rejected" occupation="2"/>
        </div>
    )
}