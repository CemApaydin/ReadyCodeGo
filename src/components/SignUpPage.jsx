import { Link, useMatch, useResolvedPath } from "react-router-dom"
import Navbar from "./navbar1"
import React from "react";


export default function SignUpPage() {
    return (
        <>
            <Navbar />
            <p>Choose your Sign Up Type</p>
            <ul>
                <li> <CustomLink to="/InstructorSignUpPage">AsInstructor</CustomLink> </li>
                <li> <CustomLink to="/InstructorSignUpPage">AsCoordinator</CustomLink> </li>
                <li> <CustomLink to="/StudentSignUpPage">AsStudent</CustomLink> </li>
                <li> <CustomLink to="/InstructorSignUpPage">AsFacultyBoardMember</CustomLink> </li>
            </ul>
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