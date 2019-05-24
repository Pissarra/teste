import React from 'react';
import InfiniteScroll from 'react-infinite-scroller';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAllAction, TextFormat, getSortState, IPaginationBaseState } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities, reset } from './diarista.reducer';
import { IDiarista } from 'app/shared/model/diarista.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

export interface IDiaristaProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export type IDiaristaState = IPaginationBaseState;

export class Diarista extends React.Component<IDiaristaProps, IDiaristaState> {
  state: IDiaristaState = {
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
    const { diaristaList, match } = this.props;
    return (
      <div>
        <h2 id="diarista-heading">
          <Translate contentKey="testeApp.diarista.home.title">Diaristas</Translate>
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />
            &nbsp;
            <Translate contentKey="testeApp.diarista.home.createLabel">Create new Diarista</Translate>
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
                  <th className="hand" onClick={this.sort('nome')}>
                    <Translate contentKey="testeApp.diarista.nome">Nome</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('rg')}>
                    <Translate contentKey="testeApp.diarista.rg">Rg</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('cpf')}>
                    <Translate contentKey="testeApp.diarista.cpf">Cpf</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('cep')}>
                    <Translate contentKey="testeApp.diarista.cep">Cep</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('logradouro')}>
                    <Translate contentKey="testeApp.diarista.logradouro">Logradouro</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('localidade')}>
                    <Translate contentKey="testeApp.diarista.localidade">Localidade</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('bairro')}>
                    <Translate contentKey="testeApp.diarista.bairro">Bairro</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('uf')}>
                    <Translate contentKey="testeApp.diarista.uf">Uf</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('complemento')}>
                    <Translate contentKey="testeApp.diarista.complemento">Complemento</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('numero')}>
                    <Translate contentKey="testeApp.diarista.numero">Numero</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('ddd')}>
                    <Translate contentKey="testeApp.diarista.ddd">Ddd</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('telefone')}>
                    <Translate contentKey="testeApp.diarista.telefone">Telefone</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('email')}>
                    <Translate contentKey="testeApp.diarista.email">Email</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('nomeContato')}>
                    <Translate contentKey="testeApp.diarista.nomeContato">Nome Contato</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('dddContato')}>
                    <Translate contentKey="testeApp.diarista.dddContato">Ddd Contato</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('telefoneContato')}>
                    <Translate contentKey="testeApp.diarista.telefoneContato">Telefone Contato</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('dataNascimento')}>
                    <Translate contentKey="testeApp.diarista.dataNascimento">Data Nascimento</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('cargo')}>
                    <Translate contentKey="testeApp.diarista.cargo">Cargo</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('dataAdmissao')}>
                    <Translate contentKey="testeApp.diarista.dataAdmissao">Data Admissao</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('dataSaida')}>
                    <Translate contentKey="testeApp.diarista.dataSaida">Data Saida</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('tamanhoCamisa')}>
                    <Translate contentKey="testeApp.diarista.tamanhoCamisa">Tamanho Camisa</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('pis')}>
                    <Translate contentKey="testeApp.diarista.pis">Pis</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('cartaoCidadado')}>
                    <Translate contentKey="testeApp.diarista.cartaoCidadado">Cartao Cidadado</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('numeroTituloEleitor')}>
                    <Translate contentKey="testeApp.diarista.numeroTituloEleitor">Numero Titulo Eleitor</Translate>{' '}
                    <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('zonaTituloEleitor')}>
                    <Translate contentKey="testeApp.diarista.zonaTituloEleitor">Zona Titulo Eleitor</Translate>{' '}
                    <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('secaoTituloEleitor')}>
                    <Translate contentKey="testeApp.diarista.secaoTituloEleitor">Secao Titulo Eleitor</Translate>{' '}
                    <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('numeroCarteiraTrabalho')}>
                    <Translate contentKey="testeApp.diarista.numeroCarteiraTrabalho">Numero Carteira Trabalho</Translate>{' '}
                    <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('serieCarteiraTrabalho')}>
                    <Translate contentKey="testeApp.diarista.serieCarteiraTrabalho">Serie Carteira Trabalho</Translate>{' '}
                    <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('ufCarteiraTrabalho')}>
                    <Translate contentKey="testeApp.diarista.ufCarteiraTrabalho">Uf Carteira Trabalho</Translate>{' '}
                    <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('nire')}>
                    <Translate contentKey="testeApp.diarista.nire">Nire</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th className="hand" onClick={this.sort('cnpj')}>
                    <Translate contentKey="testeApp.diarista.cnpj">Cnpj</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th>
                    <Translate contentKey="testeApp.diarista.cliente">Cliente</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th>
                    <Translate contentKey="testeApp.diarista.cliente">Cliente</Translate> <FontAwesomeIcon icon="sort" />
                  </th>
                  <th />
                </tr>
              </thead>
              <tbody>
                {diaristaList.map((diarista, i) => (
                  <tr key={`entity-${i}`}>
                    <td>
                      <Button tag={Link} to={`${match.url}/${diarista.id}`} color="link" size="sm">
                        {diarista.id}
                      </Button>
                    </td>
                    <td>{diarista.nome}</td>
                    <td>{diarista.rg}</td>
                    <td>{diarista.cpf}</td>
                    <td>{diarista.cep}</td>
                    <td>{diarista.logradouro}</td>
                    <td>{diarista.localidade}</td>
                    <td>{diarista.bairro}</td>
                    <td>
                      <Translate contentKey={`testeApp.UF.${diarista.uf}`} />
                    </td>
                    <td>{diarista.complemento}</td>
                    <td>{diarista.numero}</td>
                    <td>{diarista.ddd}</td>
                    <td>{diarista.telefone}</td>
                    <td>{diarista.email}</td>
                    <td>{diarista.nomeContato}</td>
                    <td>{diarista.dddContato}</td>
                    <td>{diarista.telefoneContato}</td>
                    <td>
                      <TextFormat type="date" value={diarista.dataNascimento} format={APP_LOCAL_DATE_FORMAT} />
                    </td>
                    <td>{diarista.cargo}</td>
                    <td>
                      <TextFormat type="date" value={diarista.dataAdmissao} format={APP_LOCAL_DATE_FORMAT} />
                    </td>
                    <td>
                      <TextFormat type="date" value={diarista.dataSaida} format={APP_LOCAL_DATE_FORMAT} />
                    </td>
                    <td>
                      <Translate contentKey={`testeApp.TamanhoCamisa.${diarista.tamanhoCamisa}`} />
                    </td>
                    <td>{diarista.pis}</td>
                    <td>{diarista.cartaoCidadado}</td>
                    <td>{diarista.numeroTituloEleitor}</td>
                    <td>{diarista.zonaTituloEleitor}</td>
                    <td>{diarista.secaoTituloEleitor}</td>
                    <td>{diarista.numeroCarteiraTrabalho}</td>
                    <td>{diarista.serieCarteiraTrabalho}</td>
                    <td>
                      <Translate contentKey={`testeApp.UF.${diarista.ufCarteiraTrabalho}`} />
                    </td>
                    <td>{diarista.nire}</td>
                    <td>{diarista.cnpj}</td>
                    <td>{diarista.clienteId ? <Link to={`cliente/${diarista.clienteId}`}>{diarista.clienteId}</Link> : ''}</td>
                    <td>{diarista.clienteId ? <Link to={`cliente/${diarista.clienteId}`}>{diarista.clienteId}</Link> : ''}</td>
                    <td className="text-right">
                      <div className="btn-group flex-btn-group-container">
                        <Button tag={Link} to={`${match.url}/${diarista.id}`} color="info" size="sm">
                          <FontAwesomeIcon icon="eye" />{' '}
                          <span className="d-none d-md-inline">
                            <Translate contentKey="entity.action.view">View</Translate>
                          </span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${diarista.id}/edit`} color="primary" size="sm">
                          <FontAwesomeIcon icon="pencil-alt" />{' '}
                          <span className="d-none d-md-inline">
                            <Translate contentKey="entity.action.edit">Edit</Translate>
                          </span>
                        </Button>
                        <Button tag={Link} to={`${match.url}/${diarista.id}/delete`} color="danger" size="sm">
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

const mapStateToProps = ({ diarista }: IRootState) => ({
  diaristaList: diarista.entities,
  totalItems: diarista.totalItems,
  links: diarista.links,
  entity: diarista.entity,
  updateSuccess: diarista.updateSuccess
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
)(Diarista);
