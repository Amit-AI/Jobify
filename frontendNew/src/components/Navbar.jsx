import { useState } from "react";

function Navbar() {
    const [profileOpen, setProfileOpen] = useState(false);
    const [menuOpen, setMenuOpen] = useState(false);

    const navList = [
        {
            name: "About",
        },
        {
            name: "Services",
        },
        {
            name: "Pricing",
        },
        {
            name: "Contact",
        },
    ];

    return (
        <div className="App">
            <nav class="bg-white border-gray-200 px-2 sm:px-4 py-2.5 bg-inherit ">
                <div class="container flex flex-wrap items-center justify-between mx-auto">
                    <a href="#" class="flex items-center">
                        {/* <img
                            src="https://flowbite.com/docs/images/logo.svg"
                            class="h-6 mr-3 sm:h-9"
                            alt="Flowbite Logo"
                        /> */}
                        <span class="self-center text-xl font-semibold whitespace-nowrap text-white text-3xl">
                            Job Listing
                        </span>
                    </a>
                    <div class="flex items-center md:order-2 relative">
                        <button
                            type="button"
                            class="text-green-300 hover:text-white border border-green-500 hover:bg-green-500 focus:ring-4 focus:outline-none focus:ring-green-800 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2 hidden md:inline-block"
                        >
                            Sign in
                        </button>
                        <button
                            type="button"
                            class="focus:outline-none text-white bg-green-500 hover:bg-green-400 focus:ring-4 focus:ring-green-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2"
                        >
                            Sign up
                        </button>

                        <button
                            type="button"
                            class="flex mr-3 text-sm bg-gray-800 rounded-full md:mr-0 focus:ring-4 focus:ring-gray-300 dark:focus:ring-gray-600"
                            id="user-menu-button"
                            aria-expanded="false"
                            data-dropdown-toggle="user-dropdown"
                            data-dropdown-placement="bottom"
                            onClick={()=>setProfileOpen(!profileOpen)}
                        >
                            <span class="sr-only">Open user menu</span>
                            <img
                                class="w-8 h-8 rounded-full"
                                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0HJ73OTXpxJwj_WyPS-ptg44zo2fYjiTi7g&usqp=CAU"
                                alt="user photo"
                            />
                        </button>
                        {/* <!-- Dropdown menu --> */}
                        <div
                            className={`z-50 ${
                                profileOpen ? "" : "hidden"
                            }  my-4 text-base list-none bg-white divide-y divide-gray-100 rounded shadow dark:bg-gray-700 dark:divide-gray-600 absolute top-[25px] right-[100px]"
                            id="user-dropdown`}
                        >
                            <div class="px-4 py-3">
                                <span class="block text-sm text-gray-900 dark:text-white">
                                    Bonnie Green
                                </span>
                                <span class="block text-sm font-medium text-gray-500 truncate dark:text-gray-400">
                                    name@flowbite.com
                                </span>
                            </div>
                            <ul class="py-1" aria-labelledby="user-menu-button">
                                <li>
                                    <a
                                        href="#"
                                        class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white"
                                    >
                                        Dashboard
                                    </a>
                                </li>
                                <li>
                                    <a
                                        href="#"
                                        class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white"
                                    >
                                        Settings
                                    </a>
                                </li>
                                <li>
                                    <a
                                        href="#"
                                        class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white"
                                    >
                                        Earnings
                                    </a>
                                </li>
                                <li>
                                    <a
                                        href="#"
                                        class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white"
                                    >
                                        Sign out
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <button
                            data-collapse-toggle="mobile-menu-2"
                            type="button"
                            class="inline-flex items-center p-2 ml-1 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600"
                            aria-controls="mobile-menu-2"
                            aria-expanded="false"
                            onClick={()=>setMenuOpen(!menuOpen)}
                        >
                            <span class="sr-only">Open main menu</span>
                            <svg
                                class="w-6 h-6"
                                aria-hidden="true"
                                fill="currentColor"
                                viewBox="0 0 20 20"
                                xmlns="http://www.w3.org/2000/svg"
                            >
                                <path
                                    fill-rule="evenodd"
                                    d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z"
                                    clip-rule="evenodd"
                                ></path>
                            </svg>
                        </button>
                    </div>
                    <div
                        class={`items-center justify-between  ${menuOpen? "": "hidden"} w-full md:flex md:w-auto md:order-1`}
                        id="mobile-menu-2"
                    >
                        <ul class="flex flex-col p-4 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:flex-row md:space-x-8 md:mt-0 md:text-base md:font-medium md:border-0 md:bg-white md:bg-inherit absolute w-11/12">
                            <li>
                                <a
                                    href="#"
                                    class="block py-2 pl-3 pr-4 text-white rounded
                                    text-green-300 md:p-0"
                                    aria-current="page"
                                >
                                    Home
                                </a>
                            </li>

                            {navList.map((item, index) => (
                                <li>
                                    <a
                                        href="#"
                                        key={index}
                                        class="block py-2 pl-3 pr-4 text-gray-700 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-green-300 md:p-0 md:text-gray-300"
                                    >
                                        {item.name}
                                    </a>
                                </li>
                            ))}
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    );
}

export default Navbar;
