import { Route, Routes } from "react-router-dom";
import Home from "../pages/Home";
import Jobs from "../pages/Jobs";
import Users from "../pages/Users";

const Router = () => {
  return (
    <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/jobs" element={<Jobs/>}/>
        <Route path="/users" element={<Users/>}/>
    </Routes>
  )
}

export default Router;