import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAction, TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './cliente.reducer';
import { ICliente } from 'app/shared/model/cliente.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IClienteDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export class ClienteDetail extends React.Component<IClienteDetailProps> {
  componentDidMount() {
    this.props.getEntity(this.props.match.params.id);
  }

  render() {
    const { clienteEntity } = this.props;
    return (
      <Row>
        <Col md="8">
          <h2>
            <Translate contentKey="testeApp.cliente.detail.title">Cliente</Translate> [<b>{clienteEntity.id}</b>]
          </h2>
          <dl className="jh-entity-details">
            <dt>
              <span id="tipo">
                <Translate contentKey="testeApp.cliente.tipo">Tipo</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.tipo}</dd>
            <dt>
              <span id="nome">
                <Translate contentKey="testeApp.cliente.nome">Nome</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.nome}</dd>
            <dt>
              <span id="rg">
                <Translate contentKey="testeApp.cliente.rg">Rg</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.rg}</dd>
            <dt>
              <span id="cpf">
                <Translate contentKey="testeApp.cliente.cpf">Cpf</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.cpf}</dd>
            <dt>
              <span id="cfdf">
                <Translate contentKey="testeApp.cliente.cfdf">Cfdf</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.cfdf}</dd>
            <dt>
              <span id="cnpj">
                <Translate contentKey="testeApp.cliente.cnpj">Cnpj</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.cnpj}</dd>
            <dt>
              <span id="dataNascimento">
                <Translate contentKey="testeApp.cliente.dataNascimento">Data Nascimento</Translate>
              </span>
            </dt>
            <dd>
              <TextFormat value={clienteEntity.dataNascimento} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="dataCriacao">
                <Translate contentKey="testeApp.cliente.dataCriacao">Data Criacao</Translate>
              </span>
            </dt>
            <dd>
              <TextFormat value={clienteEntity.dataCriacao} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="dataCadastro">
                <Translate contentKey="testeApp.cliente.dataCadastro">Data Cadastro</Translate>
              </span>
            </dt>
            <dd>
              <TextFormat value={clienteEntity.dataCadastro} type="date" format={APP_LOCAL_DATE_FORMAT} />
            </dd>
            <dt>
              <span id="profissao">
                <Translate contentKey="testeApp.cliente.profissao">Profissao</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.profissao}</dd>
            <dt>
              <span id="email">
                <Translate contentKey="testeApp.cliente.email">Email</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.email}</dd>
            <dt>
              <span id="ddd">
                <Translate contentKey="testeApp.cliente.ddd">Ddd</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.ddd}</dd>
            <dt>
              <span id="telefone">
                <Translate contentKey="testeApp.cliente.telefone">Telefone</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.telefone}</dd>
            <dt>
              <span id="cep">
                <Translate contentKey="testeApp.cliente.cep">Cep</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.cep}</dd>
            <dt>
              <span id="logradouro">
                <Translate contentKey="testeApp.cliente.logradouro">Logradouro</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.logradouro}</dd>
            <dt>
              <span id="localidade">
                <Translate contentKey="testeApp.cliente.localidade">Localidade</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.localidade}</dd>
            <dt>
              <span id="bairro">
                <Translate contentKey="testeApp.cliente.bairro">Bairro</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.bairro}</dd>
            <dt>
              <span id="complemento">
                <Translate contentKey="testeApp.cliente.complemento">Complemento</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.complemento}</dd>
            <dt>
              <span id="uf">
                <Translate contentKey="testeApp.cliente.uf">Uf</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.uf}</dd>
            <dt>
              <span id="numero">
                <Translate contentKey="testeApp.cliente.numero">Numero</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.numero}</dd>
            <dt>
              <span id="pontosReferenciaEndereco">
                <Translate contentKey="testeApp.cliente.pontosReferenciaEndereco">Pontos Referencia Endereco</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.pontosReferenciaEndereco}</dd>
            <dt>
              <span id="estacaoMetroMaisProxima">
                <Translate contentKey="testeApp.cliente.estacaoMetroMaisProxima">Estacao Metro Mais Proxima</Translate>
              </span>
            </dt>
            <dd>{clienteEntity.estacaoMetroMaisProxima}</dd>
          </dl>
          <Button tag={Link} to="/entity/cliente" replace color="info">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>
          &nbsp;
          <Button tag={Link} to={`/entity/cliente/${clienteEntity.id}/edit`} replace color="primary">
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

const mapStateToProps = ({ cliente }: IRootState) => ({
  clienteEntity: cliente.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ClienteDetail);
