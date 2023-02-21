import React, {useContext, useEffect} from 'react';
import {Alert} from "@mui/material";
import SkatesListWrapper from "./SkatesListWrapper";
import {useDispatch, useSelector} from "react-redux";
import {ThunkDispatch} from "@reduxjs/toolkit";
import {fetchSkates} from "../../actions/skates";
import LoadingContext from "../common/LoadingContext";
import SkateItem from "./SkateItem";
import {Skate} from "../../types";
import {SkatesActions} from "../../actions/types";

const SkatesList = (): JSX.Element => {
    const skates = useSelector(({skates}) => {
        return skates.skates.skates;
    }) || [];
    const dispatch: ThunkDispatch<{}, {}, SkatesActions> = useDispatch();
    const {showLoading, hideLoading} = useContext(LoadingContext);

    useEffect(() => {
        const onSkatesFetch = async () => {
            await dispatch(fetchSkates());
        };

        showLoading();
        onSkatesFetch().then(hideLoading);
    }, [dispatch, hideLoading, showLoading]);

    return (
        <span>
            <SkatesListWrapper>
                {
                    skates.length ?
                        skates.map((s: Skate) => <SkateItem key={s.uuid} skate={s}/>) :
                        <Alert sx={{fontSize: '15px;'}} severity="info">No Skates Found</Alert>
                }
            </SkatesListWrapper>
        </span>
    );
};

export default SkatesList;