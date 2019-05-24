import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './cliente.reducer';
import { ICliente } from 'app/shared/model/cliente.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IClienteUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface IClienteUpdateState {
  isNew: boolean;
}

export class ClienteUpdate extends React.Component<IClienteUpdateProps, IClienteUpdateState> {
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
    if (!this.state.isNew) {
      this.props.getEntity(this.props.match.params.id);
    }
  }

  saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const { clienteEntity } = this.props;
      const entity = {
        ...clienteEntity,
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
    this.props.history.push('/entity/cliente');
  };

  render() {
    const { clienteEntity, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="testeApp.cliente.home.createOrEditLabel">
              <Translate contentKey="testeApp.cliente.home.createOrEditLabel">Create or edit a Cliente</Translate>
            </h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : clienteEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="cliente-id">
                      <Translate contentKey="global.field.id">ID</Translate>
                    </Label>
                    <AvInput id="cliente-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="tipoLabel" for="cliente-tipo">
                    <Translate contentKey="testeApp.cliente.tipo">Tipo</Translate>
                  </Label>
                  <AvInput
                    id="cliente-tipo"
                    type="select"
                    className="form-control"
                    name="tipo"
                    value={(!isNew && clienteEntity.tipo) || 'PESSOA_FISICA'}
                  >
                    <option value="PESSOA_FISICA">
                      <Translate contentKey="testeApp.TipoPessoa.PESSOA_FISICA" />
                    </option>
                    <option value="PESSOA_JURIDICA">
                      <Translate contentKey="testeApp.TipoPessoa.PESSOA_JURIDICA" />
                    </option>
                  </AvInput>
                </AvGroup>
                <AvGroup>
                  <Label id="nomeLabel" for="cliente-nome">
                    <Translate contentKey="testeApp.cliente.nome">Nome</Translate>
                  </Label>
                  <AvField
                    id="cliente-nome"
                    type="text"
                    name="nome"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 3, errorMessage: translate('entity.validation.minlength', { min: 3 }) },
                      maxLength: { value: 250, errorMessage: translate('entity.validation.maxlength', { max: 250 }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="rgLabel" for="cliente-rg">
                    <Translate contentKey="testeApp.cliente.rg">Rg</Translate>
                  </Label>
                  <AvField
                    id="cliente-rg"
                    type="text"
                    name="rg"
                    validate={{
                      minLength: { value: 3, errorMessage: translate('entity.validation.minlength', { min: 3 }) },
                      maxLength: { value: 50, errorMessage: translate('entity.validation.maxlength', { max: 50 }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="cpfLabel" for="cliente-cpf">
                    <Translate contentKey="testeApp.cliente.cpf">Cpf</Translate>
                  </Label>
                  <AvField
                    id="cliente-cpf"
                    type="text"
                    name="cpf"
                    validate={{
                      minLength: { value: 11, errorMessage: translate('entity.validation.minlength', { min: 11 }) },
                      maxLength: { value: 11, errorMessage: translate('entity.validation.maxlength', { max: 11 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="cfdfLabel" for="cliente-cfdf">
                    <Translate contentKey="testeApp.cliente.cfdf">Cfdf</Translate>
                  </Label>
                  <AvField
                    id="cliente-cfdf"
                    type="text"
                    name="cfdf"
                    validate={{
                      minLength: { value: 3, errorMessage: translate('entity.validation.minlength', { min: 3 }) },
                      maxLength: { value: 15, errorMessage: translate('entity.validation.maxlength', { max: 15 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="cnpjLabel" for="cliente-cnpj">
                    <Translate contentKey="testeApp.cliente.cnpj">Cnpj</Translate>
                  </Label>
                  <AvField
                    id="cliente-cnpj"
                    type="text"
                    name="cnpj"
                    validate={{
                      minLength: { value: 14, errorMessage: translate('entity.validation.minlength', { min: 14 }) },
                      maxLength: { value: 14, errorMessage: translate('entity.validation.maxlength', { max: 14 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="dataNascimentoLabel" for="cliente-dataNascimento">
                    <Translate contentKey="testeApp.cliente.dataNascimento">Data Nascimento</Translate>
                  </Label>
                  <AvField id="cliente-dataNascimento" type="date" className="form-control" name="dataNascimento" />
                </AvGroup>
                <AvGroup>
                  <Label id="dataCriacaoLabel" for="cliente-dataCriacao">
                    <Translate contentKey="testeApp.cliente.dataCriacao">Data Criacao</Translate>
                  </Label>
                  <AvField id="cliente-dataCriacao" type="date" className="form-control" name="dataCriacao" />
                </AvGroup>
                <AvGroup>
                  <Label id="dataCadastroLabel" for="cliente-dataCadastro">
                    <Translate contentKey="testeApp.cliente.dataCadastro">Data Cadastro</Translate>
                  </Label>
                  <AvField
                    id="cliente-dataCadastro"
                    type="date"
                    className="form-control"
                    name="dataCadastro"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="profissaoLabel" for="cliente-profissao">
                    <Translate contentKey="testeApp.cliente.profissao">Profissao</Translate>
                  </Label>
                  <AvField
                    id="cliente-profissao"
                    type="text"
                    name="profissao"
                    validate={{
                      maxLength: { value: 250, errorMessage: translate('entity.validation.maxlength', { max: 250 }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="emailLabel" for="cliente-email">
                    <Translate contentKey="testeApp.cliente.email">Email</Translate>
                  </Label>
                  <AvField
                    id="cliente-email"
                    type="text"
                    name="email"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 3, errorMessage: translate('entity.validation.minlength', { min: 3 }) },
                      maxLength: { value: 250, errorMessage: translate('entity.validation.maxlength', { max: 250 }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="dddLabel" for="cliente-ddd">
                    <Translate contentKey="testeApp.cliente.ddd">Ddd</Translate>
                  </Label>
                  <AvField
                    id="cliente-ddd"
                    type="text"
                    name="ddd"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 2, errorMessage: translate('entity.validation.minlength', { min: 2 }) },
                      maxLength: { value: 2, errorMessage: translate('entity.validation.maxlength', { max: 2 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="telefoneLabel" for="cliente-telefone">
                    <Translate contentKey="testeApp.cliente.telefone">Telefone</Translate>
                  </Label>
                  <AvField
                    id="cliente-telefone"
                    type="text"
                    name="telefone"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 8, errorMessage: translate('entity.validation.minlength', { min: 8 }) },
                      maxLength: { value: 9, errorMessage: translate('entity.validation.maxlength', { max: 9 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="cepLabel" for="cliente-cep">
                    <Translate contentKey="testeApp.cliente.cep">Cep</Translate>
                  </Label>
                  <AvField
                    id="cliente-cep"
                    type="text"
                    name="cep"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 8, errorMessage: translate('entity.validation.minlength', { min: 8 }) },
                      maxLength: { value: 8, errorMessage: translate('entity.validation.maxlength', { max: 8 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="logradouroLabel" for="cliente-logradouro">
                    <Translate contentKey="testeApp.cliente.logradouro">Logradouro</Translate>
                  </Label>
                  <AvField
                    id="cliente-logradouro"
                    type="text"
                    name="logradouro"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 2, errorMessage: translate('entity.validation.minlength', { min: 2 }) },
                      maxLength: { value: 250, errorMessage: translate('entity.validation.maxlength', { max: 250 }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="localidadeLabel" for="cliente-localidade">
                    <Translate contentKey="testeApp.cliente.localidade">Localidade</Translate>
                  </Label>
                  <AvField
                    id="cliente-localidade"
                    type="text"
                    name="localidade"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 2, errorMessage: translate('entity.validation.minlength', { min: 2 }) },
                      maxLength: { value: 250, errorMessage: translate('entity.validation.maxlength', { max: 250 }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="bairroLabel" for="cliente-bairro">
                    <Translate contentKey="testeApp.cliente.bairro">Bairro</Translate>
                  </Label>
                  <AvField
                    id="cliente-bairro"
                    type="text"
                    name="bairro"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 2, errorMessage: translate('entity.validation.minlength', { min: 2 }) },
                      maxLength: { value: 250, errorMessage: translate('entity.validation.maxlength', { max: 250 }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="complementoLabel" for="cliente-complemento">
                    <Translate contentKey="testeApp.cliente.complemento">Complemento</Translate>
                  </Label>
                  <AvField
                    id="cliente-complemento"
                    type="text"
                    name="complemento"
                    validate={{
                      maxLength: { value: 250, errorMessage: translate('entity.validation.maxlength', { max: 250 }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="ufLabel" for="cliente-uf">
                    <Translate contentKey="testeApp.cliente.uf">Uf</Translate>
                  </Label>
                  <AvInput id="cliente-uf" type="select" className="form-control" name="uf" value={(!isNew && clienteEntity.uf) || 'AC'}>
                    <option value="AC">
                      <Translate contentKey="testeApp.UF.AC" />
                    </option>
                    <option value="AL">
                      <Translate contentKey="testeApp.UF.AL" />
                    </option>
                    <option value="AP">
                      <Translate contentKey="testeApp.UF.AP" />
                    </option>
                    <option value="AM">
                      <Translate contentKey="testeApp.UF.AM" />
                    </option>
                    <option value="BA">
                      <Translate contentKey="testeApp.UF.BA" />
                    </option>
                    <option value="CE">
                      <Translate contentKey="testeApp.UF.CE" />
                    </option>
                    <option value="DF">
                      <Translate contentKey="testeApp.UF.DF" />
                    </option>
                    <option value="ES">
                      <Translate contentKey="testeApp.UF.ES" />
                    </option>
                    <option value="GO">
                      <Translate contentKey="testeApp.UF.GO" />
                    </option>
                    <option value="MA">
                      <Translate contentKey="testeApp.UF.MA" />
                    </option>
                    <option value="MT">
                      <Translate contentKey="testeApp.UF.MT" />
                    </option>
                    <option value="MS">
                      <Translate contentKey="testeApp.UF.MS" />
                    </option>
                    <option value="MG">
                      <Translate contentKey="testeApp.UF.MG" />
                    </option>
                    <option value="PA">
                      <Translate contentKey="testeApp.UF.PA" />
                    </option>
                    <option value="PB">
                      <Translate contentKey="testeApp.UF.PB" />
                    </option>
                    <option value="PR">
                      <Translate contentKey="testeApp.UF.PR" />
                    </option>
                    <option value="PE">
                      <Translate contentKey="testeApp.UF.PE" />
                    </option>
                    <option value="PI">
                      <Translate contentKey="testeApp.UF.PI" />
                    </option>
                    <option value="RJ">
                      <Translate contentKey="testeApp.UF.RJ" />
                    </option>
                    <option value="RN">
                      <Translate contentKey="testeApp.UF.RN" />
                    </option>
                    <option value="RS">
                      <Translate contentKey="testeApp.UF.RS" />
                    </option>
                    <option value="RO">
                      <Translate contentKey="testeApp.UF.RO" />
                    </option>
                    <option value="RR">
                      <Translate contentKey="testeApp.UF.RR" />
                    </option>
                    <option value="SC">
                      <Translate contentKey="testeApp.UF.SC" />
                    </option>
                    <option value="SP">
                      <Translate contentKey="testeApp.UF.SP" />
                    </option>
                    <option value="SE">
                      <Translate contentKey="testeApp.UF.SE" />
                    </option>
                    <option value="TO">
                      <Translate contentKey="testeApp.UF.TO" />
                    </option>
                  </AvInput>
                </AvGroup>
                <AvGroup>
                  <Label id="numeroLabel" for="cliente-numero">
                    <Translate contentKey="testeApp.cliente.numero">Numero</Translate>
                  </Label>
                  <AvField
                    id="cliente-numero"
                    type="text"
                    name="numero"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 1, errorMessage: translate('entity.validation.minlength', { min: 1 }) },
                      maxLength: { value: 40, errorMessage: translate('entity.validation.maxlength', { max: 40 }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="pontosReferenciaEnderecoLabel" for="cliente-pontosReferenciaEndereco">
                    <Translate contentKey="testeApp.cliente.pontosReferenciaEndereco">Pontos Referencia Endereco</Translate>
                  </Label>
                  <AvField
                    id="cliente-pontosReferenciaEndereco"
                    type="text"
                    name="pontosReferenciaEndereco"
                    validate={{
                      maxLength: { value: 250, errorMessage: translate('entity.validation.maxlength', { max: 250 }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="estacaoMetroMaisProximaLabel" for="cliente-estacaoMetroMaisProxima">
                    <Translate contentKey="testeApp.cliente.estacaoMetroMaisProxima">Estacao Metro Mais Proxima</Translate>
                  </Label>
                  <AvField
                    id="cliente-estacaoMetroMaisProxima"
                    type="text"
                    name="estacaoMetroMaisProxima"
                    validate={{
                      maxLength: { value: 250, errorMessage: translate('entity.validation.maxlength', { max: 250 }) }
                    }}
                  />
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/cliente" replace color="info">
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
  clienteEntity: storeState.cliente.entity,
  loading: storeState.cliente.loading,
  updating: storeState.cliente.updating,
  updateSuccess: storeState.cliente.updateSuccess
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
)(ClienteUpdate);
