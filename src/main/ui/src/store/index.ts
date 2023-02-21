import {configureStore} from '@reduxjs/toolkit';
import skates from './../reducers';

export default configureStore({
    reducer: {
        skates
    }
});