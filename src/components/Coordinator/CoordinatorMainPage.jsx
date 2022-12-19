import React, {useState} from "react";
import Navbar from "./CoordinatorNavbar";
import OperationNavbar from "./OperationNavbar";
import {useSearchParams} from "react-router-dom";
export default function CoordinatorMainPage(){
    const [searchParam] = useSearchParams();
    const [name, setName] = useState(null);
    const [surname, setSurname] = useState(null);
    const [email, setEmail] = useState(null);
    const [selectedFile, setSelectedFile] = useState();
    function GetName()
    {

        let id = (searchParam.get("id"));
        fetch("http://localhost:8080/coordinator/" +id,)
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

        function handleClick() {
            let id = (searchParam.get("id"));
            const today = new Date();
            let uploadDate;
            uploadDate = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
            let uploaderId = id;
            const document ={ uploadDate, uploaderId}
            fetch("http://localhost:8080/document/createDocument",{
                method:"POST",
                headers: {"Content-Type": "application/json"},
                body:JSON.stringify(document)

            }).then(async (result) => {
                const documentID = await result.json()
                console.log(documentID)
                let userID = id;
                await fetch("http://localhost:8080/task/addAttachment/" + id, {
                    method: "POST",
                    headers: {"Content-Type": "application/json"},
                    body: JSON.stringify(documentID)

                })
                const formData = new FormData();

                formData.append('file', selectedFile);
                formData.append('userID', id);
                formData.append('documentID', documentID);

                await fetch("http://localhost:8080/filestorage/upload", {
                    method: "POST",
                    body: formData,

                })
            })
        }

        function ChangeHandler() {

        }

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
                        <td><input type={"file"} onChange={ChangeHandler}/></td>
                        <td><button onClick={handleClick}>UploadSign</button></td>
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