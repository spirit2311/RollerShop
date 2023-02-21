import {RawBrand, RawDiscipline, Skate} from "../types";
import {SkatesActionType} from "./constants";

export interface SkatesFetchAction {
    skates: Skate[];
    type: SkatesActionType.FETCH_SKATES;
}

export interface SkatesSelectAction {
    selectedSkate: Skate;
    type: SkatesActionType.SELECT_SKATE;
}

export interface SearchForSelectedSkatesFailed {
    error: string;
    type: SkatesActionType.SEARCH_FOR_SKATES_FAILED;
}

export interface SearchForSkateAction {
    selectedSkate: Skate;
    type: SkatesActionType.SEARCH_FOR_SKATE;
}

export interface CreateSkateAction {
    skateCreatedStatus: number | null;
    type: SkatesActionType.CREATE_SKATE;
}

export interface CreateSkateFailedAction {
    error: string;
    type: SkatesActionType.CREATE_SKATE_FAILED;
}

export interface CreateDisciplineAction {
    disciplineCreatedStatus: number | null;
    type: SkatesActionType.CREATE_DISCIPLINE;
}

export interface CreateDisciplineFailedAction {
    error: string;
    type: SkatesActionType.CREATE_DISCIPLINE_FAILED;
}

export interface CreateBrandAction {
    brandCreatedStatus: number | null;
    type: SkatesActionType.CREATE_BRAND;
}

export interface CreateBrandFailedAction {
    error: string;
    type: SkatesActionType.CREATE_BRAND_FAILED;
}

export interface DeleteDiscipline {
    type: SkatesActionType.DELETE_DISCIPLINE;
}

export interface DeleteBrand {
    type: SkatesActionType.DELETE_BRAND;
}

export interface DeleteSkate {
    type: SkatesActionType.DELETE_SKATE;
}

export interface UpdateSkateAction {
    skateUpdatedStatus: number | null;
    type: SkatesActionType.UPDATE_SKATE;
}

export interface UpdateSkateFailedAction {
    error: string;
    type: SkatesActionType.UPDATE_SKATE_FAILED;
}

export interface DisciplinesFetchAction {
    disciplines: RawDiscipline[];
    type: SkatesActionType.FETCH_DISCIPLINES;
}

export interface BrandsFetchAction {
    brands: RawBrand[];
    type: SkatesActionType.FETCH_BRANDS;
}

export type SkatesActions =
    SkatesFetchAction
    | SkatesSelectAction
    | SearchForSkateAction
    | SearchForSelectedSkatesFailed
    | CreateSkateFailedAction
    | CreateSkateAction
    | CreateDisciplineAction
    | CreateDisciplineFailedAction
    | CreateBrandAction
    | CreateBrandFailedAction
    | DeleteDiscipline
    | DeleteBrand
    | DeleteSkate
    | UpdateSkateAction
    | UpdateSkateFailedAction
    | DisciplinesFetchAction
    | BrandsFetchAction;
