import React, {useEffect} from "react";
import {ThunkDispatch} from "@reduxjs/toolkit";
import {createBrand, setBrandCreatedStatus, setCreateBrandError} from "../../../actions/skates";
import {useDispatch, useSelector} from "react-redux";
import {Alert, Box, Button} from "@mui/material";
import {SkatesActions} from "../../../actions/types";

const CreateBrandForm = () => {
    const dispatch: ThunkDispatch<{}, {}, SkatesActions> = useDispatch();
    const [brand, setBrand] = React.useState('');
    const {error, brandCreatedStatus} = useSelector(({skates}) => {
        return {
            error: skates.skates.error,
            brandCreatedStatus: skates.skates.brandCreatedStatus
        };
    });

    useEffect(() => {
        return () => {
            dispatch(setBrandCreatedStatus(null));
            dispatch(setCreateBrandError(''));
        }
    }, []);

    const handleSubmit = async () => {
        await dispatch(createBrand(brand)).then(() => {
            setBrand('');
        });
    };

    return (
        <span>
            {!!error ?
                <span className="errorBlock"><Alert sx={{fontSize: '15px;'}} severity="error">{error}</Alert></span>
                : null
            }
            {
                brandCreatedStatus === 202 ? (
                    <Alert severity="success">Brand was successfully created!</Alert>
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
                    <input
                        type="text"
                        placeholder="Brand"
                        value={brand}
                        onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
                            setBrand(event.target.value);
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

export default CreateBrandForm;