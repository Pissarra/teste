import React from 'react';
import { Switch } from 'react-router-dom';

import ErrorBoundaryRoute from 'app/shared/error/error-boundary-route';

import Diarista from './diarista';
import DiaristaDetail from './diarista-detail';
import DiaristaUpdate from './diarista-update';
import DiaristaDeleteDialog from './diarista-delete-dialog';

const Routes = ({ match }) => (
  <>
    <Switch>
      <ErrorBoundaryRoute exact path={`${match.url}/new`} component={DiaristaUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id/edit`} component={DiaristaUpdate} />
      <ErrorBoundaryRoute exact path={`${match.url}/:id`} component={DiaristaDetail} />
      <ErrorBoundaryRoute path={match.url} component={Diarista} />
    </Switch>
    <ErrorBoundaryRoute path={`${match.url}/:id/delete`} component={DiaristaDeleteDialog} />
  </>
);

export default Routes;
