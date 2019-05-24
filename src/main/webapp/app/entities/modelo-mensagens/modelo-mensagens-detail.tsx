import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './modelo-mensagens.reducer';
import { IModeloMensagens } from 'app/shared/model/modelo-mensagens.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IModeloMensagensDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class ModeloMensagensDetail extends React.Component<IModeloMensagensDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { modeloMensagensEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="testeApp.modeloMensagens.detail.title">ModeloMensagens</Translate> [<b>{modeloMensagensEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="titulo">
                <Translate contentKey="testeApp.modeloMensagens.titulo">Titulo</Translate>
              </span>
            </dt>
            <dd>{modeloMensagensEntity.titulo}</dd>
            <dt>
              <span id="mensagem">
                <Translate contentKey="testeApp.modeloMensagens.mensagem">Mensagem</Translate>
              </span>
            </dt>
            <dd>{modeloMensagensEntity.mensagem}</dd>
          </dl>
          <Button tag={Link} to="/entity/modelo-mensagens" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/modelo-mensagens/${modeloMensagensEntity.id}/edit`} replace color="primary">
            <FontAwesomeIcon icon="pencil-alt" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.edit">Edit</Translate>
            </span>
          </Button>
        </Col>
      </Row>
    );
  }
}

const mapStateToProps = ({ modeloMensagens }: IRootState) => ({
  modeloMensagensEntity: modeloMensagens.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ModeloMensagensDetail);
