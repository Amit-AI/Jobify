import { useState } from "react";
import { NavLink } from "react-router-dom";

function Navbar() {
    const [profileOpen, setProfileOpen] = useState(false);
    const [menuOpen, setMenuOpen] = useState(false);

    const navList = [
        {
            name: "Dashboard",
            url: "/",
        },
        {
            name: "Jobs",
            url: "/jobs",
        },
        {
            name: "Contact",
            url: "/contact",
        },
    ];

    const profileMenuList = ["Profile", "Settings", "Sign out"];

    return (
        <div className="Navbar fixed top-0 w-full bg-white">
            <nav class="relative flex items-center justify-between p-3 shadow-md sm:p-4">
                {/* <!-- left nav --> */}
                <NavLink to={"/"}>
                    <div class="logo">
                        <h1 class="cursor-pointer text-2xl md:text-3xl">
                            JobListing
                        </h1>
                    </div>
                </NavLink>

                {/* <!-- mid nav --> */}
                <div
                    class={`nav-items absolute top-16 -ml-3 -mr-3 -mt-2 h-screen w-full border bg-slate-100 sm:static sm:mt-2 sm:mx-5 sm:block sm:h-auto sm:border-none sm:bg-transparent ${
                        menuOpen ? "" : "hidden"
                    }`}
                >
                    <ul class="divide-y sm:flex sm:justify-center sm:divide-none sm:p-0">
                        {navList.map((item, index) => (
                            <NavLink to={item.url}>
                                <li
                                    key={index}
                                    class="cursor-pointer rounded-md p-2 hover:bg-gray-200 sm:mx-2 sm:px-3"
                                >
                                    {item.name}
                                </li>
                            </NavLink>
                        ))}
                    </ul>
                </div>
                {/* <!-- right nav --> */}
                <div class="flex items-center justify-between">
                    <button
                        type="button"
                        class="mr-2 whitespace-nowrap rounded-lg bg-blue-700 px-4 py-2 text-sm font-medium text-white hover:bg-blue-800 focus:outline-none focus:ring-4 focus:ring-blue-300"
                    >
                        Sign up
                    </button>
                    <button
                        type="button"
                        class="mr-2 hidden whitespace-nowrap rounded-lg border border-blue-700 px-4 py-2 text-sm font-medium text-blue-700 hover:bg-blue-700 hover:text-white focus:outline-none focus:ring-4 focus:ring-blue-300 sm:block"
                    >
                        Sign in
                    </button>
                    {/* <!-- profile container --> */}
                    <div class="profile-container relative">
                        {/* <!-- profile icon --> */}
                        <div class="profile mx-1 cursor-pointer sm:mx-0">
                            <svg
                                xmlns="http://www.w3.org/2000/svg"
                                fill="none"
                                viewBox="0 0 24 24"
                                stroke-width="1.5"
                                stroke="currentColor"
                                class="h-6 w-6"
                                onClick={() => setProfileOpen(!profileOpen)}
                            >
                                <path
                                    stroke-linecap="round"
                                    stroke-linejoin="round"
                                    d="M17.982 18.725A7.488 7.488 0 0012 15.75a7.488 7.488 0 00-5.982 2.975m11.963 0a9 9 0 10-11.963 0m11.963 0A8.966 8.966 0 0112 21a8.966 8.966 0 01-5.982-2.275M15 9.75a3 3 0 11-6 0 3 3 0 016 0z"
                                />
                            </svg>
                        </div>
                        {/* Profile menu */}
                        <div
                            class={`profile-menu absolute top-9 -left-24 rounded-md border bg-white text-sm sm:-left-28 ${
                                profileOpen ? "" : "hidden"
                            }`}
                        >
                            <p class="bg-slate-200 px-2">name</p>
                            <p class="bg-slate-200 px-2 pb-1">name@email.com</p>
                            <hr />
                            <ul>
                                {profileMenuList.map((item, index) => (
                                    <li
                                        key={index}
                                        class="cursor-pointer px-2 py-1 hover:bg-gray-200"
                                    >
                                        {item}
                                    </li>
                                ))}
                            </ul>
                        </div>
                    </div>
                    {/* <!-- burger menu --> */}
                    <div class="menu-btn mx-1 cursor-pointer flex-row sm:hidden">
                        <svg
                            xmlns="http://www.w3.org/2000/svg"
                            fill="none"
                            viewBox="0 0 24 24"
                            stroke-width="1.5"
                            stroke="currentColor"
                            class="h-6 w-6"
                            onClick={() => setMenuOpen(!menuOpen)}
                        >
                            <path
                                stroke-linecap="round"
                                stroke-linejoin="round"
                                d="M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5"
                            />
                        </svg>
                    </div>
                </div>
            </nav>
        </div>
    );
}

export default Navbar;
