import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const toastProperties = {
    position: "bottom-right",
    autoClose: 5000,
    hideProgressBar: false,
    closeOnClick: true,
    pauseOnHover: true,
    draggable: true,
    progress: undefined,
    theme: "colored",
};

function promiseSuccessToast(promise, message) {
    return toast.promise(promise, message, {
        position: toast.POSITION.BOTTOM_RIGHT,
    });
}

function successToast(message) {
    return toast.success(message, toastProperties);
}

function errorToast(message) {
    return toast.error(message, toastProperties);
}

export { successToast, errorToast, promiseSuccessToast };
