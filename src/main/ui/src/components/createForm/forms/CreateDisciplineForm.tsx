import React, {useEffect} from "react";
import {Alert, Box, Button} from "@mui/material";
import {
    createDiscipline,
    setCreateDisciplineError,
    setDisciplineCreatedStatus
} from "../../../actions/skates";
import {useDispatch, useSelector} from "react-redux";
import {ThunkDispatch} from "@reduxjs/toolkit";
import {SkatesActions} from "../../../actions/types";

const CreateDisciplineForm = () => {
    const dispatch: ThunkDispatch<{}, {}, SkatesActions> = useDispatch();
    const [discipline, setDiscipline] = React.useState('');
    const {error, disciplineCreatedStatus} = useSelector(({skates}) => {
        return {
            error: skates.skates.error,
            disciplineCreatedStatus: skates.skates.disciplineCreatedStatus
        };
    });

    useEffect(() => {
        return () => {
            dispatch(setDisciplineCreatedStatus(null));
            dispatch(setCreateDisciplineError(''));
        }
    }, []);

    const handleSubmit = async () => {
        await dispatch(createDiscipline(discipline)).then(() => {
            setDiscipline('');
        });
    };

    return (
        <span>
            {!!error ?
                <span className="errorBlock"><Alert sx={{fontSize: '15px;'}} severity="error">{error}</Alert></span>
                : null
            }
            {
                disciplineCreatedStatus === 202 ? (
                    <Alert severity="success">Discipline was successfully created!</Alert>
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
                        placeholder="Discipline"
                        value={discipline}
                        onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
                            setDiscipline(event.target.value);
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

export default CreateDisciplineForm;