import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './diarista.reducer';
import { IDiarista } from 'app/shared/model/diarista.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IDiaristaDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class DiaristaDetail extends React.Component<IDiaristaDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { diaristaEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="testeApp.diarista.detail.title">Diarista</Translate> [<b>{diaristaEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="nome">
                <Translate contentKey="testeApp.diarista.nome">Nome</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.nome}</dd>
            <dt>
              <span id="rg">
                <Translate contentKey="testeApp.diarista.rg">Rg</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.rg}</dd>
            <dt>
              <span id="cpf">
                <Translate contentKey="testeApp.diarista.cpf">Cpf</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.cpf}</dd>
            <dt>
              <span id="cep">
                <Translate contentKey="testeApp.diarista.cep">Cep</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.cep}</dd>
            <dt>
              <span id="logradouro">
                <Translate contentKey="testeApp.diarista.logradouro">Logradouro</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.logradouro}</dd>
            <dt>
              <span id="localidade">
                <Translate contentKey="testeApp.diarista.localidade">Localidade</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.localidade}</dd>
            <dt>
              <span id="bairro">
                <Translate contentKey="testeApp.diarista.bairro">Bairro</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.bairro}</dd>
            <dt>
              <span id="uf">
                <Translate contentKey="testeApp.diarista.uf">Uf</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.uf}</dd>
            <dt>
              <span id="complemento">
                <Translate contentKey="testeApp.diarista.complemento">Complemento</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.complemento}</dd>
            <dt>
              <span id="numero">
                <Translate contentKey="testeApp.diarista.numero">Numero</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.numero}</dd>
            <dt>
              <span id="ddd">
                <Translate contentKey="testeApp.diarista.ddd">Ddd</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.ddd}</dd>
            <dt>
              <span id="telefone">
                <Translate contentKey="testeApp.diarista.telefone">Telefone</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.telefone}</dd>
            <dt>
              <span id="email">
                <Translate contentKey="testeApp.diarista.email">Email</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.email}</dd>
            <dt>
              <span id="nomeContato">
                <Translate contentKey="testeApp.diarista.nomeContato">Nome Contato</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.nomeContato}</dd>
            <dt>
              <span id="dddContato">
                <Translate contentKey="testeApp.diarista.dddContato">Ddd Contato</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.dddContato}</dd>
            <dt>
              <span id="telefoneContato">
                <Translate contentKey="testeApp.diarista.telefoneContato">Telefone Contato</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.telefoneContato}</dd>
            <dt>
              <span id="dataNascimento">
                <Translate contentKey="testeApp.diarista.dataNascimento">Data Nascimento</Translate>
              </span>
            </dt>
            <dd>
              <TextFormat value={diaristaEntity.dataNascimento} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="cargo">
                <Translate contentKey="testeApp.diarista.cargo">Cargo</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.cargo}</dd>
            <dt>
              <span id="dataAdmissao">
                <Translate contentKey="testeApp.diarista.dataAdmissao">Data Admissao</Translate>
              </span>
            </dt>
            <dd>
              <TextFormat value={diaristaEntity.dataAdmissao} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="dataSaida">
                <Translate contentKey="testeApp.diarista.dataSaida">Data Saida</Translate>
              </span>
            </dt>
            <dd>
              <TextFormat value={diaristaEntity.dataSaida} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="tamanhoCamisa">
                <Translate contentKey="testeApp.diarista.tamanhoCamisa">Tamanho Camisa</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.tamanhoCamisa}</dd>
            <dt>
              <span id="pis">
                <Translate contentKey="testeApp.diarista.pis">Pis</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.pis}</dd>
            <dt>
              <span id="cartaoCidadado">
                <Translate contentKey="testeApp.diarista.cartaoCidadado">Cartao Cidadado</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.cartaoCidadado}</dd>
            <dt>
              <span id="numeroTituloEleitor">
                <Translate contentKey="testeApp.diarista.numeroTituloEleitor">Numero Titulo Eleitor</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.numeroTituloEleitor}</dd>
            <dt>
              <span id="zonaTituloEleitor">
                <Translate contentKey="testeApp.diarista.zonaTituloEleitor">Zona Titulo Eleitor</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.zonaTituloEleitor}</dd>
            <dt>
              <span id="secaoTituloEleitor">
                <Translate contentKey="testeApp.diarista.secaoTituloEleitor">Secao Titulo Eleitor</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.secaoTituloEleitor}</dd>
            <dt>
              <span id="numeroCarteiraTrabalho">
                <Translate contentKey="testeApp.diarista.numeroCarteiraTrabalho">Numero Carteira Trabalho</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.numeroCarteiraTrabalho}</dd>
            <dt>
              <span id="serieCarteiraTrabalho">
                <Translate contentKey="testeApp.diarista.serieCarteiraTrabalho">Serie Carteira Trabalho</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.serieCarteiraTrabalho}</dd>
            <dt>
              <span id="ufCarteiraTrabalho">
                <Translate contentKey="testeApp.diarista.ufCarteiraTrabalho">Uf Carteira Trabalho</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.ufCarteiraTrabalho}</dd>
            <dt>
              <span id="nire">
                <Translate contentKey="testeApp.diarista.nire">Nire</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.nire}</dd>
            <dt>
              <span id="cnpj">
                <Translate contentKey="testeApp.diarista.cnpj">Cnpj</Translate>
              </span>
            </dt>
            <dd>{diaristaEntity.cnpj}</dd>
            <dt>
              <Translate contentKey="testeApp.diarista.cliente">Cliente</Translate>
            </dt>
            <dd>{diaristaEntity.clienteId ? diaristaEntity.clienteId : ''}</dd>
            <dt>
              <Translate contentKey="testeApp.diarista.cliente">Cliente</Translate>
            </dt>
            <dd>{diaristaEntity.clienteId ? diaristaEntity.clienteId : ''}</dd>
          </dl>
          <Button tag={Link} to="/entity/diarista" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/diarista/${diaristaEntity.id}/edit`} replace color="primary">
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

const mapStateToProps = ({ diarista }: IRootState) => ({
  diaristaEntity: diarista.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(DiaristaDetail);
