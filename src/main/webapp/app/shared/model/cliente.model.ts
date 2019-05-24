import { Moment } from 'moment';
import { IDiarista } from 'app/shared/model/diarista.model';

export const enum TipoPessoa {
  PESSOA_FISICA = 'PESSOA_FISICA',
  PESSOA_JURIDICA = 'PESSOA_JURIDICA'
}

export const enum UF {
  AC = 'AC',
  AL = 'AL',
  AP = 'AP',
  AM = 'AM',
  BA = 'BA',
  CE = 'CE',
  DF = 'DF',
  ES = 'ES',
  GO = 'GO',
  MA = 'MA',
  MT = 'MT',
  MS = 'MS',
  MG = 'MG',
  PA = 'PA',
  PB = 'PB',
  PR = 'PR',
  PE = 'PE',
  PI = 'PI',
  RJ = 'RJ',
  RN = 'RN',
  RS = 'RS',
  RO = 'RO',
  RR = 'RR',
  SC = 'SC',
  SP = 'SP',
  SE = 'SE',
  TO = 'TO'
}

export interface ICliente {
  id?: number;
  tipo?: TipoPessoa;
  nome?: string;
  rg?: string;
  cpf?: string;
  cfdf?: string;
  cnpj?: string;
  dataNascimento?: Moment;
  dataCriacao?: Moment;
  dataCadastro?: Moment;
  profissao?: string;
  email?: string;
  ddd?: string;
  telefone?: string;
  cep?: string;
  logradouro?: string;
  localidade?: string;
  bairro?: string;
  complemento?: string;
  uf?: UF;
  numero?: string;
  pontosReferenciaEndereco?: string;
  estacaoMetroMaisProxima?: string;
  restricoes?: IDiarista[];
  diaristasPreferidas?: IDiarista[];
}

export const defaultValue: Readonly<ICliente> = {};
