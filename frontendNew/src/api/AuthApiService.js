import apiClient from "./ApiClient";

export default async function callBasicAuthService(token) {
    return await apiClient.get("/basicAuth", {
        headers: {
            Authorization: token,
        },
    });
}
