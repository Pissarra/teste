import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import ModeloMensagens from './modelo-mensagens';
import ModeloMensagensDetail from './modelo-mensagens-detail';
import ModeloMensagensUpdate from './modelo-mensagens-update';
import ModeloMensagensDeleteDialog from './modelo-mensagens-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={ModeloMensagensUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={ModeloMensagensUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={ModeloMensagensDetail} />
      <ErrorBoundaryRoute path={match.url} component={ModeloMensagens} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={ModeloMensagensDeleteDialog} />
  </>
);

export default Routes;
