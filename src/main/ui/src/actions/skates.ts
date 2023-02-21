import {ThunkAction, ThunkDispatch} from "@reduxjs/toolkit";
import {Skate, SkateJsonModel} from "../types";
import apis from "../apis";
import {SkatesActionType} from "./constants";
import {
    CreateBrandAction,
    CreateBrandFailedAction,
    CreateDisciplineAction,
    CreateDisciplineFailedAction,
    CreateSkateAction,
    CreateSkateFailedAction,
    SkatesActions,
    SkatesSelectAction,
    UpdateSkateAction,
    UpdateSkateFailedAction
} from "./types";

export function fetchSkates(): ThunkAction<Promise<void>, {}, {}, SkatesActions> {
    return async (dispatch: ThunkDispatch<{}, {}, SkatesActions>): Promise<void> => {
        try {
            const res = await apis.get(`/skates`).catch(e => {
                dispatch(setSelectedSkatesError(e.message));
            });
            if (res) {
                dispatch(setSelectedSkatesError(''));
                dispatch({
                    skates: res.data,
                    type: SkatesActionType.FETCH_SKATES
                });
            }
        } catch (e) {
            console.error(e);
        }
    }
}

export function fetchSkateById(id: string): ThunkAction<Promise<void>, {}, {}, SkatesActions> {
    return async (dispatch: ThunkDispatch<{}, {}, SkatesActions>): Promise<void> => {
        try {
            const res = await apis.get(`/skates/${id}`).catch(e => {
                dispatch(setSelectedSkatesError(e.message));
            });
            if (res) {
                dispatch(setSelectedSkatesError(''));
                dispatch({
                    selectedSkate: res.data,
                    type: SkatesActionType.SEARCH_FOR_SKATE
                });
            }
        } catch (e) {
            console.error(e);
        }
    }
}

export function createSkate({
                                brandId,
                                disciplineId,
                                model,
                                price,
                                description,
                                year
                            }: SkateJsonModel): ThunkAction<Promise<void>, {}, {}, SkatesActions> {
    return async (dispatch: ThunkDispatch<{}, {}, SkatesActions>): Promise<void> => {
        try {
            dispatch(setSkateCreatedStatus(null));
            const res = await apis.post(`/skates`, {
                brandId,
                disciplineId,
                model,
                price,
                description,
                year
            }).catch(e => {
                dispatch(setSkateCreatedStatus(null));
                dispatch(setCreateSkateError(e.message));
            });
            if (res) {
                dispatch(setSkateCreatedStatus(res.status));
                dispatch(setCreateSkateError(''));
            }
        } catch (e) {
            dispatch(setSkateCreatedStatus(null));
            dispatch(setCreateSkateError(e.message));
            console.error(e);
        }
    }
}

export function createDiscipline(discipline: string): ThunkAction<Promise<void>, {}, {}, SkatesActions> {
    return async (dispatch: ThunkDispatch<{}, {}, SkatesActions>): Promise<void> => {
        try {
            dispatch(setDisciplineCreatedStatus( null));
            const res = await apis.post(`/disciplines`, {
                discipline
            }).catch(e => {
                dispatch(setDisciplineCreatedStatus(null));
                dispatch(setCreateDisciplineError(e.message));
            });
            if (res) {
                dispatch(setDisciplineCreatedStatus(res.status));
                dispatch(setCreateDisciplineError(''));
            }
        } catch (e) {
            dispatch(setDisciplineCreatedStatus(null));
            dispatch(setCreateDisciplineError(e.message));
            console.error(e);
        }
    }
}

export function createBrand(brand: string): ThunkAction<Promise<void>, {}, {}, SkatesActions> {
    return async (dispatch: ThunkDispatch<{}, {}, SkatesActions>): Promise<void> => {
        try {
            dispatch(setBrandCreatedStatus( null));
            const res = await apis.post(`/brands`, {
                brand
            }).catch(e => {
                dispatch(setBrandCreatedStatus(null));
                dispatch(setCreateBrandError(e.message));
            });
            if (res) {
                dispatch(setBrandCreatedStatus(res.status));
                dispatch(setCreateBrandError(''));
            }
        } catch (e) {
            dispatch(setBrandCreatedStatus(null));
            dispatch(setCreateBrandError(e.message));
            console.error(e);
        }
    }
}

export function deleteDiscipline(id: string): ThunkAction<Promise<void>, {}, {}, SkatesActions> {
    return async (dispatch: ThunkDispatch<{}, {}, SkatesActions>): Promise<void> => {
        try {
            const res = await apis.delete(`/disciplines/${id}`).catch(e => {
                debugger;
                dispatch(setCreateDisciplineError(e.message));
            });
            if (res) {
                debugger;
                dispatch(setCreateDisciplineError(''));
            }
        } catch (e) {
            console.error(e);
            dispatch(setCreateDisciplineError(e.message));
        }
    }
}

