import React, {useContext, useEffect} from "react";
import {connect, useDispatch, useSelector} from 'react-redux';
import {RawDiscipline} from "../../../types";
import {ThunkDispatch} from "@reduxjs/toolkit";
import {SkatesActions} from "../../../actions/types";
import {deleteDiscipline, deleteSkate, fetchDisciplines, fetchSkates} from "../../../actions/skates";
import LoadingContext from "../../common/LoadingContext";
import ListsWrapper from "../ListWrapper";
import Box from '@mui/material/Box';
import {Alert, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";

interface DisciplineListProps {
    error: string;
    disciplines: RawDiscipline[];
}

const DisciplinesList = ({error, disciplines}: DisciplineListProps) => {
    const dispatch: ThunkDispatch<{}, {}, SkatesActions> = useDispatch();
    const {showLoading, hideLoading} = useContext(LoadingContext);

    useEffect(() => {
        const onDisciplinesFetch = async () => {
          await dispatch(fetchDisciplines());
        };

        showLoading();
        onDisciplinesFetch().then(hideLoading);
    }, [dispatch, hideLoading, showLoading]);

    const onDeleteClicked = async (e: React.MouseEvent<HTMLSpanElement, MouseEvent>, uuid: string) => {
        e.preventDefault();
        await dispatch(deleteDiscipline(uuid)).then(async () => {
            await dispatch(fetchDisciplines());
        });
    };

    return (
        <>
            {!!error ?
                <span className="errorBlock"><Alert sx={{fontSize: '15px;'}} severity="error">{error}</Alert></span>
                : null
            }
            <ListsWrapper>
                <Box
                    sx={{ width: '100%', height: 400, maxWidth: 360 }}
                >
                    <TableContainer component={Paper} sx={{ width: 984 }}>
                        <Table sx={{ minWidth: 650 }} aria-label="simple table">
                            <TableHead>
                                <TableRow>
                                    <TableCell>ID</TableCell>
                                    <TableCell align="right">Discipline</TableCell>
                                    <TableCell align="right">UUID</TableCell>
                                    <TableCell align="right">Actions</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {disciplines.map((d) => (
                                    <TableRow
                                        key={d.id}
                                        sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                    >
                                        <TableCell component="th" scope="row">
                                            {d.id}
                                        </TableCell>
                                        <TableCell align="right">{d.discipline}</TableCell>
                                        <TableCell align="right">{d.uuid}</TableCell>
                                        <TableCell align="right">{
                                            <span className="actionIcon" onClick={(e) => onDeleteClicked(e, d.uuid)}>
                                            <DeleteIcon fontSize="medium" />
                                        </span>
                                        }</TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        </Table>
                    </TableContainer>
                </Box>
            </ListsWrapper>
        </>
    );
};

const mapStateToProps = (state: {
    skates: {
        skates: DisciplineListProps
    }
}): DisciplineListProps => ({
        error: state.skates.skates.error,
        disciplines: state.skates.skates.disciplines
    });

export default connect(mapStateToProps)(DisciplinesList);