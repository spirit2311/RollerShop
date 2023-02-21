import {createContext} from "react";

const LoadingContext = createContext({
    loading: false,
    showLoading: (): void => {},
    hideLoading: (): void => {}
});

export default LoadingContext;