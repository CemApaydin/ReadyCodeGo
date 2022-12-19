import Navbar from "./CoordinatorNavbar";
import OperationNavbar from "./OperationNavbar";
import React, {useState} from "react";
import {useSearchParams} from "react-router-dom";
import {wait} from "@testing-library/user-event/dist/utils";
export default function UniversitiesPage(){
    const [key, setKey] = useState(null);
    const [searchParam] = useSearchParams();
    const [id] = useState(searchParam.get("id"));
    const [university, setUniversity] = useState([]);
    const [university1, setUniversity1] = useState([]);
    const [university2, setUniversity2] = useState([]);
    const [universityID, setUniversityID] = useState("");
    const [universityList1, setUniversityList1] = useState([]);
    const [universityList2, setUniversityList2] = useState([]);
    const [universityList, setUniversityList] = useState([]);
    async function takeUniversities() {
        if( universityList.length === 0){
            await fetch("http://localhost:8080/coordinator/getUniversity/" + id)
                .then(res => res.json())
                .then(async (result) => {
                    let number = 0;
                    console.log(result);
                    for (let i = 0; i < result.length; i++) {
                        console.log(result[i]);
                        await fetch("http://localhost:8080/university/get/" + result[i])
                            .then(res => res.json())
                            .then(
                                (universityObject) => {

                                    if (number === 0) {
                                        setUniversityList(universityObject);

                                    } else if (number === 1) {
                                        setUniversityList1(universityObject);

                                    } else if (number === 2) {
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

    function University(props)
    {
        if(props.universityObject.length === 0)
        {
            return null;
        }
        else
        {
            let backGround;
            let font;
            if (props.universityObject.isAvailable) {
                backGround = "#256D85";
                font = true;
            } else {
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
                                            <p style={{color: font ? "yellow" : "red"}}>University ID: </p>
                                        </td>
                                        <td>
                                            <p style={{color: font ? "white" : ""}}>{props.universityObject.universityID} </p>
                                        </td>
                                    </tr>
                                    <tr style={{outline: "thin solid"}}>
                                        <td>
                                            <p style={{color: font ? "yellow" : "red"}}>University Name: </p>
                                        </td>
                                        <td>
                                            <p style={{color: font ? "white" : ""}}>{props.universityObject.universityName} </p>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                            <td>
                                <button className="taskButton">Change Limit</button>
                                <button className="taskButton">See Information</button>
                            </td>
                            <td>
                                <table className="taskCardTableRight">
                                    <tr style={{outline: "thin solid"}}>
                                        <td>
                                            <p style={{color: font ? "yellow" : "red"}}>Student Limit: </p>
                                        </td>
                                        <td>
                                            <p style={{color: font ? "white" : ""}}>{props.universityObject.studentLimit} </p>
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

    function universityRender() {
        if( university === null)
            return <option value= "empty">--Empty--</option>
        else
            return <option value={ university.universityID}>{ university.universityName}</option>
    }
    function universityRender1() {
        if( university1 === null)
            return <option value= "empty">--Empty--</option>
        else
            return <option value={ university1.universityID}>{ university1.universityName}</option>
    }
    function universityRender2() {
        if( university2 === null)
            return <option value= "empty">--Empty--</option>
        else
            return <option value={ university2.universityID}>{ university2.universityName}</option>
    }


    function AddUniversity() {
        if(universityID === "" )
        {
            console.log("error");
        }
        else
        {
            let coordinatorID = (searchParam.get("id"));
            fetch("http://localhost:8080/coordinator/addUniversity/" +coordinatorID,{
                method:"POST",
            headers: {"Content-Type": "application/json"},
            body:JSON.stringify(universityID)
             })
            console.log("asda");
        }
    }

    function handleChangeUniversity(event) {

        setUniversityID(event.target.value)
    }

    async function getAll() {
            await fetch("http://localhost:8080/university/findAll")
                .then(res => res.json())
                .then(
                    (result) => {
                        let number = 0;
                        console.log(result.length);
                        for (let i = 0; i < result.length; i++) {
                            console.log(result[i]);
                            if (result[i].universityName.includes(key)) {
                                if (number === 0) {
                                    setUniversity(result[i]);
                                    number++;
                                } else if (number === 1) {
                                    setUniversity1(result[i]);
                                    number++;
                                } else if (number === 2) {
                                    setUniversity2(result[i]);
                                    number++;
                                }

                                if (number === 3) {
                                    break;
                                }
                            }
                        }
                    },
                );
    }

    function handleChangeKey(event) {
        setKey(event.target.value);
        setUniversity(null);
        setUniversity1(null);
        setUniversity2(null);
        getAll();
    }
    takeUniversities();
    return (
        <div>
            <Navbar/>
            <OperationNavbar/>
            <label >Search key:</label>
            <input
                className="LogInText"
                onChange={handleChangeKey}
                required
                maxLength="8" size="8"
                type="text" placeholder="..."/>
            <select name="logInType" id="logInType" onChange={handleChangeUniversity}>
                <option value="empty">---</option>
                {universityRender()}
                {universityRender1()}
                {universityRender2()}
            </select>
            <button onClick={AddUniversity}>AddUniversity</button>
            <University universityObject ={universityList}/>
            <University universityObject ={universityList1}/>
            <University universityObject ={universityList2}/>
        </div>
    )
}