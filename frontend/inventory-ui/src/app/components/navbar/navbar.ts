import { Component } from '@angular/core';

import { CommonModule } from '@angular/common';

import { RouterLink } from '@angular/router';

import { Router } from '@angular/router';

import { AuthService } from '../../core/services/auth';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule,
    RouterLink],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css'
})
export class Navbar {

  role: string | null;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {

    this.role =
      this.authService.getRole();

    console.log('ROL ACTUAL:', this.role);
  }

  logout(): void {

    this.authService.logout();

    this.router.navigate([
      '/login'
    ]);
  }

  isAdmin(): boolean {

    return this.role === 'ROLE_ADMIN';

  }

  isOperator(): boolean {

    return this.role === 'ROLE_OPERATOR';

  }

  isDelivery(): boolean {

    return this.role === 'ROLE_DELIVERY';

  }
}