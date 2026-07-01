import { Routes } from '@angular/router';

import { Login } from './pages/login/login';
import { Users } from './pages/users/users';
import { Dashboard } from './pages/dashboard/dashboard';
import { Products } from './pages/products/products';
import { Categories } from './pages/categories/categories';
import { Movements } from './pages/movements/movements';
import { ClientList } from './pages/clients/client-list/client-list';
import { ClientForm } from './pages/clients/client-form/client-form';
import { ProductForm } from './pages/products/product-form/product-form';
import { CategoryForm } from './pages/categories/category-form/category-form';
import { MovementForm } from './pages/movements/movement-form/movement-form';
import { roleGuard } from './core/guards/role-guard';


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
    canActivate: [
      authGuard,
      roleGuard(['ROLE_ADMIN'])
    ]
  },

  {
    path: 'dashboard',
    component: Dashboard,
    canActivate: [authGuard]
  },

  {
    path: 'productos',
    component: Products,
    canActivate: [
      authGuard,
      roleGuard([
        'ROLE_ADMIN',
        'ROLE_OPERATOR'
      ])
    ]
  },

  {
    path: 'productos/nuevo',
    component: ProductForm,
    canActivate: [
      authGuard,
      roleGuard([
        'ROLE_ADMIN',
        'ROLE_OPERATOR'
      ])
    ]
  },

  {
    path: 'productos/editar/:id',
    component: ProductForm,
    canActivate: [
      authGuard,
      roleGuard([
        'ROLE_ADMIN',
        'ROLE_OPERATOR'
      ])
    ]
  },

  {
    path: 'categorias',
    component: Categories,
    canActivate: [
      authGuard,
      roleGuard([
        'ROLE_ADMIN',
        'ROLE_OPERATOR'
      ])
    ]
  },

  {
    path: 'categorias/nuevo',
    component: CategoryForm,
    canActivate: [
      authGuard,
      roleGuard([
        'ROLE_ADMIN',
        'ROLE_OPERATOR'
      ])
    ]
  },

  {
    path: 'categorias/editar/:id',
    component: CategoryForm,
    canActivate: [
      authGuard,
      roleGuard([
        'ROLE_ADMIN',
        'ROLE_OPERATOR'
      ])
    ]
  },

  {
    path: 'movimientos',
    component: Movements,
    canActivate: [
      authGuard,
      roleGuard([
        'ROLE_ADMIN',
        'ROLE_OPERATOR',
        'ROLE_DELIVERY'
      ])
    ]
  },

  {
    path: 'movimientos/nuevo',
    component: MovementForm,
    canActivate: [
      authGuard,
      roleGuard([
        'ROLE_ADMIN',
        'ROLE_OPERATOR'
      ])
    ]
  },

  {
    path: 'movimientos/editar/:id',
    component: MovementForm,
    canActivate: [
      authGuard,
      roleGuard([
        'ROLE_ADMIN',
        'ROLE_OPERATOR'
      ])
    ]
  },

  {
    path: 'clientes',
    component: ClientList,
    canActivate: [
      authGuard,
      roleGuard([
        'ROLE_ADMIN',
        'ROLE_DELIVERY'
      ])
    ]
  },

  {
    path: 'clientes/nuevo',
    component: ClientForm,
    canActivate: [
      authGuard,
      roleGuard([
        'ROLE_ADMIN',
        'ROLE_DELIVERY'
      ])
    ]
  },

  {
    path: 'clientes/editar/:id',
    component: ClientForm,
    canActivate: [
      authGuard,
      roleGuard([
        'ROLE_ADMIN',
        'ROLE_DELIVERY'
      ])
    ]
  },

  {
    path: '**',
    redirectTo: 'login'
  }

];