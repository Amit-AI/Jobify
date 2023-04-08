import axios from "axios";

//created apiClient for axios separately to pass headers to all the requests, without repeating the same in every API request
const apiClient = axios.create({
    baseURL: "http://localhost:8081",
});

export default apiClient;
