import {createSearchParams, Link, useMatch, useResolvedPath, useSearchParams} from "react-router-dom"

export default function Navbar() {
    const [searchParam] = useSearchParams();
    let id = (searchParam.get("id"))

    function onClick() {
        createSearchParams(
            {
                id: id,
            }).toString()
    }

    function CustomLink({ to, children, ...props }) {
        const resolvedPath = useResolvedPath(to)
        const isActive = useMatch({ path: resolvedPath.pathname, end: true })

        return (
            <li className={isActive ? "active" : ""}>
                <Link to={to} {...props} >
                    {children}
                </Link>
            </li>
        )
    }
    return (
        <nav className="nav">
            <Link onClick={onClick} to="/StudentMainPage" className="site-title">
                <img className="bilkent_logo" src ={ require('../images/logo.png')}/>
                <h1 className= "header2" >Bilkent Erasmus System</h1>
            </Link>
            <ul>
                <CustomLink to="/">LogOut</CustomLink>
                <CustomLink onClick={onClick} to="/StudentInfoPage">Info</CustomLink>
                <CustomLink onClick={onClick} to="/StudentMainPage">Home</CustomLink>
            </ul>
        </nav>

    )
}

