import React, {useContext, useEffect} from "react";
import {connect, useDispatch} from 'react-redux';
import {RawBrand} from "../../../types";
import {ThunkDispatch} from "@reduxjs/toolkit";
import {SkatesActions} from "../../../actions/types";
import {deleteBrand, fetchBrands, fetchDisciplines} from "../../../actions/skates";
import LoadingContext from "../../common/LoadingContext";
import ListsWrapper from "../ListWrapper";
import Box from '@mui/material/Box';
import {Alert, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from "@mui/material";
import DeleteIcon from "@mui/icons-material/Delete";

interface BrandListProps {
    error: string;
    brands: RawBrand[];
}

const BrandsList = ({error, brands}: BrandListProps) => {
    const dispatch: ThunkDispatch<{}, {}, SkatesActions> = useDispatch();
    const {showLoading, hideLoading} = useContext(LoadingContext);

    useEffect(() => {
        const onBrandsFetch = async () => {
            await dispatch(fetchBrands());
        };

        showLoading();
        onBrandsFetch().then(hideLoading);
    }, [dispatch, hideLoading, showLoading]);

    const onDeleteClicked = async (e: React.MouseEvent<HTMLSpanElement, MouseEvent>, uuid: string) => {
        e.preventDefault();
        await dispatch(deleteBrand(uuid)).then(async () => {
            await dispatch(fetchBrands());
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
                                    <TableCell align="right">Brand</TableCell>
                                    <TableCell align="right">UUID</TableCell>
                                    <TableCell align="right">Actions</TableCell>
                                </TableRow>
                            </TableHead>
                            <TableBody>
                                {brands.map((b) => (
                                    <TableRow
                                        key={b.id}
                                        sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                    >
                                        <TableCell component="th" scope="row">
                                            {b.id}
                                        </TableCell>
                                        <TableCell align="right">{b.brand}</TableCell>
                                        <TableCell align="right">{b.uuid}</TableCell>
                                        <TableCell align="right">{
                                            <span className="actionIcon" onClick={(e) => onDeleteClicked(e, b.uuid)}>
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
        skates: BrandListProps
    }
}): BrandListProps => ({
    error: state.skates.skates.error,
    brands: state.skates.skates.brands
});

export default connect(mapStateToProps)(BrandsList);