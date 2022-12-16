import React, {useState} from "react";
import Navbar from "./StudentNavbar";
import OperationNavbar from "./OperationNavbar";

export default function ApplicationsPage() {
    {
        const [selectedFile, setSelectedFile] = useState();
        const [isFilePicked, setIsFilePicked] = useState(false);

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

        function Application(props) {
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
                                            <p style={{color: font ? "yellow" : "red"}}>Coordinator: </p>
                                        </td>
                                        <td>
                                            <p style={{color: font ? "white" : ""}}>{props.coordinator} </p>
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
                <Application appID="1" appOwner="Sedef Keskin" coordinator="Eray Tüzün" appStatue="Accepted"
                             university="Sydney University" taskEndDate="29/12/2022"/>
            </div>
        )
    }
}