import {createSearchParams, Link, useNavigate,Navigate, useMatch, useResolvedPath, useSearchParams} from "react-router-dom"
import React, {useState} from "react";

export default function OperationNavbar() {
    const [searchParam] = useSearchParams();
    const [mouseOver, setMouseOver] = useState(false);
    function handleMouse(){
        setMouseOver(true);
    }
    function handleMouseOut(){
        setMouseOver(false);
    }
    function getName()
    {
        let id = (searchParam.get("id"))
        console.log(id);
        fetch( "coordinator/" + id,)
            .then(res=>res.json())
            .then(
                (result) => {
                    return result.name;
                    console.log("result.name");
                },
                (error)=>{
                    console.log("error");
                })
        return null;
    }
    function CustomLink({ to, children, ...props }) {
        const navigate = useNavigate();
        const resolvedPath = useResolvedPath(to)
        const isActive = useMatch({ path: resolvedPath.pathname, end: true })

        function onClick(props)
        {

            navigate(
                {
                    pathname: resolvedPath.pathname,
                    search: createSearchParams(
                        {
                            id: searchParam.get("id"),
                        }).toString()
                });
        }

        return (
            <li className={isActive ? "active" : ""}>
                <button
                    className={isActive ? "activeButton" : "normalNavbarButton"}
                    onClick={onClick}>
                    {children}
                </button>
            </li>
        )
    }
    return (
        <nav className="opNav">
            <ul>

                <CustomLink to="/CoordinatorMainPage">Home</CustomLink>
                <CustomLink to="/CoordinatorCreateTaskPage">CreateTask</CustomLink>
                <CustomLink to="/CoordinatorUploadTaskPage">Upload Task</CustomLink>
                <CustomLink to="/CoordinatorTaskListPage">TaskList</CustomLink>
                <CustomLink to="/CoordinatorApplicationsPage">Applications</CustomLink>
                <CustomLink to="/CoordinatorWaitingBin">WaitingBin</CustomLink>
                <CustomLink to="/UniversitiesPage">Universities</CustomLink>
            </ul>
        </nav>

    )
}