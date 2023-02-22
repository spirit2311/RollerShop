import React, {useContext, useEffect} from "react";
import {RawBrand, RawDiscipline, Skate, SkateJsonModel} from "../../types";
import {ThunkDispatch} from "@reduxjs/toolkit";
import {fetchBrands, fetchDisciplines, fetchSkates, setSkateUpdatedStatus, updateSkate} from "../../actions/skates";
import {useDispatch, useSelector} from "react-redux";
import {Alert, Box, Button, DialogActions, DialogContent, DialogTitle} from "@mui/material";
import UpdateSkateDialogWrapper from "./UpdateSkateDialogWrapper";
import {SkatesActions} from "../../actions/types";
import Dropdown from "../common/Dropdown";
import LoadingContext from "../common/LoadingContext";

const UpdateSkateDialogContent = ({skate, onClose}: { skate: Skate, onClose: () => void }): JSX.Element => {
    const dispatch: ThunkDispatch<{}, {}, SkatesActions> = useDispatch();
    const {
        uuid,
        model: defaultModelValue,
        year: defaultYearValue,
        price: defaultPriceValue,
        description: defaultDescrValue
    } = skate;
    const [brandId, setBrandId] = React.useState('');
    const [disciplineId, setDisciplineId] = React.useState('');
    const [model, setModel] = React.useState(defaultModelValue);
    const [price, setPrice] = React.useState<string | number>(defaultPriceValue);
    const [description, setDescription] = React.useState(defaultDescrValue);
    const [year, setYear] = React.useState<string | number>(defaultYearValue);
    const {showLoading, hideLoading} = useContext(LoadingContext);
    const {error, skateUpdatedStatus, disciplines, brands} = useSelector(({skates}) => {
        return {
            disciplines: skates.skates.disciplines,
            brands: skates.skates.brands,
            error: skates.skates.error,
            skateUpdatedStatus: skates.skates.skateUpdatedStatus
        };
    });

    useEffect(() => {
        const onDisciplinesFetch = async () => {
            await dispatch(fetchDisciplines());
        };

        const onBrandsFetch = async () => {
            await dispatch(fetchBrands());
        };

        showLoading();
        onDisciplinesFetch().then(onBrandsFetch).then(hideLoading);
    }, [dispatch, hideLoading, showLoading]);

    useEffect(() => {
        const fetchSkatesAction = async () => {
            await dispatch(fetchSkates());
        }

        if (skateUpdatedStatus === 202) {
            fetchSkatesAction().then(() => {
                onClose();
            });
        }
    }, [skateUpdatedStatus]);

    const handleSubmit = async () => {
        const skateJsonModel: SkateJsonModel = {
            brandId: Number(brandId),
            disciplineId: Number(disciplineId),
            price: Number(price),
            year: Number(year),
            description,
            model
        };

        await dispatch(updateSkate(uuid, skateJsonModel)).then(() => {
            dispatch(setSkateUpdatedStatus(null));
        });
    };

    return (
        <UpdateSkateDialogWrapper>
            <DialogTitle>Edit Skate</DialogTitle>
                <DialogContent>
                    {!!error ?
                        <span className="errorBlock"><Alert sx={{fontSize: '15px;'}} severity="error">{error}</Alert></span>
                        : null
                    }
                    <Box
                        className="updateSkateForm"
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
                        />
                        <Dropdown
                            options={disciplines}
                            onChange={setDisciplineId}
                            fieldToShow='id'
                            additionalField='discipline'
                            label='Discipline'
                        />
                    </span>
                    <input
                        type="text"
                        placeholder="Model"
                        value={model}
                        onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
                            const {value} = event.target;
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
                            const {value} = event.target;
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
                </DialogContent>
                <DialogActions>
                  <Button onClick={onClose}>Cancel</Button>
                  <Button onClick={handleSubmit}>SUBMIT</Button>
                </DialogActions>
        </UpdateSkateDialogWrapper>
    );
};

export default UpdateSkateDialogContent;