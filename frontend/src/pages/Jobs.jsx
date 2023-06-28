import JobCard from "../components/JobCard";
import { Fragment, useEffect, useState } from "react";
import Pagination from "../components/Pagination";
import { retrieveAllJobs, retrieveSearchedJobs } from "../api/JobApiService";

export default function Jobs() {
    const [jobPostData, setJobPostData] = useState({});
    const [pageNumber, setPageNumber] = useState(0);

    let [query, setQuery] = useState("");

    // function fetchJobs(pageNum, searchTerm) {
    //     retrieveSearchedJobs(searchTerm, pageNum)
    //         .then((response) => {
    //             setJobPostData(response.data);
    //         })
    //         .catch((e) => {
    //             console.log(e);
    //         });
    // }

    // function fetchAllJobs() {
    //     axios
    //         .get("http://localhost:8081/job", {
    //             params: { offset: pageNumber },
    //         })
    //         .then((response) => setJobPostData(response.data))
    //         .catch((e) => {
    //             console.log(e);
    //         });
    // }

    //for pagination purpose
    let pageData = jobPostData.content?.length
        ? {
              currentPage: jobPostData.number,
              isFirstPage: jobPostData.first,
              isLastPage: jobPostData.last,
              totalPages: jobPostData.totalPages,
          }
        : null;

    function fetchSearchJobs(e) {
        e.preventDefault();

        const searchTerm = query != "" ? query : "";

        retrieveSearchedJobs(searchTerm, pageNumber)
            .then((response) => {
                setJobPostData(response.data);
            })
            .catch((e) => {
                console.log(e);
            });
        // fetchJobs(pageNumber, searchTerm);

        // query.current = '';
    }

    // function fetchSearchJobs1() {
    //     let searchTerm = query.current.value;
    //     if (searchTerm) {
    //         // const url = "http://localhost:8081/job/search?query=" + searchTerm;
    //         setPageNumber(0);
    //     }
    //     axios
    //         .get("http://localhost:8081/job/search", {
    //             params: { query: searchTerm, offset: pageNumber },
    //         })
    //         .then((response) => {
    //             console.log(response.data);
    //             setJobPostData(response.data);
    //         })
    //         .catch((e) => {
    //             console.log(e);
    //         });
    // }

    useEffect(() => {
        // fetchJobs(0, "");
        retrieveAllJobs(pageNumber)
            .then((response) => setJobPostData(response.data))
            .catch((e) => {
                console.log(e);
            });
    }, []);

    //temp card data for testing, remove it
    // const cardData = {
    //     jobRole: "Software Engineer 1",
    //     companyName: "Optum",
    //     jobExperienceRequired: "1-2",
    //     jobLocation: "Gurugram, India",
    //     jobPosted: "01-01-2023",
    //     jobPostExpires: "01-02-2023",
    // };

    return (
        <Fragment>
            <form
                className="search-bar w-[80%] lg:w-full flex items-center justify-center mt-28 max-w-3xl mx-auto"
                onSubmit={fetchSearchJobs}
            >
                <div className="flex border-2 rounded w-full">
                    <input
                        type="text"
                        className="block px-4 py-2 w-full focus:outline-none"
                        placeholder="Search..."
                        onChange={(e) => setQuery(e.target.value)}
                    />
                    <button className="flex items-center justify-center px-4 border-l">
                        <svg
                            className="w-6 h-6 text-gray-600"
                            fill="currentColor"
                            xmlns="http://www.w3.org/2000/svg"
                            viewBox="0 0 24 24"
                        >
                            <path d="M16.32 14.9l5.39 5.4a1 1 0 0 1-1.42 1.4l-5.38-5.38a8 8 0 1 1 1.41-1.41zM10 16a6 6 0 1 0 0-12 6 6 0 0 0 0 12z" />
                        </svg>
                    </button>
                </div>
            </form>
            <div className=" w-[90%] sm:container my-10 mx-auto px-4 md:px-12 flex flex-col sm:items-center">
                {jobPostData.content?.map((item, index) => (
                    <JobCard key={index} jobPost={item} />
                ))}

                {/* this is temp data for testing, must be removed
                <JobCard jobPost={cardData} />
                <JobCard jobPost={cardData} />
                <JobCard jobPost={cardData} />
                <JobCard jobPost={cardData} />
                <JobCard jobPost={cardData} />
                <JobCard jobPost={cardData} /> */}

                {/* if no data from server, below dummy data will be shown */}
                {!jobPostData.content?.length ? (
                    <p className="text-gray-400">No jobs found</p>
                ) : (
                    ""
                )}
            </div>

            {jobPostData.content?.length ? (
                <Pagination pageData={pageData} setPage={setPageNumber} />
            ) : (
                ""
            )}
        </Fragment>
    );
}
