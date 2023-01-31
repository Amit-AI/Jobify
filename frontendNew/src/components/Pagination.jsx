import React from "react";

export default function Pagination({ pageData, setPage }) {
    console.log(pageData);

    // function getPages() {
    //     let pages = [];
    //     let firstPage = pageData.currentPage + 1; //+1 because, first page starts with 0
    //     let lastPage = pageData.totalPages;
        
    //     for(let i=1; i<=lastPage; i++){
    //         pages.push(i)
    //     }

    //     console.log("called")
    //     return pages
    // }

    // function handlePageChange(e, setPageNumber, ) {
    //     setPageNumber(currPage-1);
    // }

    return (
        <nav className="mx-auto mb-4">
            <ul class="flex">
                <li
                    className={`${
                        pageData.isFirstPage
                            ? "pointer-events-none text-gray-400"
                            : ""
                    }`}
                    onClick={()=> setPage(pageData.currentPage-1)}
                >
                    <a
                        class="mx-1 flex h-9 w-9 items-center justify-center rounded-full border border-blue-gray-100 bg-transparent p-0 text-sm text-blue-gray-500 transition duration-150 ease-in-out hover:bg-light-300"
                        href="#"
                        aria-label="Previous"
                    >
                        <span class="text-sm">
                            <svg
                                xmlns="http://www.w3.org/2000/svg"
                                fill="none"
                                viewBox="0 0 24 24"
                                stroke-width="1.5"
                                stroke="currentColor"
                                class="w-6 h-6"
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

                {/* {getPages().map((page, index) => (
                    <li key={index}>
                        <a
                            id={page}
                            class="mx-1 flex h-9 w-9 items-center justify-center rounded-full bg-blue-600 p-0 text-sm text-white shadow-md transition duration-150 ease-in-out"
                            onClick={(e) => handlePageChange(e, setPage)}
                            href="#"
                        >
                            {page}
                        </a>
                    </li>
                ))} */}
                {/* <li>
                    <a
                        class="mx-1 flex h-9 w-9 items-center justify-center rounded-full bg-blue-600 p-0 text-sm text-white shadow-md transition duration-150 ease-in-out"
                        href="#"
                    >
                        1
                    </a>
                </li>
                <li>
                    <a
                        class="mx-1 flex h-9 w-9 items-center justify-center rounded-full border border-blue-gray-100 bg-transparent p-0 text-sm text-blue-gray-500 transition duration-150 ease-in-out hover:bg-light-300"
                        href="#"
                    >
                        2
                    </a>
                </li>
                <li>
                    <a
                        class="mx-1 flex h-9 w-9 items-center justify-center rounded-full border border-blue-gray-100 bg-transparent p-0 text-sm text-blue-gray-500 transition duration-150 ease-in-out hover:bg-light-300"
                        href="#"
                    >
                        3
                    </a>
                </li> */}
                <li
                    className={`${
                        pageData.isLastPage
                            ? "pointer-events-none text-gray-400"
                            : ""
                    }`}

                    onClick={()=>setPage(pageData.currentPage+1)}
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
                                class="w-6 h-6"
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
