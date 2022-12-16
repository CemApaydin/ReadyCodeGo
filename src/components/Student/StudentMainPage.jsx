
import React, {useEffect, useState} from "react";
import Navbar from "./StudentNavbar";
import OperationNavbar from "./OperationNavbar";
import {useSearchParams} from "react-router-dom";
export default function StudentMainPage(){
    const [searchParam] = useSearchParams();
    const [name, setName] = useState(null);
    const [surname, setSurname] = useState(null);
    const [email, setEmail] = useState(null);
    function GetName()
    {

        let id = (searchParam.get("id"))
        useEffect(()=>{
            fetch(  "http://localhost:8080/student/"+id,{
                method: "GET",
                headers:{
                    "Accept": "application/json",
                    "Content-Type":"application/json"
                }},)
                .then(response => { return response.json();})
                .then(responseData => { return responseData;})
                .then(data => {

                    setName(data.name.substring( 0, data.name.indexOf(" ")));
                    setSurname(data.name.substring(data.name.indexOf(" ") + 1));
                    setEmail(data.userMail);

                })
                .catch(function(err) {
                    console.log(err);
                })
        },[])
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