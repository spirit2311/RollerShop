import Tab from "@mui/material/Tab";
import React, {useContext, useEffect} from "react";
import CreateFormWrapper from "./CreateFormWrapper";
import CreateSkateForm from "./forms/CreateSkateForm";
import CreateDisciplineForm from "./forms/CreateDisciplineForm";
import CreateBrandForm from "./forms/CreateBrandForm";
import TabPanel from '@mui/lab/TabPanel';
import {TabContext, TabList} from "@mui/lab";
import {Box} from "@mui/material";
import {fetchBrands, fetchDisciplines} from "../../actions/skates";
import {ThunkDispatch} from "@reduxjs/toolkit";
import {SkatesActions} from "../../actions/types";
import {useDispatch} from "react-redux";
import LoadingContext from "../common/LoadingContext";

const CreateForm = () => {
    const [value, setValue] = React.useState('skate');

    const handleChange = (event: React.SyntheticEvent, newValue: string) => {
        setValue(newValue);
    };

    return (
        <CreateFormWrapper>
            <section className="titleSection">
                <div className="title">CREATE</div>
            </section>
            <TabContext value={value}>
                <Box sx={{ borderBottom: 1, borderColor: 'divider' }}>
                    <TabList onChange={handleChange} aria-label="create tabs">
                        <Tab value="skate" label="Skate" />
                        <Tab value="discipline" label="Discipline" />
                        <Tab value="brand" label="Brand" />
                    </TabList>
                </Box>
                <TabPanel value="skate">
                    <CreateSkateForm />
                </TabPanel>
                <TabPanel value="discipline">
                    <CreateDisciplineForm />
                </TabPanel>
                <TabPanel value="brand">
                    <CreateBrandForm />
                </TabPanel>
            </TabContext>
        </CreateFormWrapper>
    );
};

export default CreateForm;