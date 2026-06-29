import { Component } from '@angular/core';

import { FormsModule } from '@angular/forms';

import { AuthService } from '../../core/services/auth';

@Component({
  selector: 'app-users',
  imports: [FormsModule],
  templateUrl: './users.html',
  styleUrl: './users.css'
})
export class Users {

  username = '';

  password = '';

  role = 'ROLE_OPERATOR';

  constructor(
    private authService: AuthService
  ) {}

  createUser(): void {

    this.authService.register({

      username: this.username,

      password: this.password,

      role: this.role

    }).subscribe({

      next: () => {

        alert(
          'Usuario creado correctamente'
        );

        this.username = '';

        this.password = '';

        this.role =
          'ROLE_OPERATOR';
      },

      error: (err) => {

        console.error(err);

        alert(
          'Error al crear usuario'
        );
      }
    });
  }

}