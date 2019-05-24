import React from 'react';
import InfiniteScroll from 'react-infinite-scroller';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAllAction, TextFormat, getSortState, IPaginationBaseState } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities, reset } from './cliente.reducer';
import { ICliente } from 'app/shared/model/cliente.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

export interface IClienteProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export type IClienteState = IPaginationBaseState;

export class Cliente extends React.Component<IClienteProps, IClienteState> {
  state: IClienteState = {
    ...getSortState(this.props.location, ITEMS_PER_PAGE)
  };

  componentDidMount() {
    this.reset();
  }

  componentDidUpdate() {
    if (this.props.updateSuccess) {
      this.reset();
    }
  }

  reset = () => {
    this.props.reset();
    this.setState({ activePage: 1 }, () => {
      this.getEntities();
    });
  };

  handleLoadMore = () => {
    if (window.pageYOffset > 0) {
      this.setState({ activePage: this.state.activePage + 1 }, () => this.getEntities());
    }
  };

  sort = prop => () => {
    this.setState(
      {
        order: this.state.order === 'asc' ? 'desc' : 'asc',
        sort: prop
      },
      () => {
        this.reset();
      }
    );
  };

  getEntities = () => {
    const { activePage, itemsPerPage, sort, order } = this.state;
    this.props.getEntities(activePage - 1, itemsPerPage, `${sort},${order}`);
  };

  render() {
    const { clienteList, match } = this.props;
    return (
      <div>
        <h2 id="cliente-heading">
          <Translate contentKey="testeApp.cliente.home.title">Clientes</Translate>
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="testeApp.cliente.home.createLabel">Create new Cliente</Translate>
          </Link>
        </h2>
        <div className="table-responsive">
          <InfiniteScroll
            pageStart={this.state.activePage}
            loadMore={this.handleLoadMore}
            hasMore={this.state.activePage - 1 < this.props.links.next}
            loader={<div className="loader">Loading ...</div>}
            threshold={0}
            initialLoad={false}
          >
            <Table responsive>
              <thead>
                <tr>
                  <th className="hand" onClick={this.sort('id')}>
                    <Translate contentKey="global.field.id">ID</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('tipo')}>
                    <Translate contentKey="testeApp.cliente.tipo">Tipo</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('nome')}>
                    <Translate contentKey="testeApp.cliente.nome">Nome</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('rg')}>
                    <Translate contentKey="testeApp.cliente.rg">Rg</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('cpf')}>
                    <Translate contentKey="testeApp.cliente.cpf">Cpf</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('cfdf')}>
                    <Translate contentKey="testeApp.cliente.cfdf">Cfdf</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('cnpj')}>
                    <Translate contentKey="testeApp.cliente.cnpj">Cnpj</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('dataNascimento')}>
                    <Translate contentKey="testeApp.cliente.dataNascimento">Data Nascimento</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('dataCriacao')}>
                    <Translate contentKey="testeApp.cliente.dataCriacao">Data Criacao</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('dataCadastro')}>
                    <Translate contentKey="testeApp.cliente.dataCadastro">Data Cadastro</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('profissao')}>
                    <Translate contentKey="testeApp.cliente.profissao">Profissao</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('email')}>
                    <Translate contentKey="testeApp.cliente.email">Email</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('ddd')}>
                    <Translate contentKey="testeApp.cliente.ddd">Ddd</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('telefone')}>
                    <Translate contentKey="testeApp.cliente.telefone">Telefone</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('cep')}>
                    <Translate contentKey="testeApp.cliente.cep">Cep</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('logradouro')}>
                    <Translate contentKey="testeApp.cliente.logradouro">Logradouro</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('localidade')}>
                    <Translate contentKey="testeApp.cliente.localidade">Localidade</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('bairro')}>
                    <Translate contentKey="testeApp.cliente.bairro">Bairro</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('complemento')}>
                    <Translate contentKey="testeApp.cliente.complemento">Complemento</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('uf')}>
                    <Translate contentKey="testeApp.cliente.uf">Uf</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('numero')}>
                    <Translate contentKey="testeApp.cliente.numero">Numero</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('pontosReferenciaEndereco')}>
                    <Translate contentKey="testeApp.cliente.pontosReferenciaEndereco">Pontos Referencia Endereco</Translate>{' '}
                    <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('estacaoMetroMaisProxima')}>
                    <Translate contentKey="testeApp.cliente.estacaoMetroMaisProxima">Estacao Metro Mais Proxima</Translate>{' '}
                    <FontAwesomeIcon icon="sort" />
                  </th>
                  <th />
                </tr>
              </thead>
              <tbody>
                {clienteList.map((cliente, i) => (
                  <tr key={`entity-${i}`}>
                    <td>
                      <Button tag={Link} to={`${match.url}/${cliente.id}`} color="link" size="sm">
                        {cliente.id}
                      </Button>
                    </td>
                    <td>
                      <Translate contentKey={`testeApp.TipoPessoa.${cliente.tipo}`} />
                    </td>
                    <td>{cliente.nome}</td>
                    <td>{cliente.rg}</td>
                    <td>{cliente.cpf}</td>
                    <td>{cliente.cfdf}</td>
                    <td>{cliente.cnpj}</td>
                    <td>
                      <TextFormat type="date" value={cliente.dataNascimento} format={APP_LOCAL_DATE_FORMAT} />
                    </td>
                    <td>
                      <TextFormat type="date" value={cliente.dataCriacao} format={APP_LOCAL_DATE_FORMAT} />
                    </td>
                    <td>
                      <TextFormat type="date" value={cliente.dataCadastro} format={APP_LOCAL_DATE_FORMAT} />
                    </td>
                    <td>{cliente.profissao}</td>
                    <td>{cliente.email}</td>
                    <td>{cliente.ddd}</td>
                    <td>{cliente.telefone}</td>
                    <td>{cliente.cep}</td>
                    <td>{cliente.logradouro}</td>
                    <td>{cliente.localidade}</td>
                    <td>{cliente.bairro}</td>
                    <td>{cliente.complemento}</td>
                    <td>
                      <Translate contentKey={`testeApp.UF.${cliente.uf}`} />
                    </td>
                    <td>{cliente.numero}</td>
                    <td>{cliente.pontosReferenciaEndereco}</td>
                    <td>{cliente.estacaoMetroMaisProxima}</td>
                    <td className="text-right">
                      <div className="btn-group flex-btn-group-container">
                        <Button tag={Link} to={`${match.url}/${cliente.id}`} color="info" size="sm">
                          <FontAwesomeIcon icon="eye" />{' '}
                          <span className="d-none d-md-inline">
                            <Translate contentKey="entity.action.view">View</Translate>
                          </span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${cliente.id}/edit`} color="primary" size="sm">
                          <FontAwesomeIcon icon="pencil-alt" />{' '}
                          <span className="d-none d-md-inline">
                            <Translate contentKey="entity.action.edit">Edit</Translate>
                          </span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${cliente.id}/delete`} color="danger" size="sm">
                          <FontAwesomeIcon icon="trash" />{' '}
                          <span className="d-none d-md-inline">
                            <Translate contentKey="entity.action.delete">Delete</Translate>
                          </span>
                        </Button>
                      </div>
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>
          </InfiniteScroll>
        </div>
      </div>
    );
  }
}

const mapStateToProps = ({ cliente }: IRootState) => ({
  clienteList: cliente.entities,
  totalItems: cliente.totalItems,
  links: cliente.links,
  entity: cliente.entity,
  updateSuccess: cliente.updateSuccess
});

const mapDispatchToProps = {
  getEntities,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Cliente);
