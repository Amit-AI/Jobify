import Footer from "./components/Footer";
import Form from "./components/Form";
import Navbar from "./components/Navbar";
import "../src/index.css";

function App() {
    return (
        <div className="App h-screen bg-emerald-900">
            <Navbar />
            <Form />
            <Footer />
        </div>
    );
}

export default App;
