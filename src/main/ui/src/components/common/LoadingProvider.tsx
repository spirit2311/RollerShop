import * as React from 'react';
import {useState} from 'react';
import LoadingContext from './LoadingContext';

const LoadingProvider = ({ children }: { children: JSX.Element | JSX.Element[] }) => {
    const showLoading = (): void => {
        toggleLoading(prevState => {
            return {
                ...prevState,
                loading: true
            }
        })
    };

    const hideLoading = (): void => {
        toggleLoading(prevState => {
            return {
                ...prevState,
                loading: false
            }
        })
    };

    const loadingState = {
        loading: false,
        showLoading,
        hideLoading
    };

    const [loading, toggleLoading] = useState(loadingState);

    return (
        <LoadingContext.Provider value={loading}>
            {children}
        </LoadingContext.Provider>
    );
};

export default LoadingProvider;