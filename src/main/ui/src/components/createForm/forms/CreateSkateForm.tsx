import React, {useEffect} from "react";
import {Alert, Box, Button} from "@mui/material";
import {SkateJsonModel} from "../../../types";
import {ThunkDispatch} from "@reduxjs/toolkit";
import {createSkate, setCreateSkateError, setSkateCreatedStatus} from "../../../actions/skates";
import {useDispatch, useSelector} from "react-redux";
import {SkatesActions} from "../../../actions/types";
import Dropdown from "../../common/Dropdown";

const CreateSkateForm = () => {
    const dispatch: ThunkDispatch<{}, {}, SkatesActions> = useDispatch();
    const [brandId, setBrandId] = React.useState('');
    const [disciplineId, setDisciplineId] = React.useState('');
    const [model, setModel] = React.useState('');
    const [price, setPrice] = React.useState('');
    const [description, setDescription] = React.useState('');
    const [year, setYear] = React.useState('');
    const [shouldClear, setShouldClear] = React.useState(false);
    const {error, skateCreatedStatus, disciplines, brands} = useSelector(({skates}) => {
        return {
            disciplines: skates.skates.disciplines,
            brands: skates.skates.brands,
            error: skates.skates.error,
            skateCreatedStatus: skates.skates.skateCreatedStatus
        };
    });

    useEffect(() => {
        return () => {
            dispatch(setSkateCreatedStatus(null));
            dispatch(setCreateSkateError(''));
        }
    }, []);

    useEffect(() => {
       if (skateCreatedStatus === 202) {
           setBrandId('');
           setDisciplineId('');
           setModel('');
           setPrice('');
           setDescription('');
           setYear('');
           setShouldClear(true);
       }
    }, [skateCreatedStatus]);

    const handleSubmit = async () => {
        const skateJsonModel: SkateJsonModel = {
            brandId: Number(brandId),
            disciplineId: Number(disciplineId),
            price: Number(price),
            year: Number(year),
            description,
            model
        };

        await dispatch(createSkate(skateJsonModel));
    };

    return (
        <span>
            {!!error ?
                <span className="errorBlock"><Alert sx={{fontSize: '15px;'}} severity="error">{error}</Alert></span>
                : null
            }
            {
                skateCreatedStatus === 202 && !error ? (
                    <Alert severity="success">Skate was successfully created!</Alert>
                ) : null
            }
            <Box
                className="CreateSkateForm"
                component="form"
                sx={{
                    '& > :not(style)': {m: 1, width: '25ch'},
                }}
                noValidate
                autoComplete="off"
            >
                <span className="formGroup">
                    <span className="dropdowns">
                        <Dropdown
                            options={brands}
                            onChange={setBrandId}
                            fieldToShow='id'
                            additionalField='brand'
                            label='Brand'
                            selected={brandId}
                            shouldClear={shouldClear}
                        />
                        <Dropdown
                            options={disciplines}
                            onChange={setDisciplineId}
                            fieldToShow='id'
                            additionalField='discipline'
                            label='Discipline'
                            selected={disciplineId}
                            shouldClear={shouldClear}
                        />
                    </span>
                    <input
                        type="text"
                        placeholder="Model"
                        value={model}
                        onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
                            const { value } = event.target;
                            setModel(value);
                        }}
                        required
                    />
                </span>
                <span className="formGroup">
                    <input
                        type="number"
                        placeholder="Price"
                        pattern="[0-9]*"
                        value={price}
                        onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
                            setPrice(event.target.value);
                        }}
                        required
                    />
                <input
                    type="text"
                    placeholder="Description"
                    value={description}
                    onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
                        const { value } = event.target;
                        setDescription(value);
                    }}
                    required
                />
                <input
                    type="number"
                    placeholder="Year"
                    pattern="[0-9]*"
                    value={year}
                    onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
                        setYear(event.target.value);
                    }}
                    required
                />
                </span>
            </Box>
            <div className="submitContainer">
                <Button variant="contained" onClick={handleSubmit}>SUBMIT</Button>
            </div>
        </span>
    );
};

export default CreateSkateForm;