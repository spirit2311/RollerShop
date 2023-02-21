import * as React from 'react';
import {useRoutes} from "react-router-dom";
import DashboardWrapper from "./DashboardWrapper";
import Loader from "./common/Loader";
import LoadingProvider from "./common/LoadingProvider";
import SkatesList from "./skatesList/SkatesList";
import NavBar from "./navBar/NavBar";
import SelectedSkate from "./selectedSkate/SelectedSkate";
import CreateForm from "./createForm/CreateForm";
import DisciplinesList from "./lists/disciplines/DisciplinesList";
import BrandsList from "./lists/brands/BrandsList";

const SkatesRoutes = () => useRoutes([
    { path: "/", element: <SkatesList /> },
    { path: "/skates/info/:id", element: <SelectedSkate /> },
    { path: "/create", element: <CreateForm /> },
    { path: "/disciplines", element: <DisciplinesList /> },
    { path: "/brands", element: <BrandsList /> }
]);

const Dashboard = (): JSX.Element => {
    return (
        <DashboardWrapper>
            <LoadingProvider>
                <NavBar />
                <Loader />
                <SkatesRoutes />
            </LoadingProvider>
        </DashboardWrapper>
    );
};

export default Dashboard;
