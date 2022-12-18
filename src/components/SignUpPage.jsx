import {createSearchParams, Link, useMatch, useNavigate, useResolvedPath} from "react-router-dom"
import Navbar from "./navbar1"
import React, {useState} from "react";
import {HTTP_REQUESTS} from "../backfor/services/HttpRequestService";

export default function SignUpPage() {
    const [mouseOver, setMouseOver] = useState(false);
    const [mouseOver1, setMouseOver1] = useState(false);
    const [mouseOver2, setMouseOver2] = useState(false);
    const [mouseOver3, setMouseOver3] = useState(false);
    const navigate = useNavigate();
    function handleMouse(){
        setMouseOver(true);
    }
    function handleMouseOut(){
        setMouseOver(false);
    }
    function handleMouse1(){
        setMouseOver1(true);
    }
    function handleMouseOut1(){
        setMouseOver1(false);
    }
    function handleMouse2(){
        setMouseOver2(true);
    }
    function handleMouseOut2(){
        setMouseOver2(false);
    }
    function handleMouse3(){
        setMouseOver3(true);
    }
    function handleMouseOut3(){
        setMouseOver3(false);
    }
    function handleClickAsInstructor() {
        navigate(
            {
                pathname: '/InstructorSignUpPage',
                search: createSearchParams(
                    {
                        signUpType: 'instructor',
                    }).toString()
            });

    }
    function handleClickAsCoordinator() {
        navigate(
            {
                pathname: '/InstructorSignUpPage',
                search: createSearchParams(
                    {
                        signUpType: 'coordinator',
                    }).toString()
            });

    }
    function handleClickAsFacultyBoardMember() {
        navigate(
            {
                pathname: '/InstructorSignUpPage',
                search: createSearchParams(
                    {
                        signUpType: 'facultyboardmember',
                    }).toString()
            });

    }
    function handleClickAsStudent()
    {
        navigate(
            {
                pathname: '/StudentSignUpPage',
            });

    }

    return (
        <>
            <Navbar />

            <table className="SignUpPageTable">
                <tr>
                    <td>
                        <p> <strong><h1>Sign Up as a </h1></strong></p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button
                            className="SignUpPageTableButton"
                            style={{backgroundColor: mouseOver ?  "lightgray" : "white"}}
                            onClick={handleClickAsFacultyBoardMember}
                            onMouseOver={handleMouse}
                            onMouseOut={handleMouseOut}>
                            <strong>Faculty Board Member </strong></button>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button
                            className="SignUpPageTableButton"
                            style={{backgroundColor: mouseOver1 ?  "lightgray" : "white"}}
                            onClick={handleClickAsStudent}
                            onMouseOver={handleMouse1}
                            onMouseOut={handleMouseOut1}>
                            <strong>Student </strong></button>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button
                            className="SignUpPageTableButton"
                            style={{backgroundColor: mouseOver2 ?  "lightgray" : "white"}}
                            onClick={handleClickAsCoordinator}
                            onMouseOver={handleMouse2}
                            onMouseOut={handleMouseOut2}>
                            <strong>Coordinator </strong></button>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button
                            className="SignUpPageTableButton"
                            style={{backgroundColor: mouseOver3 ?  "lightgray" : "white"}}
                            onClick={handleClickAsInstructor}
                            onMouseOver={handleMouse3}
                            onMouseOut={handleMouseOut3}>
                            <strong>Instructor </strong></button>
                    </td>
                </tr>
            </table>
        </>

)

}
function CustomLink({ to, children, ...props }) {
    const resolvedPath = useResolvedPath(to)
    const isActive = useMatch({ path: resolvedPath.pathname, end: true })

    return (
        <li className={isActive ? "active" : ""}>
            <Link to={to} {...props}>
                {children}
            </Link>
        </li>
    )
}