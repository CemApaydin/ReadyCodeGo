import Navbar from "./CoordinatorNavbar";
import OperationNavbar from "./OperationNavbar";
import React from "react";

export default function CoordinatorApplicationsPage(){
    function Application(props)
    {
        let backGround;
        let font;
        if(props.appStatue === "Wait")
        {
            backGround = "#256D85";
            font = true;
        }
        else if(props.appStatue === "Accepted")
        {
            backGround = "#285430";
            font = true;
        }

        else if(props.appStatue === "Rejected")
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
                                        <p style={{color: font ? "yellow" : "red"}}>Application ID: </p>
                                    </td>
                                    <td>
                                        <p style={{color: font ? "white" : ""}}>{props.appID} </p>
                                    </td>
                                </tr>
                                <tr style={{outline: "thin solid"}}>
                                    <td>
                                        <p style={{color: font ? "yellow" : "red"}}>Application Owner: </p>
                                    </td>
                                    <td>
                                        <p style={{color: font ? "white" : ""}}>{props.appOwner} </p>
                                    </td>
                                </tr>
                                <tr style={{outline: "thin solid"}}>
                                    <td>
                                        <p style={{color: font ? "yellow" : "red"}}>Cancelation: </p>
                                    </td>
                                    <td>
                                        <p style={{color: font ? "white" : ""}}>No </p>
                                    </td>
                                </tr>
                                <tr style={{outline: "thin solid"}}>
                                    <td>
                                        <p style={{color: font ? "yellow" : "red"}}>App Status: </p>
                                    </td>
                                    <td>
                                        <p style={{color: font ? "white" : ""}}>{props.appStatue} </p>
                                    </td>
                                </tr>
                            </table>
                        </td>
                        <td>
                            <button className="taskButton">See Comments PDF</button>
                            <button className="taskButton">Upload A File</button>
                            <button className="taskButton">See Transcript</button>
                            <button className="taskButton">See Progress</button>
                            <button className="taskButton">Cancel Applicaiton</button>

                        </td>
                        <td>
                            <table className="taskCardTableRight">
                                <tr style={{outline: "thin solid"}}>
                                    <td>
                                        <p style={{color: font ? "yellow" : "red"}}>University: </p>
                                    </td>
                                    <td>
                                        <p style={{color: font ? "white" : ""}}>{props.university} </p>
                                    </td>
                                </tr>
                                <tr style={{outline: "thin solid"}}>
                                    <td>
                                        <p style={{color: font ? "yellow" : "red"}}>Application Date: </p>
                                    </td>
                                    <td>
                                        <p style={{color: font ? "white" : ""}}>{props.taskEndDate} </p>
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
            <Application appID="1" appOwner="Sedef Keskin" coordinator ="Eray Tüzün" appStatue="Accepted" university = "Sydney University"taskEndDate="17/09/2022"/>
            <Application appID="2" appOwner="Cem Apaydın" coordinator ="Eray Tüzün" appStatue="Accepted" university = "Münich University"taskEndDate="17/09/2022"/>
            <Application appID="3" appOwner="Kaan Örnek" coordinator ="Eray Tüzün" appStatue="Accepted" university = "Berlin University"taskEndDate="17/09/2022"/>
            <Application appID="4" appOwner="Ali Öztürk" coordinator ="Eray Tüzün" appStatue="Accepted" university = "Singapur Univeristy"taskEndDate="17/09/2022"/>

        </div>
    )
}