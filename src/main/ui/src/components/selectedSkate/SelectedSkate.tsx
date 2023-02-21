import * as React from 'react';
import {useContext, useEffect} from 'react';
import {useDispatch, useSelector} from "react-redux";
import {useParams} from "react-router-dom";
import {ThunkDispatch} from "@reduxjs/toolkit";
import {fetchSkateById} from "../../actions/skates";
import LoadingContext from "../common/LoadingContext";
import SelectedSkateInfo from "./SelectedSkateInfo";
import SelectedSkateWrapper from "./SelectedSkateWrapper";
import {SkatesActions} from "../../actions/types";

const SelectedSkate = () => {
    const dispatch: ThunkDispatch<{}, {}, SkatesActions> = useDispatch();
    const params = useParams();
    const {selectedSkate} = useSelector(({skates}) => ({
        selectedSkate: skates.skates.selectedSkate,
    }));
    const { showLoading, hideLoading } = useContext(LoadingContext);

    useEffect(() => {
        const fetchSkate = async () => {
            await dispatch(fetchSkateById(params.id));
        };

        if (params.id && !selectedSkate) {
            showLoading();
            fetchSkate().then(hideLoading);
        }
    }, [hideLoading, showLoading, dispatch, params, selectedSkate]);

    return (
        selectedSkate && (
            <SelectedSkateWrapper>
                <SelectedSkateInfo
                    selectedSkate={selectedSkate}
                />
            </SelectedSkateWrapper>
        )
    );
};

export default SelectedSkate;