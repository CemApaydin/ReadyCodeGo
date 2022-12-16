import {Link, useMatch, useResolvedPath, useSearchParams} from "react-router-dom"

export default function Navbar() {

    return (
        <nav className="nav">
            <Link to="/InstructorMainPage" className="site-title">
                <img className="bilkent_logo" src ={ require('../images/logo.png')}/>
                <h1 className= "header2" >Bilkent Erasmus System</h1>
            </Link>
            <ul>
                <CustomLink to="/">LogOut</CustomLink>
                <CustomLink to="/InfoPage">Info</CustomLink>
                <CustomLink to="/InstructorMainPage">Home</CustomLink>
            </ul>
        </nav>

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