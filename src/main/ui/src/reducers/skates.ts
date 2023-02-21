import {RawBrand, RawDiscipline, Skate} from "../types";
import {SkatesActionType} from "../actions/constants";
import {SkatesActions} from "../actions/types";

export interface State {
  skates: Skate[];
  selectedSkate: Skate | null,
  skateCreatedStatus: number | null;
  disciplineCreatedStatus: number | null;
  brandCreatedStatus: number | null;
  skateUpdatedStatus: number | null;
  error: string
  disciplines: RawDiscipline[];
  brands: RawBrand[];
}

const INITIAL_STATE: State = {
  skates: [],
  selectedSkate: null,
  skateCreatedStatus: null,
  skateUpdatedStatus: null,
  disciplineCreatedStatus: null,
  brandCreatedStatus: null,
  error: '',
  disciplines: [],
  brands: [],
};

export default function skatesReducer(state: State = INITIAL_STATE, action: SkatesActions) {
  switch (action.type) {
    case SkatesActionType.FETCH_SKATES: {
      return {
        ...state,
        skates: action.skates,
      }
    }
    case SkatesActionType.SELECT_SKATE:
      return {
        ...state,
        selectedSkate: action.selectedSkate,
      };
    case SkatesActionType.SEARCH_FOR_SKATE:
      return {
        ...state,
        selectedSkate: action.selectedSkate,
      };
    case SkatesActionType.SEARCH_FOR_SKATES_FAILED:
      return {
        ...state,
        error: action.error
      };
    case SkatesActionType.CREATE_SKATE_FAILED:
      return {
        ...state,
        error: action.error
      };
    case SkatesActionType.CREATE_SKATE:
      return {
        ...state,
        skateCreatedStatus: action.skateCreatedStatus
      }
    case SkatesActionType.CREATE_DISCIPLINE:
      return {
        ...state,
        disciplineCreatedStatus: action.disciplineCreatedStatus
      }
    case SkatesActionType.CREATE_BRAND:
      return {
        ...state,
        brandCreatedStatus: action.brandCreatedStatus
      }
    case SkatesActionType.UPDATE_SKATE_FAILED:
      return {
        ...state,
        error: action.error
      };
    case SkatesActionType.UPDATE_SKATE:
      return {
        ...state,
        skateUpdatedStatus: action.skateUpdatedStatus,
      }
    case SkatesActionType.FETCH_DISCIPLINES:
      return {
        ...state,
        disciplines: action.disciplines,
      }
    case SkatesActionType.FETCH_BRANDS:
      return {
        ...state,
        brands: action.brands,
      }
    case SkatesActionType.CREATE_BRAND_FAILED:
      return {
        ...state,
        error: action.error
      };
    case SkatesActionType.CREATE_DISCIPLINE_FAILED:
      return {
        ...state,
        error: action.error
      };


    default:
      return state;
  }
}