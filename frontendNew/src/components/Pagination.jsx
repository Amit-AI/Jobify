import React from "react";

export default function Pagination({ pageData, setPage }) {
    return (
        <nav className="mx-auto mb-4">
            <ul className="flex">
                <li
                    className={`${
                        pageData.isFirstPage
                            ? "pointer-events-none text-gray-400"
                            : ""
                    }`}
                    onClick={() => setPage(pageData.currentPage - 1)}
                >
                    <a
                        className="mx-1 flex h-9 w-9 items-center justify-center rounded-full border border-blue-gray-100 bg-transparent p-0 text-sm text-blue-gray-500 transition duration-150 ease-in-out hover:bg-light-300"
                        href="#"
                        aria-label="Previous"
                    >
                        <span className="text-sm">
                            <svg
                                xmlns="http://www.w3.org/2000/svg"
                                fill="none"
                                viewBox="0 0 24 24"
                                stroke-width="1.5"
                                stroke="currentColor"
                                className="w-6 h-6"
                            >
                                <path
                                    stroke-linecap="round"
                                    stroke-linejoin="round"
                                    d="M15.75 19.5L8.25 12l7.5-7.5"
                                />
                            </svg>
                        </span>
                    </a>
                </li>
                <li
                    className={`${
                        pageData.isLastPage
                            ? "pointer-events-none text-gray-400"
                            : ""
                    }`}
                    onClick={() => setPage(pageData.currentPage + 1)}
                >
                    <a
                        className="mx-1 flex h-9 w-9 items-center justify-center rounded-full border border-blue-gray-100 bg-transparent p-0 text-sm text-blue-gray-500 transition duration-150 ease-in-out hover:bg-light-300"
                        href="#"
                        aria-label="Next"
                    >
                        <span className="text-sm">
                            <svg
                                xmlns="http://www.w3.org/2000/svg"
                                fill="none"
                                viewBox="0 0 24 24"
                                stroke-width="1.5"
                                stroke="currentColor"
                                className="w-6 h-6"
                            >
                                <path
                                    stroke-linecap="round"
                                    stroke-linejoin="round"
                                    d="M8.25 4.5l7.5 7.5-7.5 7.5"
                                />
                            </svg>
                        </span>
                    </a>
                </li>
            </ul>
        </nav>
    );
}
