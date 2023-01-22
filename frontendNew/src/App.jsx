import Footer from "./components/Footer";
import Form from "./components/Form";
import Navbar from "./components/Navbar";
import Router from "./router/Router";
import "../src/index.css";


function App() {    
    return (
        <div className="App">
            <Navbar />
            <Router />
            <Footer />
        </div>
    );
}

export default App;
