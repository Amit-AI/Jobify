import axios from "axios";
import { errorToast, successToast } from "../utils/ToastUtil";
import { ToastContainer } from "react-toastify";
import { Container } from "react-bootstrap";
import { useState } from "react";

const Jobs = () => {
    
    const loadData = async () => {
        await axios
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
            <Container>
                <button onClick={loadData}>LoadUserData</button>
                <ToastContainer />
            </Container>
        </div>
    );
};

export default Jobs;