export function deleteBrand(id: string): ThunkAction<Promise<void>, {}, {}, SkatesActions> {
    return async (dispatch: ThunkDispatch<{}, {}, SkatesActions>): Promise<void> => {
        try {
            const res = await apis.delete(`/brands/${id}`).catch(e => {
                dispatch(setCreateBrandError(e.message));
            });
            if (res) {
                dispatch(setCreateBrandError(''));
            }
        } catch (e) {
            console.error(e);
            dispatch(setCreateBrandError(''));
        }
    }
}

export function updateSkate(id: string, {
                                brandId,
                                disciplineId,
                                model,
                                price,
                                description,
                                year
                            }: SkateJsonModel): ThunkAction<Promise<void>, {}, {}, SkatesActions> {
    return async (dispatch: ThunkDispatch<{}, {}, SkatesActions>): Promise<void> => {
        try {
            dispatch(setSkateUpdatedStatus(null));
            const res = await apis.put(`/skates/${id}`, {
                brandId,
                disciplineId,
                model,
                price,
                description,
                year
            }).catch(e => {
                dispatch(setSkateUpdatedStatus(null));
                dispatch(setUpdateSkateError(e.message));
            });
            if (res) {
                dispatch(setSkateUpdatedStatus(res.status));
                dispatch(setUpdateSkateError(''));
            }
        } catch (e) {
            dispatch(setSkateUpdatedStatus(null));
            dispatch(setUpdateSkateError(e.message));
            console.error(e);
        }
    }
}

export function deleteSkate(id: string): ThunkAction<Promise<void>, {}, {}, SkatesActions> {
    return async (_dispatch: ThunkDispatch<{}, {}, SkatesActions>): Promise<void> => {
        try {
            await apis.delete(`/skates/${id}`);
        } catch (e) {
            console.error(e);
        }
    }
}

export const selectSkate = (selectedSkate: Skate): SkatesSelectAction => ({
    type: SkatesActionType.SELECT_SKATE,
    selectedSkate
});

export const setSelectedSkatesError = (error: string): SkatesActions => ({
    type: SkatesActionType.SEARCH_FOR_SKATES_FAILED,
    error
});

export const setCreateSkateError = (error: string): CreateSkateFailedAction => ({
    type: SkatesActionType.CREATE_SKATE_FAILED,
    error
});

export const setSkateCreatedStatus = (skateCreatedStatus: number | null): CreateSkateAction => ({
   type: SkatesActionType.CREATE_SKATE,
    skateCreatedStatus,
});

export const setCreateDisciplineError = (error: string): CreateDisciplineFailedAction => ({
    type: SkatesActionType.CREATE_DISCIPLINE_FAILED,
    error
});

export const setDisciplineCreatedStatus = (disciplineCreatedStatus: number | null): CreateDisciplineAction => ({
    type: SkatesActionType.CREATE_DISCIPLINE,
    disciplineCreatedStatus,
});

export const setCreateBrandError = (error: string): CreateBrandFailedAction => ({
    type: SkatesActionType.CREATE_BRAND_FAILED,
    error
});

export const setBrandCreatedStatus = (brandCreatedStatus: number | null): CreateBrandAction => ({
    type: SkatesActionType.CREATE_BRAND,
    brandCreatedStatus,
});

export const setUpdateSkateError = (error: string): UpdateSkateFailedAction => ({
    type: SkatesActionType.UPDATE_SKATE_FAILED,
    error
});

export const setSkateUpdatedStatus = (skateUpdatedStatus: number | null): UpdateSkateAction => ({
    type: SkatesActionType.UPDATE_SKATE,
    skateUpdatedStatus,
});

export function fetchDisciplines(): ThunkAction<Promise<void>, {}, {}, SkatesActions> {
    return async (dispatch: ThunkDispatch<{}, {}, SkatesActions>): Promise<void> => {
        try {
            const res = await apis.get(`/disciplines`);
            if (res) {
                dispatch({
                    disciplines: res.data,
                    type: SkatesActionType.FETCH_DISCIPLINES
                });
            }
        } catch (e) {
            console.error(e);
        }
    }
}

export function fetchBrands(): ThunkAction<Promise<void>, {}, {}, SkatesActions> {
    return async (dispatch: ThunkDispatch<{}, {}, SkatesActions>): Promise<void> => {
        try {
            const res = await apis.get(`/brands`);
            if (res) {
                dispatch({
                    brands: res.data,
                    type: SkatesActionType.FETCH_BRANDS
                });
            }
        } catch (e) {
            console.error(e);
        }
    }
}
