import { createContext, useContext, useState } from "react";
import callBasicAuthService from "../api/AuthApiService";
import apiClient from "../api/ApiClient";

//creates context for globally requires states
const AuthContext = createContext();

//creates provider, which provides various global states to all it's inclosed children components
export default function AuthProvider({ children }) {
    const [username, setUsername] = useState("Amit Dubey");
    const [email, setEmail] = useState(null);
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [token, setToken] = useState(null);

    //created login in context.jsx, to not share setState func in AuthProvider to another componenents.
    async function login(email, password) {
        const basicAuthToken = "Basic " + window.btoa(email + ":" + password); //this creates a Base64 encoded token, that's required for basicAuth authorization token

        try {
            const response = await callBasicAuthService(basicAuthToken);

            if (response.status == 200) {
                setIsAuthenticated(true);
                setEmail(email);
                setToken(basicAuthToken);

                //this will intercept all api request, and add headers to it
                //used it to add auth header before doing request to the backend
                apiClient.interceptors.request.use((config) => {
                    config.headers.Authorization = basicAuthToken;
                    return config;
                });

                return true;
            } else {
                logout();
            }
        } catch {
            logout();
        }
    }

    function logout() {
        setIsAuthenticated(false);
        setEmail(null);
        setToken(null);
        return false;
    }

    return (
        <AuthContext.Provider
            value={{ username, email, isAuthenticated, login, logout, token }}
        >
            {children}
        </AuthContext.Provider>
    );
}

//creates hook to get context values from any component enclosed under provider.
export const useAuth = () => useContext(AuthContext);
