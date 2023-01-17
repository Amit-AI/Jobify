import axios from "axios";
import { useState } from "react";
import {
    Button,
    Card,
    Form,
    FormControl,
    FormGroup,
    FormLabel,
    FormSelect,
} from "react-bootstrap";
import { ToastContainer } from "react-toastify";
import { errorToast, successToast } from "../utils/ToastUtil";

export default function Users() {
    const [formState, setFormState] = useState({
        userName: "",
        userPwd: "",
        userEmail: "",
        userRole: "",
    });

    const formItems = [
        {
            label: "Username",
            type: "text",
            name: "userName",
        },
        {
            label: "Password",
            type: "password",
            name: "userPwd",
        },
        {
            label: "Email",
            type: "email",
            name: "userEmail",
        },
    ];

    const handleSubmit = async (e) => {
        
        e.preventDefault();

        console.log(formState);
        await axios
            .post("http://localhost:8081/user", { ...formState })
            .then(function (response) {
                console.log(response);
                successToast("User added Successfully!");
            })
            .catch(function (error) {
                console.log(error);
                errorToast("Something went wrong!");
            });

        
    }

    function handleChange(e) {
        let name = e.target.name;
        let value = e.target.value;

        let update = { [name]: value };

        setFormState({ ...formState, ...update });
    }

    return (
        <div>
            <Card body className="w-50 my-5 mx-auto">
                <Form onSubmit={handleSubmit}>
                    {formItems.map((item, index) => (
                        <FormGroup key={index} className="mb-3">
                            <FormLabel>{item.label}</FormLabel>
                            <FormControl
                                type={item.type}
                                name={item.name}
                                onChange={handleChange}
                            />
                        </FormGroup>
                    ))}

                    <FormLabel>Role</FormLabel>
                    <FormSelect
                        aria-label="Select Role"
                        name="userRole"
                        className="mb-3"
                        onChange={handleChange}
                    >
                        {/* <option selected></option> */}
                        <option value="admin">Admin</option>
                        <option value="user">User</option>
                    </FormSelect>

                    <Button
                        variant="primary"
                        type="submit"
                        className="d-block m-auto"
                    >
                        Submit
                    </Button>
                </Form>
            </Card>
            <ToastContainer />
        </div>
    );
}
