import { Route, Routes } from "react-router-dom";
import Home from "../pages/Home";
import Jobs from "../pages/Jobs";

const Router = () => {
  return (
    <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/jobs" element={<Jobs/>}/>
    </Routes>
  )
}

export default Router;