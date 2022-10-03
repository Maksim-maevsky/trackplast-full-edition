import React from 'react';
import './App.css';
import StorageInfoPage from "./pages/StorageInfoPage";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import AboutPage from "./pages/AboutPage";
import LogisticsPage from "./pages/LogisticsPage";
import HomePage from "./pages/HomePage";
import PaymentsPage from "./pages/PaymentsPage";


function App() {


    return (
        <BrowserRouter>
            <Routes>
                <Route path="/report" element={<StorageInfoPage/>}/>
                <Route path="/about" element={<AboutPage/>}/>
                <Route path="/logistics" element={<LogisticsPage/>}/>
                <Route path="/" element={<HomePage/>}/>
                <Route path="/payments" element={<PaymentsPage/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
