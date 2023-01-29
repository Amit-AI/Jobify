import { Fragment } from "react";

export default function JobCard({ jobPost }) {
    return (
        <Fragment>
            <div class="card w-full sm:max-w-3xl rounded-2xl border px-3 py-5 shadow-sm hover:shadow-md mb-4 cursor-pointer">
                {/* <!-- div-1 --> */}
                <div class="flex flex-col items-center sm:flex-row sm:items-center">
                    <img
                        class="w-20 rounded-full sm:mr-4 sm:h-16 sm:w-16"
                        src="https://img.naukimg.com/logo_images/groups/v1/4847169.gif"
                        alt="image description"
                    />
                    <div>
                        <h2 class="text-sm font-bold sm:text-lg">
                            {/* Software Development Engineer */}
                            {jobPost.jobRole}
                        </h2>
                        <div class="flex justify-center sm:justify-start">
                            <h3 class="self-start">
                                {/* Optum */}
                                {jobPost.companyName}
                            </h3>
                        </div>
                    </div>
                </div>
                {/* <!-- div-2 --> */}
                <div class="mt-3 sm:flex sm:items-center sm:justify-between">
                    <div class="flex items-center">
                        <svg
                            xmlns="http://www.w3.org/2000/svg"
                            fill="none"
                            viewBox="0 0 24 24"
                            stroke-width="1.5"
                            stroke="currentColor"
                            class="h-4"
                        >
                            <path
                                stroke-linecap="round"
                                stroke-linejoin="round"
                                d="M20.25 14.15v4.25c0 1.094-.787 2.036-1.872 2.18-2.087.277-4.216.42-6.378.42s-4.291-.143-6.378-.42c-1.085-.144-1.872-1.086-1.872-2.18v-4.25m16.5 0a2.18 2.18 0 00.75-1.661V8.706c0-1.081-.768-2.015-1.837-2.175a48.114 48.114 0 00-3.413-.387m4.5 8.006c-.194.165-.42.295-.673.38A23.978 23.978 0 0112 15.75c-2.648 0-5.195-.429-7.577-1.22a2.016 2.016 0 01-.673-.38m0 0A2.18 2.18 0 013 12.489V8.706c0-1.081.768-2.015 1.837-2.175a48.111 48.111 0 013.413-.387m7.5 0V5.25A2.25 2.25 0 0013.5 3h-3a2.25 2.25 0 00-2.25 2.25v.894m7.5 0a48.667 48.667 0 00-7.5 0M12 12.75h.008v.008H12v-.008z"
                            />
                        </svg>
                        <span class="ml-1 text-xs sm:text-sm">
                            {/* 5-10years */}
                            {jobPost.jobExperienceRequired} years
                        </span>
                    </div>
                    <div class="mt-1 flex items-center sm:mt-0">
                        <svg
                            xmlns="http://www.w3.org/2000/svg"
                            fill="none"
                            viewBox="0 0 24 24"
                            stroke-width="1.5"
                            stroke="currentColor"
                            class="h-4"
                        >
                            <path
                                stroke-linecap="round"
                                stroke-linejoin="round"
                                d="M15 8.25H9m6 3H9m3 6l-3-3h1.5a3 3 0 100-6M21 12a9 9 0 11-18 0 9 9 0 0118 0z"
                            />
                        </svg>

                        <span class="ml-1 text-xs sm:text-sm">
                            Not disclosed
                        </span>
                    </div>
                    <div class="mt-1 flex items-center sm:mt-0">
                        <svg
                            xmlns="http://www.w3.org/2000/svg"
                            fill="none"
                            viewBox="0 0 24 24"
                            stroke-width="1.5"
                            stroke="currentColor"
                            class="h-4"
                        >
                            <path
                                stroke-linecap="round"
                                stroke-linejoin="round"
                                d="M15 10.5a3 3 0 11-6 0 3 3 0 016 0z"
                            />
                            <path
                                stroke-linecap="round"
                                stroke-linejoin="round"
                                d="M19.5 10.5c0 7.142-7.5 11.25-7.5 11.25S4.5 17.642 4.5 10.5a7.5 7.5 0 1115 0z"
                            />
                        </svg>

                        <span class="ml-1 text-xs sm:text-sm">
                            {/* Gurgaon, Haryana, India */}
                            {jobPost.jobLocation}
                        </span>
                    </div>
                </div>
                {/* <!-- div-3 --> */}
                <div class="mt-3 flex items-center">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        fill="none"
                        viewBox="0 0 24 24"
                        stroke-width="1.5"
                        stroke="currentColor"
                        class="mr-1 h-4"
                    >
                        <path
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            d="M16.862 4.487l1.687-1.688a1.875 1.875 0 112.652 2.652L10.582 16.07a4.5 4.5 0 01-1.897 1.13L6 18l.8-2.685a4.5 4.5 0 011.13-1.897l8.932-8.931zm0 0L19.5 7.125M18 14v4.75A2.25 2.25 0 0115.75 21H5.25A2.25 2.25 0 013 18.75V8.25A2.25 2.25 0 015.25 6H10"
                        />
                    </svg>
                    <p class="text-xs sm:text-sm">
                        Java, Scala, .Net, AngularJS, NoSQL, ReactJS, APIs, AWS
                        EC2
                    </p>
                </div>
                {/* <!-- div-4 --> */}
                <div class="dates mt-3 flex justify-between text-xs sm:text-sm">
                    <p>Posted: {jobPost.jobPosted}</p>
                    <p>Expires: {jobPost.jobPostExpires}</p>
                </div>
            </div>
        </Fragment>
    );
}
