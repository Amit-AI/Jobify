import JobCard from "../components/JobCard";
import axios from "axios";
import { Fragment, useEffect, useState } from "react";
import { useRef } from "react";

export default function Jobs() {
    const [jobPostData, setJobPostData] = useState([]);

    let query = useRef("");

    function fetchAllJobs() {
        axios
            .get("http://localhost:8081/job")
            .then((response) => setJobPostData(response.data))
            .catch((e) => {
                console.log(e);
            });
    }

    function fetchSearchJobs(e) {
        e.preventDefault();

        let searchTerm = query.current.value;
        if (searchTerm) {
            const url = "http://localhost:8081/job/search?query=" + searchTerm;
            axios
                .get(url)
                .then((response) => setJobPostData(response.data))
                .catch((e) => {
                    console.log(e);
                });
        }
    }

    useEffect(() => {
        fetchAllJobs();
    }, []);

    const cardData = {
        jobRole: "Software Engineer 1",
        companyName: "Optum",
        jobExperienceRequired: "1-2",
        jobLocation: "Gurugram, India",
        jobPosted: "01-01-2023",
        jobPostExpires: "01-02-2023",
    };

    return (
        <Fragment className="h-full">
            <form
                class="search-bar w-[80%] lg:w-full flex items-center justify-center mt-28 max-w-3xl mx-auto"
                onSubmit={fetchSearchJobs}
            >
                <div class="flex border-2 rounded w-full">
                    <input
                        type="text"
                        class="block px-4 py-2 w-full focus:outline-none"
                        placeholder="Search..."
                        ref={query}
                    />
                    <button class="flex items-center justify-center px-4 border-l">
                        <svg
                            class="w-6 h-6 text-gray-600"
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
                {jobPostData?.map((item, index) => (
                    <JobCard key={index} jobPost={item} />
                ))}

                {/* <JobCard jobPost={cardData} />
                <JobCard jobPost={cardData} />
                <JobCard jobPost={cardData} />
                <JobCard jobPost={cardData} />
                <JobCard jobPost={cardData} />
                <JobCard jobPost={cardData} /> */}

                {/* if no data from server, below dummy data will be shown */}
                {!jobPostData.length ? (
                    <p className="text-gray-400">No jobs found</p>
                ) : (
                    ""
                )}
            </div>
        </Fragment>
    );
}
