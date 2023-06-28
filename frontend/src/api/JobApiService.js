import apiClient from "./ApiClient";

export function retrieveAllJobs(pageNumber) {
    console.log("All Jobs Api Called");

    return apiClient.get("/job", {
        params: { offset: pageNumber },
    });
}

export function retrieveSearchedJobs(searchTerm, pageNum) {
    console.log("Search Jobs Api Called");

    return apiClient.get("/job/search", {
        params: { query: searchTerm, offset: pageNum },
    });
}
