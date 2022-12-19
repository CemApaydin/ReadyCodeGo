import React, {useEffect, useState} from "react";
import Navbar from "../Instructor/InstructorNavbar";
import OperationNavbar from "../Instructor/OperationNavbar";
import {createSearchParams, useSearchParams} from "react-router-dom";

export default function InstructorMainPage(){
    const [searchParam] = useSearchParams();
    const [name, setName] = useState(null);
    const [surname, setSurname] = useState(null);
    const [email, setEmail] = useState(null);
    function GetName()
    {

        let id = (searchParam.get("id"));
        fetch("http://localhost:8080/instructor/" +id,)
            .then(res=>res.json())
            .then(
                (result) => {
                    setName(result.name.substring( 0, result.name.indexOf(" ")));
                    setSurname(result.name.substring(result.name.indexOf(" ") + 1));
                    setEmail(result.userMail);
                },
                (error) => {
                }
            );
        return (
            <div className="infoCard">
                <h1 style={{color: "#FA8072"}}>Information Card</h1>
                <table>

                    <tr>
                        <td><h2 style={{color: "#FA8072"}}>Name: </h2></td>
                        <td><h2 style={{color: "white"}}>{name}</h2></td>
                    </tr>
                    <tr>
                        <td><h2 style={{color: "#FA8072"}}>Surname: </h2></td>
                        <td><h2 style={{color: "white"}}>{surname}</h2></td>
                    </tr>
                    <tr>
                        <td><h2 style={{color: "#FA8072"}}>ID: </h2></td>
                        <td><h2 style={{color: "white"}}>{id}</h2></td>
                    </tr>
                    <tr>
                        <td><h2 style={{color: "#FA8072"}}>Email: </h2></td>
                        <td><h2 style={{color: "white"}}>{email}</h2></td>
                    </tr>
                </table>

            </div>
        );

    }
    return (

        <div>
            <Navbar/>
            <OperationNavbar/>
            <GetName />
        </div>
    )
}