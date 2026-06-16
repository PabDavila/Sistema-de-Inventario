import { Component } from '@angular/core';

import {
  Router,
  RouterLink
} from '@angular/router';

import { AuthService }
from '../../core/services/auth';

@Component({
  selector: 'app-dashboard',
  imports: [RouterLink],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard {

  totalProducts = 0;

  totalCategories = 0;

  totalMovements = 0;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  logout(): void {

    this.authService.logout();

    this.router.navigate([
      '/login'
    ]);
  }

}