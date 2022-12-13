import LogInPage from "./components/LogInPage"
import SignUpPage from "./components/SignUpPage"
import AboutPage from "./components/AboutPage"
import InstructorSignUpPage from "./components/InstructorSignUpPage";
import StudentSignUpPage from "./components/StudentSignUpPage";
import StudentMainPage from "./components/Student/StudentMainPage";
import CoordinatorMainPage from "./components/Coordinator/CoordinatorMainPage";
import InstructorMainPage from "./components/Instructor/InstructorMainPage";
import InfoPage from "./components/Student/InfoPage";
import ApplicationsPage from "./components/Student/ApplicationsPage";
import TaskListPage from "./components/Student/TaskListPage";
import UploadTaskPage from "./components/Student/UploadTaskPage";
import ChangeApplicationPage from "./components/Student/ChangeApplicationPage";
import InstructorTaskListPage from "./components/Instructor/TaskListPage";
import InstructorUploadTaskPage from "./components/Instructor/UploadTaskPage";
import FacultyMemberMainPage from "./components/FacultyMember/FacultyMemberMainPage";
import CreateApplicationPage from "./components/Coordinator/CreateApplicationPage";
import FacultyMemberUploadTaskPage from "./components/FacultyMember/UploadTaskPage";
import FacultyMemberTaskListPage from "./components/FacultyMember/TaskListPage";
import CoordinatorTaskListPage from "./components/Coordinator/TaskListPage";
import CoordinatorApplicationsPage from "./components/Coordinator/ApplicationsPage";
import CoordinatorUploadTaskPage from "./components/Coordinator/UploadTaskPage";
import UniversitiesPage from "./components/Coordinator/UniversitiesPage";
import { Route, Routes } from "react-router-dom"

function App() {
    return (
        <>
            <div className="container">
                <Routes>
                    <Route path="/" element={<LogInPage />} />
                    <Route path="/SignUpPage" element={<SignUpPage />} />
                    <Route path="/AboutPage" element={<AboutPage />} />
                    <Route path="/InstructorSignUpPage" element={<InstructorSignUpPage />} />
                    <Route path="/StudentSignUpPage" element={<StudentSignUpPage />} />
                    <Route path="/StudentMainPage" element={<StudentMainPage />} />
                    <Route path="/CoordinatorMainPage" element={<CoordinatorMainPage />} />
                    <Route path="/InstructorMainPage" element={<InstructorMainPage />} />
                    <Route path="/StudentInfoPage" element={<InfoPage />} />
                    <Route path="/StudentTaskListPage" element={<TaskListPage />} />
                    <Route path="/StudentUploadTaskPage" element={<UploadTaskPage />} />
                    <Route path="/StudentChangeApplicationPage" element={<ChangeApplicationPage />} />
                    <Route path="/StudentApplicationsPage" element={<ApplicationsPage />} />
                    <Route path= "/InstructorTaskListPage" element={<InstructorTaskListPage />} />
                    <Route path= "/InstructorUploadTaskPage" element={<InstructorUploadTaskPage />} />
                    <Route path= "/FacultyMemberMainPage" element={<FacultyMemberMainPage />} />
                    <Route path= "/CreateApplicationPage" element={<CreateApplicationPage />} />
                    <Route path= "/CoordinatorTaskListPage" element={<CoordinatorTaskListPage />} />
                    <Route path= "/FacultyMemberUploadTaskPage" element={<FacultyMemberUploadTaskPage />} />
                    <Route path= "/FacultyMemberTaskListPage" element={<FacultyMemberTaskListPage />} />
                    <Route path= "/CoordinatorApplicationsPage" element={<CoordinatorApplicationsPage />} />
                    <Route path= "/CoordinatorUploadTaskPage" element={<CoordinatorUploadTaskPage />} />
                    <Route path= "/UniversitiesPage" element={<UniversitiesPage />} />
                </Routes>
            </div>
        </>
    )
}

export default App