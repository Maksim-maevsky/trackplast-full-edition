import React from 'react';
import './App.css';
import StorageInfoPage from "./pages/StorageInfoPage";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import AboutPage from "./pages/AboutPage";


function App() {


    return (
        <BrowserRouter>
            <Routes>
                <Route path="/storage" element={<StorageInfoPage/>}/>
                <Route path="/about"element={ <AboutPage/>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
