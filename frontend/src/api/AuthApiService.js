import apiClient from "./ApiClient";

export default async function callBasicAuthService(token) {
    return await apiClient.get("/basicAuth", {
        headers: {
            Authorization: token,
        },
    });
}

export function executeJwtAuthenticationService(email, password) {
    return apiClient.post("auth/v1/login", {
        email,
        password,
    });
}
