import axios from "axios";

//created apiClient for axios separately to pass headers to all the requests, without repeating the same in every API request
const apiClient = axios.create({
    baseURL: "http://localhost:8081",
});

// Production Best Practice: Intercept all requests and attach token from localStorage
apiClient.interceptors.request.use((config) => {
    const token = localStorage.getItem("jwtToken");
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
});

export default apiClient;
