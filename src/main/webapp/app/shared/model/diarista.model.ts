import { Moment } from 'moment';

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

export const enum TamanhoCamisa {
  PP = 'PP',
  P = 'P',
  M = 'M',
  G = 'G',
  GG = 'GG',
  XG = 'XG'
}

export interface IDiarista {
  id?: number;
  nome?: string;
  rg?: string;
  cpf?: string;
  cep?: string;
  logradouro?: string;
  localidade?: string;
  bairro?: string;
  uf?: UF;
  complemento?: string;
  numero?: string;
  ddd?: string;
  telefone?: string;
  email?: string;
  nomeContato?: string;
  dddContato?: string;
  telefoneContato?: string;
  dataNascimento?: Moment;
  cargo?: string;
  dataAdmissao?: Moment;
  dataSaida?: Moment;
  tamanhoCamisa?: TamanhoCamisa;
  pis?: string;
  cartaoCidadado?: string;
  numeroTituloEleitor?: string;
  zonaTituloEleitor?: string;
  secaoTituloEleitor?: string;
  numeroCarteiraTrabalho?: string;
  serieCarteiraTrabalho?: string;
  ufCarteiraTrabalho?: UF;
  nire?: string;
  cnpj?: string;
  clienteId?: number;
  clienteId?: number;
}

export const defaultValue: Readonly<IDiarista> = {};
