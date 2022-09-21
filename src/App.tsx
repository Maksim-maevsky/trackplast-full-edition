import React from 'react';
import './App.css';
import {ApplicationBar} from "./component/ApplicationBar";
import {StoragesTable} from "./component/StoragesTable";


function App() {

    return (
        <>
            <ApplicationBar/>

            <main style={{
                display: 'flex',
                marginTop: 150,
                justifyContent: 'center'
            }}>
                <StoragesTable/>
            </main>

        </>
    );
}

export default App;
