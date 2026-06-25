import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

import { AuthService } from '../../core/services/auth';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

  username = '';
  password = '';

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  login(): void {

    this.authService.login({

      username: this.username,
      password: this.password

    }).subscribe({

      next: (response) => {

        this.authService.saveToken(
          response.token
        );

        this.authService.saveRole(
          response.role
        );

        this.router.navigate([
          '/dashboard'
        ]);
      },

      error: () => {

        alert(
          'Usuario o contraseña incorrectos'
        );
      }
    });
  }
}