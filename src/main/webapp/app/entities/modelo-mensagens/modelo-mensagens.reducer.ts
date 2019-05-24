import axios from 'axios';
import { ICrudGetAction, ICrudGetAllAction, ICrudPutAction, ICrudDeleteAction } from 'react-jhipster';

import { cleanEntity } from 'app/shared/util/entity-utils';
import { REQUEST, SUCCESS, FAILURE } from 'app/shared/reducers/action-type.util';

import { IModeloMensagens, defaultValue } from 'app/shared/model/modelo-mensagens.model';

export const ACTION_TYPES = {
  FETCH_MODELOMENSAGENS_LIST: 'modeloMensagens/FETCH_MODELOMENSAGENS_LIST',
  FETCH_MODELOMENSAGENS: 'modeloMensagens/FETCH_MODELOMENSAGENS',
  CREATE_MODELOMENSAGENS: 'modeloMensagens/CREATE_MODELOMENSAGENS',
  UPDATE_MODELOMENSAGENS: 'modeloMensagens/UPDATE_MODELOMENSAGENS',
  DELETE_MODELOMENSAGENS: 'modeloMensagens/DELETE_MODELOMENSAGENS',
  RESET: 'modeloMensagens/RESET'
};

const initialState = {
  loading: false,
  errorMessage: null,
  entities: [] as ReadonlyArray<IModeloMensagens>,
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false
};

export type ModeloMensagensState = Readonly<typeof initialState>;

// Reducer

export default (state: ModeloMensagensState = initialState, action): ModeloMensagensState => {
  switch (action.type) {
    case REQUEST(ACTION_TYPES.FETCH_MODELOMENSAGENS_LIST):
    case REQUEST(ACTION_TYPES.FETCH_MODELOMENSAGENS):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        loading: true
      };
    case REQUEST(ACTION_TYPES.CREATE_MODELOMENSAGENS):
    case REQUEST(ACTION_TYPES.UPDATE_MODELOMENSAGENS):
    case REQUEST(ACTION_TYPES.DELETE_MODELOMENSAGENS):
      return {
        ...state,
        errorMessage: null,
        updateSuccess: false,
        updating: true
      };
    case FAILURE(ACTION_TYPES.FETCH_MODELOMENSAGENS_LIST):
    case FAILURE(ACTION_TYPES.FETCH_MODELOMENSAGENS):
    case FAILURE(ACTION_TYPES.CREATE_MODELOMENSAGENS):
    case FAILURE(ACTION_TYPES.UPDATE_MODELOMENSAGENS):
    case FAILURE(ACTION_TYPES.DELETE_MODELOMENSAGENS):
      return {
        ...state,
        loading: false,
        updating: false,
        updateSuccess: false,
        errorMessage: action.payload
      };
    case SUCCESS(ACTION_TYPES.FETCH_MODELOMENSAGENS_LIST):
      return {
        ...state,
        loading: false,
        totalItems: action.payload.headers['x-total-count'],
        entities: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.FETCH_MODELOMENSAGENS):
      return {
        ...state,
        loading: false,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.CREATE_MODELOMENSAGENS):
    case SUCCESS(ACTION_TYPES.UPDATE_MODELOMENSAGENS):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: action.payload.data
      };
    case SUCCESS(ACTION_TYPES.DELETE_MODELOMENSAGENS):
      return {
        ...state,
        updating: false,
        updateSuccess: true,
        entity: {}
      };
    case ACTION_TYPES.RESET:
      return {
        ...initialState
      };
    default:
      return state;
  }
};

const apiUrl = 'api/modelo-mensagens';

// Actions

export const getEntities: ICrudGetAllAction<IModeloMensagens> = (page, size, sort) => {
  const requestUrl = `${apiUrl}${sort ? `?page=${page}&size=${size}&sort=${sort}` : ''}`;
  return {
    type: ACTION_TYPES.FETCH_MODELOMENSAGENS_LIST,
    payload: axios.get<IModeloMensagens>(`${requestUrl}${sort ? '&' : '?'}cacheBuster=${new Date().getTime()}`)
  };
};

export const getEntity: ICrudGetAction<IModeloMensagens> = id => {
  const requestUrl = `${apiUrl}/${id}`;
  return {
    type: ACTION_TYPES.FETCH_MODELOMENSAGENS,
    payload: axios.get<IModeloMensagens>(requestUrl)
  };
};

export const createEntity: ICrudPutAction<IModeloMensagens> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.CREATE_MODELOMENSAGENS,
    payload: axios.post(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const updateEntity: ICrudPutAction<IModeloMensagens> = entity => async dispatch => {
  const result = await dispatch({
    type: ACTION_TYPES.UPDATE_MODELOMENSAGENS,
    payload: axios.put(apiUrl, cleanEntity(entity))
  });
  dispatch(getEntities());
  return result;
};

export const deleteEntity: ICrudDeleteAction<IModeloMensagens> = id => async dispatch => {
  const requestUrl = `${apiUrl}/${id}`;
  const result = await dispatch({
    type: ACTION_TYPES.DELETE_MODELOMENSAGENS,
    payload: axios.delete(requestUrl)
  });
  dispatch(getEntities());
  return result;
};

export const reset = () => ({
  type: ACTION_TYPES.RESET
});
