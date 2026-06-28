import { Routes } from '@angular/router';

import { Login } from './pages/login/login';
import { Users } from './pages/users/users';
import { Dashboard } from './pages/dashboard/dashboard';
import { Products } from './pages/products/products';
import { Categories } from './pages/categories/categories';
import { Movements } from './pages/movements/movements';
import { ClientList } from './pages/clients/client-list/client-list';
import { ClientForm } from './pages/clients/client-form/client-form';
import { adminGuard } from './core/guards/admin-guard';


import { authGuard } from './core/guards/auth-guard';

export const routes: Routes = [

  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },

  {
    path: 'login',
    component: Login
  },

  {
    path: 'usuarios',
    component: Users,
    canActivate: [adminGuard]
  },

  {
    path: 'dashboard',
    component: Dashboard,
    canActivate: [authGuard]
  },

  {
    path: 'productos',
    component: Products,
    canActivate: [authGuard]
  },

  {
    path: 'categorias',
    component: Categories,
    canActivate: [authGuard]
  },

  {
    path: 'movimientos',
    component: Movements,
    canActivate: [authGuard]
  },

  {
    path: 'clientes',
    component: ClientList,
    canActivate: [authGuard]
  },

  {
    path: 'clientes/nuevo',
    component: ClientForm,
    canActivate: [authGuard]
  },

  {
    path: '**',
    redirectTo: 'login'
  }

];