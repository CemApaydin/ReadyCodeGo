import Navbar from "./CoordinatorNavbar";
import OperationNavbar from "./OperationNavbar";
import React, {useState} from "react";
import {useSearchParams} from "react-router-dom";

export default function CoordinatorApplicationsPage(){
    const [applicationList, setapplicationList] = useState([]);
    const [applicationList1, setapplicationList1] = useState([]);
    const [applicationList2, setapplicationList2] = useState([]);
    const [searchParam] = useSearchParams();
    const [id] = useState(searchParam.get("id"));
    async function takeApplications() {
        if( applicationList.length === 0){
            console.log("start");
            await fetch("http://localhost:8080/coordinator/getApplication/" + id)
                .then(res => res.json())
                .then(async (result) => {
                    let number = 0;
                    console.log(result);
                    for (let i = 0; i < result.length; i++) {
                        console.log(result[i]);
                        await fetch("http://localhost:8080/application/" + result[i])
                            .then(res => res.json())
                            .then(
                                (applicationObject) => {
                                    console.log(applicationObject);
                                    if (number === 0 ) {
                                        setapplicationList(applicationObject);

                                    } else if (number === 1) {
                                        setapplicationList1(applicationObject);

                                    } else if (number === 2 ) {
                                        setapplicationList2(applicationObject);

                                    }
                                })
                        number++;
                        if (number === 3) {
                            break;
                        }
                    }

                })
        }
    }
    function Application(props)
    {
        if(props.applicationObject.length === 0)
        {
            return null;
        }
        else
        {
            let backGround;
            let font;
            if (props.applicationObject.applicationStatus === "Pending") {
                backGround = "#256D85";
                font = true;
            } else if (props.applicationObject.applicationStatus === "Accepted") {
                backGround = "#285430";
                font = true;
            } else if (props.applicationObject.applicationStatus === "Rejected") {
                backGround = "#940000";
                font = true;
            }

                return (

                    <div className="taskCard">
                        <table className="taskCardTableMain" style={{backgroundColor: backGround}}>
                            <tr>
                                <td>
                                    <table className="taskCardTableLeft">
                                        <tr style={{outline: "thin solid"}}>
                                            <td>
                                                <p style={{color: font ? "yellow" : "red"}}>Application ID: </p>
                                            </td>
                                            <td>
                                                <p style={{color: font ? "white" : ""}}>{props.applicationObject.applicationID} </p>
                                            </td>
                                        </tr>
                                        <tr style={{outline: "thin solid"}}>
                                            <td>
                                                <p style={{color: font ? "yellow" : "red"}}>Cancellation: </p>
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
                                                <p style={{color: font ? "white" : ""}}>{props.applicationObject.applicationStatus} </p>
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
                                                <p style={{color: font ? "white" : ""}}> </p>
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
    takeApplications();
    return (
        <div>
            <Navbar/>
            <OperationNavbar/>
            <Application applicationObject ={applicationList}/>
            <Application applicationObject ={applicationList1}/>
            <Application applicationObject ={applicationList2}/>

        </div>
    )
}