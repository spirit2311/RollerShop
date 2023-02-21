import React from 'react';
import ReactDOM from 'react-dom/client';
import {BrowserRouter} from "react-router-dom";
import Dashboard from "./components/Dashboard";
import {Provider} from "react-redux";
import store from "./store";

const root = ReactDOM.createRoot(
    document.getElementById('react') as HTMLElement
);

root.render(
    <Provider store={store}>
        <BrowserRouter>
            <Dashboard/>
        </BrowserRouter>
    </Provider>
);
