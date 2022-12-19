import React, {useState} from "react";
import Navbar from "./StudentNavbar";
import OperationNavbar from "./OperationNavbar";
import {useSearchParams} from "react-router-dom";

export default function ApplicationsPage() {
    {
        const [searchParam] = useSearchParams();
        const [selectedFile, setSelectedFile] = useState();
        const [isFilePicked, setIsFilePicked] = useState(false);
        const [application, setApplication] = useState([]);

        const changeHandler = (event) => {
            setSelectedFile(event.target.files[0]);
        }
        const handleSubmission = () => {
            const formData = new FormData();

            formData.append('File', selectedFile);

            fetch(
                'https://freeimage.host/api/1/upload?key=<YOUR_API_KEY>',
                {
                    method: 'POST',
                    body: formData,
                }
            )
                .then((response) => response.json())
                .then((result) => {
                    console.log('Success:', result);
                })
                .catch((error) => {
                    console.error('Error:', error);
                });
        }
        async function getApplication() {
            if(application.length === 0)
            {
                let id = (searchParam.get("id"))
                await fetch("http://localhost:8080/student/appId/" + id,)
                    .then(res => res.json())
                    .then(async (result) => {
                        console.log(result);
                        await fetch("http://localhost:8080/application/" + result,)
                            .then(res => res.json())
                            .then(async (app) => {
                                setApplication(app);
                            })
                    })
            }

        }
        getApplication();
        function Application() {
            let backGround;
            let font;
            if (application.applicationStatus === "Wait") {
                backGround = "#256D85";
                font = true;
            } else if (application.applicationStatus === "Accepted") {
                backGround = "#285430";
                font = true;
            } else if (application.applicationStatus === "Pending") {
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
                                            <p style={{color: font ? "white" : ""}}>{application.applicationID} </p>
                                        </td>
                                    </tr>
                                    <tr style={{outline: "thin solid"}}>
                                        <td>
                                            <p style={{color: font ? "yellow" : "red"}}>App Status: </p>
                                        </td>
                                        <td>
                                            <p style={{color: font ? "white" : ""}}>{application.applicationStatus} </p>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td>
                                <button className="taskButton">See Comments PDF</button>
                                <button className="taskButton">Upload A File</button>
                                <button className="taskButton">See Transcript</button>
                                <button className="taskButton">See Progress</button>

                            </td>
                        </tr>
                    </table>
                    <div>
                        <input type="file" name="file" onChange={changeHandler}/>
                        <div>
                            <button onClick={handleSubmission}>Submit</button>
                        </div>
                    </div>

                    <hr/>
                </div>
            );
        }

        return (
            <div>
                <Navbar/>
                <OperationNavbar/>
                <h1>ApplicationsPage</h1>
                <Application/>
            </div>
        )
    }
}