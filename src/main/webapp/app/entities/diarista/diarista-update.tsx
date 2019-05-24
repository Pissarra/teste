import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
// tslint:disable-next-line:no-unused-variable
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { ICliente } from 'app/shared/model/cliente.model';
import { getEntities as getClientes } from 'app/entities/cliente/cliente.reducer';
import { getEntity, updateEntity, createEntity, reset } from './diarista.reducer';
import { IDiarista } from 'app/shared/model/diarista.model';
// tslint:disable-next-line:no-unused-variable
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IDiaristaUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export interface IDiaristaUpdateState {
  isNew: boolean;
  clienteId: string;
  clienteId: string;
}

export class DiaristaUpdate extends React.Component<IDiaristaUpdateProps, IDiaristaUpdateState> {
  constructor(props) {
    super(props);
    this.state = {
      clienteId: '0',
      clienteId: '0',
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

    this.props.getClientes();
  }

  saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const { diaristaEntity } = this.props;
      const entity = {
        ...diaristaEntity,
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
    this.props.history.push('/entity/diarista');
  };

  render() {
    const { diaristaEntity, clientes, loading, updating } = this.props;
    const { isNew } = this.state;

    return (
      <div>
        <Row className="justify-content-center">
          <Col md="8">
            <h2 id="testeApp.diarista.home.createOrEditLabel">
              <Translate contentKey="testeApp.diarista.home.createOrEditLabel">Create or edit a Diarista</Translate>
            </h2>
          </Col>
        </Row>
        <Row className="justify-content-center">
          <Col md="8">
            {loading ? (
              <p>Loading...</p>
            ) : (
              <AvForm model={isNew ? {} : diaristaEntity} onSubmit={this.saveEntity}>
                {!isNew ? (
                  <AvGroup>
                    <Label for="diarista-id">
                      <Translate contentKey="global.field.id">ID</Translate>
                    </Label>
                    <AvInput id="diarista-id" type="text" className="form-control" name="id" required readOnly />
                  </AvGroup>
                ) : null}
                <AvGroup>
                  <Label id="nomeLabel" for="diarista-nome">
                    <Translate contentKey="testeApp.diarista.nome">Nome</Translate>
                  </Label>
                  <AvField
                    id="diarista-nome"
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
                  <Label id="rgLabel" for="diarista-rg">
                    <Translate contentKey="testeApp.diarista.rg">Rg</Translate>
                  </Label>
                  <AvField
                    id="diarista-rg"
                    type="text"
                    name="rg"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 3, errorMessage: translate('entity.validation.minlength', { min: 3 }) },
                      maxLength: { value: 50, errorMessage: translate('entity.validation.maxlength', { max: 50 }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="cpfLabel" for="diarista-cpf">
                    <Translate contentKey="testeApp.diarista.cpf">Cpf</Translate>
                  </Label>
                  <AvField
                    id="diarista-cpf"
                    type="text"
                    name="cpf"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 11, errorMessage: translate('entity.validation.minlength', { min: 11 }) },
                      maxLength: { value: 11, errorMessage: translate('entity.validation.maxlength', { max: 11 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="cepLabel" for="diarista-cep">
                    <Translate contentKey="testeApp.diarista.cep">Cep</Translate>
                  </Label>
                  <AvField
                    id="diarista-cep"
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
                  <Label id="logradouroLabel" for="diarista-logradouro">
                    <Translate contentKey="testeApp.diarista.logradouro">Logradouro</Translate>
                  </Label>
                  <AvField
                    id="diarista-logradouro"
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
                  <Label id="localidadeLabel" for="diarista-localidade">
                    <Translate contentKey="testeApp.diarista.localidade">Localidade</Translate>
                  </Label>
                  <AvField
                    id="diarista-localidade"
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
                  <Label id="bairroLabel" for="diarista-bairro">
                    <Translate contentKey="testeApp.diarista.bairro">Bairro</Translate>
                  </Label>
                  <AvField
                    id="diarista-bairro"
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
                  <Label id="ufLabel" for="diarista-uf">
                    <Translate contentKey="testeApp.diarista.uf">Uf</Translate>
                  </Label>
                  <AvInput id="diarista-uf" type="select" className="form-control" name="uf" value={(!isNew && diaristaEntity.uf) || 'AC'}>
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
                  <Label id="complementoLabel" for="diarista-complemento">
                    <Translate contentKey="testeApp.diarista.complemento">Complemento</Translate>
                  </Label>
                  <AvField
                    id="diarista-complemento"
                    type="text"
                    name="complemento"
                    validate={{
                      maxLength: { value: 250, errorMessage: translate('entity.validation.maxlength', { max: 250 }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="numeroLabel" for="diarista-numero">
                    <Translate contentKey="testeApp.diarista.numero">Numero</Translate>
                  </Label>
                  <AvField
                    id="diarista-numero"
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
                  <Label id="dddLabel" for="diarista-ddd">
                    <Translate contentKey="testeApp.diarista.ddd">Ddd</Translate>
                  </Label>
                  <AvField
                    id="diarista-ddd"
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
                  <Label id="telefoneLabel" for="diarista-telefone">
                    <Translate contentKey="testeApp.diarista.telefone">Telefone</Translate>
                  </Label>
                  <AvField
                    id="diarista-telefone"
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
                  <Label id="emailLabel" for="diarista-email">
                    <Translate contentKey="testeApp.diarista.email">Email</Translate>
                  </Label>
                  <AvField
                    id="diarista-email"
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
                  <Label id="nomeContatoLabel" for="diarista-nomeContato">
                    <Translate contentKey="testeApp.diarista.nomeContato">Nome Contato</Translate>
                  </Label>
                  <AvField
                    id="diarista-nomeContato"
                    type="text"
                    name="nomeContato"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 3, errorMessage: translate('entity.validation.minlength', { min: 3 }) },
                      maxLength: { value: 250, errorMessage: translate('entity.validation.maxlength', { max: 250 }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="dddContatoLabel" for="diarista-dddContato">
                    <Translate contentKey="testeApp.diarista.dddContato">Ddd Contato</Translate>
                  </Label>
                  <AvField
                    id="diarista-dddContato"
                    type="text"
                    name="dddContato"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 2, errorMessage: translate('entity.validation.minlength', { min: 2 }) },
                      maxLength: { value: 2, errorMessage: translate('entity.validation.maxlength', { max: 2 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="telefoneContatoLabel" for="diarista-telefoneContato">
                    <Translate contentKey="testeApp.diarista.telefoneContato">Telefone Contato</Translate>
                  </Label>
                  <AvField
                    id="diarista-telefoneContato"
                    type="text"
                    name="telefoneContato"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 8, errorMessage: translate('entity.validation.minlength', { min: 8 }) },
                      maxLength: { value: 9, errorMessage: translate('entity.validation.maxlength', { max: 9 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="dataNascimentoLabel" for="diarista-dataNascimento">
                    <Translate contentKey="testeApp.diarista.dataNascimento">Data Nascimento</Translate>
                  </Label>
                  <AvField
                    id="diarista-dataNascimento"
                    type="date"
                    className="form-control"
                    name="dataNascimento"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="cargoLabel" for="diarista-cargo">
                    <Translate contentKey="testeApp.diarista.cargo">Cargo</Translate>
                  </Label>
                  <AvField
                    id="diarista-cargo"
                    type="text"
                    name="cargo"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 2, errorMessage: translate('entity.validation.minlength', { min: 2 }) },
                      maxLength: { value: 250, errorMessage: translate('entity.validation.maxlength', { max: 250 }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="dataAdmissaoLabel" for="diarista-dataAdmissao">
                    <Translate contentKey="testeApp.diarista.dataAdmissao">Data Admissao</Translate>
                  </Label>
                  <AvField
                    id="diarista-dataAdmissao"
                    type="date"
                    className="form-control"
                    name="dataAdmissao"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="dataSaidaLabel" for="diarista-dataSaida">
                    <Translate contentKey="testeApp.diarista.dataSaida">Data Saida</Translate>
                  </Label>
                  <AvField id="diarista-dataSaida" type="date" className="form-control" name="dataSaida" />
                </AvGroup>
                <AvGroup>
                  <Label id="tamanhoCamisaLabel" for="diarista-tamanhoCamisa">
                    <Translate contentKey="testeApp.diarista.tamanhoCamisa">Tamanho Camisa</Translate>
                  </Label>
                  <AvInput
                    id="diarista-tamanhoCamisa"
                    type="select"
                    className="form-control"
                    name="tamanhoCamisa"
                    value={(!isNew && diaristaEntity.tamanhoCamisa) || 'PP'}
                  >
                    <option value="PP">
                      <Translate contentKey="testeApp.TamanhoCamisa.PP" />
                    </option>
                    <option value="P">
                      <Translate contentKey="testeApp.TamanhoCamisa.P" />
                    </option>
                    <option value="M">
                      <Translate contentKey="testeApp.TamanhoCamisa.M" />
                    </option>
                    <option value="G">
                      <Translate contentKey="testeApp.TamanhoCamisa.G" />
                    </option>
                    <option value="GG">
                      <Translate contentKey="testeApp.TamanhoCamisa.GG" />
                    </option>
                    <option value="XG">
                      <Translate contentKey="testeApp.TamanhoCamisa.XG" />
                    </option>
                  </AvInput>
                </AvGroup>
                <AvGroup>
                  <Label id="pisLabel" for="diarista-pis">
                    <Translate contentKey="testeApp.diarista.pis">Pis</Translate>
                  </Label>
                  <AvField
                    id="diarista-pis"
                    type="text"
                    name="pis"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 3, errorMessage: translate('entity.validation.minlength', { min: 3 }) },
                      maxLength: { value: 30, errorMessage: translate('entity.validation.maxlength', { max: 30 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="cartaoCidadadoLabel" for="diarista-cartaoCidadado">
                    <Translate contentKey="testeApp.diarista.cartaoCidadado">Cartao Cidadado</Translate>
                  </Label>
                  <AvField
                    id="diarista-cartaoCidadado"
                    type="text"
                    name="cartaoCidadado"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 2, errorMessage: translate('entity.validation.minlength', { min: 2 }) },
                      maxLength: { value: 30, errorMessage: translate('entity.validation.maxlength', { max: 30 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="numeroTituloEleitorLabel" for="diarista-numeroTituloEleitor">
                    <Translate contentKey="testeApp.diarista.numeroTituloEleitor">Numero Titulo Eleitor</Translate>
                  </Label>
                  <AvField
                    id="diarista-numeroTituloEleitor"
                    type="text"
                    name="numeroTituloEleitor"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 6, errorMessage: translate('entity.validation.minlength', { min: 6 }) },
                      maxLength: { value: 30, errorMessage: translate('entity.validation.maxlength', { max: 30 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="zonaTituloEleitorLabel" for="diarista-zonaTituloEleitor">
                    <Translate contentKey="testeApp.diarista.zonaTituloEleitor">Zona Titulo Eleitor</Translate>
                  </Label>
                  <AvField
                    id="diarista-zonaTituloEleitor"
                    type="text"
                    name="zonaTituloEleitor"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 2, errorMessage: translate('entity.validation.minlength', { min: 2 }) },
                      maxLength: { value: 5, errorMessage: translate('entity.validation.maxlength', { max: 5 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="secaoTituloEleitorLabel" for="diarista-secaoTituloEleitor">
                    <Translate contentKey="testeApp.diarista.secaoTituloEleitor">Secao Titulo Eleitor</Translate>
                  </Label>
                  <AvField
                    id="diarista-secaoTituloEleitor"
                    type="text"
                    name="secaoTituloEleitor"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 2, errorMessage: translate('entity.validation.minlength', { min: 2 }) },
                      maxLength: { value: 6, errorMessage: translate('entity.validation.maxlength', { max: 6 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="numeroCarteiraTrabalhoLabel" for="diarista-numeroCarteiraTrabalho">
                    <Translate contentKey="testeApp.diarista.numeroCarteiraTrabalho">Numero Carteira Trabalho</Translate>
                  </Label>
                  <AvField
                    id="diarista-numeroCarteiraTrabalho"
                    type="text"
                    name="numeroCarteiraTrabalho"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 2, errorMessage: translate('entity.validation.minlength', { min: 2 }) },
                      maxLength: { value: 20, errorMessage: translate('entity.validation.maxlength', { max: 20 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="serieCarteiraTrabalhoLabel" for="diarista-serieCarteiraTrabalho">
                    <Translate contentKey="testeApp.diarista.serieCarteiraTrabalho">Serie Carteira Trabalho</Translate>
                  </Label>
                  <AvField
                    id="diarista-serieCarteiraTrabalho"
                    type="text"
                    name="serieCarteiraTrabalho"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 2, errorMessage: translate('entity.validation.minlength', { min: 2 }) },
                      maxLength: { value: 6, errorMessage: translate('entity.validation.maxlength', { max: 6 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="ufCarteiraTrabalhoLabel" for="diarista-ufCarteiraTrabalho">
                    <Translate contentKey="testeApp.diarista.ufCarteiraTrabalho">Uf Carteira Trabalho</Translate>
                  </Label>
                  <AvInput
                    id="diarista-ufCarteiraTrabalho"
                    type="select"
                    className="form-control"
                    name="ufCarteiraTrabalho"
                    value={(!isNew && diaristaEntity.ufCarteiraTrabalho) || 'AC'}
                  >
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
                  <Label id="nireLabel" for="diarista-nire">
                    <Translate contentKey="testeApp.diarista.nire">Nire</Translate>
                  </Label>
                  <AvField
                    id="diarista-nire"
                    type="text"
                    name="nire"
                    validate={{
                      minLength: { value: 11, errorMessage: translate('entity.validation.minlength', { min: 11 }) },
                      maxLength: { value: 11, errorMessage: translate('entity.validation.maxlength', { max: 11 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label id="cnpjLabel" for="diarista-cnpj">
                    <Translate contentKey="testeApp.diarista.cnpj">Cnpj</Translate>
                  </Label>
                  <AvField
                    id="diarista-cnpj"
                    type="text"
                    name="cnpj"
                    validate={{
                      required: { value: true, errorMessage: translate('entity.validation.required') },
                      minLength: { value: 14, errorMessage: translate('entity.validation.minlength', { min: 14 }) },
                      maxLength: { value: 14, errorMessage: translate('entity.validation.maxlength', { max: 14 }) },
                      pattern: { value: '[0-9]+', errorMessage: translate('entity.validation.pattern', { pattern: '[0-9]+' }) }
                    }}
                  />
                </AvGroup>
                <AvGroup>
                  <Label for="diarista-cliente">
                    <Translate contentKey="testeApp.diarista.cliente">Cliente</Translate>
                  </Label>
                  <AvInput id="diarista-cliente" type="select" className="form-control" name="clienteId">
                    <option value="" key="0" />
                    {clientes
                      ? clientes.map(otherEntity => (
                          <option value={otherEntity.id} key={otherEntity.id}>
                            {otherEntity.id}
                          </option>
                        ))
                      : null}
                  </AvInput>
                </AvGroup>
                <AvGroup>
                  <Label for="diarista-cliente">
                    <Translate contentKey="testeApp.diarista.cliente">Cliente</Translate>
                  </Label>
                  <AvInput id="diarista-cliente" type="select" className="form-control" name="clienteId">
                    <option value="" key="0" />
                    {clientes
                      ? clientes.map(otherEntity => (
                          <option value={otherEntity.id} key={otherEntity.id}>
                            {otherEntity.id}
                          </option>
                        ))
                      : null}
                  </AvInput>
                </AvGroup>
                <Button tag={Link} id="cancel-save" to="/entity/diarista" replace color="info">
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
  clientes: storeState.cliente.entities,
  diaristaEntity: storeState.diarista.entity,
  loading: storeState.diarista.loading,
  updating: storeState.diarista.updating,
  updateSuccess: storeState.diarista.updateSuccess
});

const mapDispatchToProps = {
  getClientes,
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
)(DiaristaUpdate);
