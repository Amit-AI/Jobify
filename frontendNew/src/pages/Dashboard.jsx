import React from "react";
import { Link } from "react-router-dom";

export default function Dashboard() {
    return (
        <div className="pt-20 flex-1">
            <div className="h-full flex flex-col items-center justify-center">
                <div>
                    <h1 className="text-4xl sm:text-6xl font-bold">
                        Get The <span className="text-blue-600">Right Job</span>
                    </h1>
                    <h1 className="text-center text-4xl sm:text-6xl font-bold">
                        You Deserve
                    </h1>
                </div>
                <p className="my-5 text-gray-500 text-center">
                    Your dream job is waiting
                </p>
                <Link to={"/jobs"}>
                    <button
                        type="button"
                        className="text-blue-600 hover:text-white border border-blue-600 hover:bg-blue-600 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium  text-sm sm:text-md rounded-lg px-5 py-2.5 text-center mr-2"
                    >
                        Get Started
                    </button>
                </Link>
            </div>
        </div>
    );
}
