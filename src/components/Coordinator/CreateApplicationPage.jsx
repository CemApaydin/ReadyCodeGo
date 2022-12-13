

import Navbar from "./CoordinatorNavbar";
import OperationNavbar from "./OperationNavbar";
import React from "react";

export default function CreateApplicationPage(){

    return (

        <div>
            <Navbar/>
            <OperationNavbar/>
            <h1 >CreateApplication</h1>
            <table className="signupTable">
                <tr>
                    <td><label >ID:</label></td>
                    <td>
                        <input
                            className="LogInText"
                            type="text" placeholder="Student ID"/>
                    </td>
                </tr>
                <tr>
                    <td><label >Name:</label></td>
                    <td>
                        <input
                            className="LogInText"
                            type="text" placeholder="Student Name"/>
                    </td>
                </tr>
                <tr>
                    <td><label >Surname:</label></td>
                    <td>
                        <input
                            className="LogInText"
                            type="text" placeholder="Student Surname"/>
                    </td>
                </tr>
                <tr>
                    <td><label>Student E-Mail</label></td>
                    <td>
                        <input
                            className="LogInText"
                            type="text" placeholder="******@bilkent.ug.edu.tr"/>
                    </td>
                </tr>
                <tr>
                    <td><label >University 1:</label></td>
                    <td>
                        <select name="logInType" id="logInType" >
                            <option value="empty">--Empty--</option>
                            <option value="student">Student</option>
                            <option value="facultyBoard">FacultyAdministrationBoard</option>
                            <option value="instructor">Instructor</option>
                            <option value="coordinator">Coordinator</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label >University 2:</label></td>
                    <td>
                        <select name="logInType" id="logInType" >
                            <option value="empty">--Empty--</option>
                            <option value="student">Student</option>
                            <option value="facultyBoard">FacultyAdministrationBoard</option>
                            <option value="instructor">Instructor</option>
                            <option value="coordinator">Coordinator</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label >University 3:</label></td>
                    <td>
                        <select name="logInType" id="logInType" >
                            <option value="empty">--Empty--</option>
                            <option value="student">Student</option>
                            <option value="facultyBoard">FacultyAdministrationBoard</option>
                            <option value="instructor">Instructor</option>
                            <option value="coordinator">Coordinator</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label >University 4:</label></td>
                    <td>
                        <select name="logInType" id="logInType" >
                            <option value="empty">--Empty--</option>
                            <option value="student">Student</option>
                            <option value="facultyBoard">FacultyAdministrationBoard</option>
                            <option value="instructor">Instructor</option>
                            <option value="coordinator">Coordinator</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label >University 5:</label></td>
                    <td>
                        <select name="logInType" id="logInType" >
                            <option value="empty">--Empty--</option>
                            <option value="student">Student</option>
                            <option value="facultyBoard">FacultyAdministrationBoard</option>
                            <option value="instructor">Instructor</option>
                            <option value="coordinator">Coordinator</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label >Application Status:</label></td>
                    <td>
                        <select name="logInType" id="logInType" >
                            <option value="empty">--Empty--</option>
                            <option value="student">Student</option>
                            <option value="facultyBoard">FacultyAdministrationBoard</option>
                            <option value="instructor">Instructor</option>
                            <option value="coordinator">Coordinator</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label>Application Point</label></td>
                    <td>
                        <input
                            className="LogInText"
                            type="text" placeholder="100.00"/>
                    </td>
                </tr>

            </table>
            <button
                className="LogInButton">
                Submit</button>
        </div>
    )
}