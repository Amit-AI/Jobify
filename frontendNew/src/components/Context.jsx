import { createContext, useContext, useState } from "react";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export default function AuthProvider({ children }) {
    const [username, setUsername] = useState("Amit Dubey");
    const [email, setEmail] = useState("amit123@gmail.com");

    return (
        <AuthContext.Provider value={{ username, email }}>
            {children}
        </AuthContext.Provider>
    );
}
