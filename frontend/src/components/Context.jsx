import { createContext, useContext, useState } from "react";
import callBasicAuthService, {
    executeJwtAuthenticationService,
} from "../api/AuthApiService";

//creates context for globally requires states
const AuthContext = createContext();

//creates provider, which provides various global states to all it's inclosed children components
export default function AuthProvider({ children }) {
    // Check localStorage first so the user stays logged in across reloads
    const [username, setUsername] = useState("Amit Dubey"); // Default kept for UI purposes
    const [email, setEmail] = useState(
        localStorage.getItem("email") || null
    );
    const [isAuthenticated, setIsAuthenticated] = useState(
        !!localStorage.getItem("jwtToken")
    );
    const [token, setToken] = useState(
        localStorage.getItem("jwtToken") || null
    );

    //created login in context.jsx, to not share setState func in AuthProvider to another componenents.
    async function login(email, password) {
        try {
            const response = await executeJwtAuthenticationService(
                email,
                password
            );

            if (response.status == 200) {
                // Assuming backend returns { "token": "..." }
                const jwtToken = response.data.token;

                setIsAuthenticated(true);
                setEmail(email);
                setToken(jwtToken);

                // Persist the session
                localStorage.setItem("jwtToken", jwtToken);
                localStorage.setItem("email", email);

                return true;
            } else {
                logout();
                return false;
            }
        } catch (e) {
            console.log("Login failed: ", e);
            logout();
            return false;
        }
    }

    function logout() {
        setIsAuthenticated(false);
        setEmail(null);
        setToken(null);

        // Wipe the persisted session data
        localStorage.removeItem("jwtToken");
        localStorage.removeItem("email");

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
