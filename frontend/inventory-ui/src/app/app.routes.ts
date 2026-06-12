import { Routes } from '@angular/router';

import { Login } from './pages/login/login';
import { Users } from './pages/users/users';
import { Dashboard } from './pages/dashboard/dashboard';
import { Products } from './pages/products/products';
import { Categories } from './pages/categories/categories';
import { Movements } from './pages/movements/movements';

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
    path: 'users',
    component: Users,
    canActivate: [authGuard]
  },

  {
    path: 'dashboard',
    component: Dashboard,
    canActivate: [authGuard]
  },

  {
    path: 'products',
    component: Products,
    canActivate: [authGuard]
  },

  {
    path: 'categories',
    component: Categories,
    canActivate: [authGuard]
  },

  {
    path: 'movements',
    component: Movements,
    canActivate: [authGuard]
  },

  {
    path: '**',
    redirectTo: 'login'
  }

];