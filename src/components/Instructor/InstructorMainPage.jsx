import React from "react";
import Navbar from "../Instructor/InstructorNavbar";
import OperationNavbar from "../Instructor/OperationNavbar";

export default function InstructorMainPage(){
    return (
        <div>
            <Navbar/>
            <OperationNavbar/>
            <div className="infoCard">
                <h1 style={{color: "#FA8072"}}>Information Card</h1>
                <table>

                    <tr>
                        <td><h2 style={{color: "#FA8072"}}>Name: </h2></td>
                        <td><h2 style={{color: "white"}}>Eray</h2></td>
                    </tr>
                    <tr>
                        <td><h2 style={{color: "#FA8072"}}>Surname: </h2></td>
                        <td><h2 style={{color: "white"}}>Tüzün</h2></td>
                    </tr>
                    <tr>
                        <td><h2 style={{color: "#FA8072"}}>ID: </h2></td>
                        <td><h2 style={{color: "white"}}>10001010</h2></td>
                    </tr>
                    <tr>
                        <td><h2 style={{color: "#FA8072"}}>Email: </h2></td>
                        <td><h2 style={{color: "white"}}>eraytuzun@cs.bilkent.edu.tr</h2></td>
                    </tr>
                </table>

            </div>
        </div>
    )
}