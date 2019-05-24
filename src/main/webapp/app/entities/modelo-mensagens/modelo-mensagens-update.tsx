import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './modelo-mensagens.reducer';
import { IModeloMensagens } from 'app/shared/model/modelo-mensagens.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IModeloMensagensUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface IModeloMensagensUpdateState {
  isNew: boolean;
}

export class ModeloMensagensUpdate extends React.Component<IModeloMensagensUpdateProps, IModeloMensagensUpdateState> {
  constructor(props) {
    super(props);
    this.state = {
      isNew: !this.props.match.params || !this.props.match.params.id
    };
  }

  componentWillUpdate(nextProps, nextState) {
    if (nextProps.updateSuccess !== this.props.updateSuccess && nextProps.updateSuccess) {
      this.handleClose();
    }
  }

  componentDidMount() {
    if (this.state.isNew) {
      this.props.reset();
    } else {
      this.props.getEntity(this.props.match.params.id);
    }
  }

  saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const { modeloMensagensEntity } = this.props;
      const entity = {
        ...modeloMensagensEntity,
        ...values
      };

      if (this.state.isNew) {
        this.props.createEntity(entity);
      } else {
        this.props.updateEntity(entity);
      }
    }
  };

  handleClose = () => {
    this.props.history.push('/entity/modelo-mensagens');
  };

  render() {
    const { modeloMensagensEntity, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="testeApp.modeloMensagens.home.createOrEditLabel">
              <Translate contentKey="testeApp.modeloMensagens.home.createOrEditLabel">Create or edit a ModeloMensagens</Translate>
            </h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : modeloMensagensEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="modelo-mensagens-id">
                      <Translate contentKey="global.field.id">ID</Translate>
                    </Label>
                    <AvInput id="modelo-mensagens-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="tituloLabel" for="modelo-mensagens-titulo">
                    <Translate contentKey="testeApp.modeloMensagens.titulo">Titulo</Translate>
                  </Label>
                  <AvField
                    id="modelo-mensagens-titulo"
                    type="text"
                    name="titulo"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 3, errorMessage: translate('entity.validation.minlength', { min: 3 }) },
                      maxLength: { value: 250, errorMessage: translate('entity.validation.maxlength', { max: 250 }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="mensagemLabel" for="modelo-mensagens-mensagem">
                    <Translate contentKey="testeApp.modeloMensagens.mensagem">Mensagem</Translate>
                  </Label>
                  <AvField
                    id="modelo-mensagens-mensagem"
                    type="text"
                    name="mensagem"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 3, errorMessage: translate('entity.validation.minlength', { min: 3 }) },
                      maxLength: { value: 250, errorMessage: translate('entity.validation.maxlength', { max: 250 }) }
                    }}
                  />
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/modelo-mensagens" replace color="info">
                  <FontAwesomeIcon icon="arrow-left" />
                  &nbsp;
                  <span className="d-none d-md-inline">
                    <Translate contentKey="entity.action.back">Back</Translate>
                  </span>
                </Button>
                &nbsp;
                <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                  <FontAwesomeIcon icon="save" />
                  &nbsp;
                  <Translate contentKey="entity.action.save">Save</Translate>
                </Button>
              </AvForm>
            )}
          </Col>
        </Row>
      </div>
    );
  }
}

const mapStateToProps = (storeState: IRootState) => ({
  modeloMensagensEntity: storeState.modeloMensagens.entity,
  loading: storeState.modeloMensagens.loading,
  updating: storeState.modeloMensagens.updating,
  updateSuccess: storeState.modeloMensagens.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ModeloMensagensUpdate);
