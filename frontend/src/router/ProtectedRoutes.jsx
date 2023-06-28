import React from "react";
import {Outlet, Navigate} from 'react-router-dom';

import { useAuth } from "../components/Context";

export default function ProtectedRoutes() {

    const {isAuthenticated} = useAuth();

    return (
        isAuthenticated ? <Outlet /> : <Navigate to='/login' />
    )
}
