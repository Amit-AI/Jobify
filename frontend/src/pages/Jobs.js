import React from "react";
import axios from "axios";
import { errorToast, successToast } from "../utils/ToastUtil";
import { ToastContainer } from "react-toastify";

const Jobs = () => {
    const loadData = () => {
        axios
            .get("http://localhost:8081/job")
            .then(function (response) {
                // handle success
                console.log(response.data);
                successToast("Data Loaded Successfully!");
            })
            .catch(function (error) {
                // handle error
                console.log(error);
                errorToast("Something went wrong!");
            });
    };
    return (
        <div>
            <button onClick={loadData}>LoadUserData</button>
            <ToastContainer />
        </div>
    );
};

export default Jobs;
