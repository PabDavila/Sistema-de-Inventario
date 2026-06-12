import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

import { AuthService } from '../../core/services/auth';

@Component({
  selector: 'app-register',
  imports: [FormsModule],
  templateUrl: './register.html',
  styleUrl: './register.css'
})
export class Register {

  username = '';
  password = '';

  role = 'ROLE_EMPLOYEE';

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  register(): void {

    this.authService.register({

      username: this.username,
      password: this.password,
      role: this.role

    }).subscribe({

      next: () => {

        alert(
          'Usuario registrado'
        );

        this.router.navigate([
          '/login'
        ]);
      },

      error: () => {

        alert(
          'Error al registrar usuario'
        );
      }
    });
  }
}