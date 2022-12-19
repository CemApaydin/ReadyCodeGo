import Navbar from "./CoordinatorNavbar";
import OperationNavbar from "./OperationNavbar";
import React, {useState} from "react";
import {useSearchParams} from "react-router-dom";
export default function CoordinatorWaitingBin()
{
    const [universityList1, setUniversityList1] = useState([]);
    const [universityList2, setUniversityList2] = useState([]);
    const [universityList, setUniversityList] = useState([]);
    const [searchParam] = useSearchParams();
    const [id] = useState(searchParam.get("id"));
    async function takeApplications() {
        if( universityList.length === 0){
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
                                (universityObject) => {

                                    if (number === 0 && universityObject.applicationStatus === "Pending") {
                                        setUniversityList(universityObject);

                                    } else if (number === 1 && universityObject.applicationStatus === "Pending") {
                                        setUniversityList1(universityObject);

                                    } else if (number === 2 && universityObject.applicationStatus === "Pending") {
                                        setUniversityList2(universityObject);

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
        else {
            let backGround;
            let font;
            if (props.appStatue === "Wait") {
                backGround = "#256D85";
                font = true;
            } else if (props.appStatue === "Accepted") {
                backGround = "#285430";
                font = true;
            } else if (props.appStatue === "Rejected") {
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
                                            <p style={{color: font ? "white" : ""}}>{props.applicationObject.appliedUniversityIds[0]} </p>
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
            <Application applicationObject ={universityList}/>
            <Application applicationObject ={universityList1}/>
            <Application applicationObject ={universityList2}/>

        </div>
    )
}