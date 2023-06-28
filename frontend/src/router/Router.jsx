import { Routes, Route } from "react-router-dom";
import Contact from "../pages/Contact";
import Dashboard from "../pages/Dashboard";
import Jobs from "../pages/Jobs";
import Login from "../components/Login";
import Signup from "../components/Signup";
import ProtectedRoutes from "./ProtectedRoutes";

export default function Router() {
    return (
        <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<Signup />} />

            {/* Below routes can't be accessed without authentication */}
            <Route element={<ProtectedRoutes />}>
                <Route path="/dashboard" element={<Dashboard />} />
                <Route path="/jobs" element={<Jobs />} />
                <Route path="/contact" element={<Contact />} />
            </Route>

        </Routes>
    );
}
