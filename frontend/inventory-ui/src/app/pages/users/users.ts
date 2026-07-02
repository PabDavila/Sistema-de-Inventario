import { Component, OnInit } from '@angular/core';

import { FormsModule } from '@angular/forms';

import { AuthService } from '../../core/services/auth';

import { User } from '../../models/user';

import { UserService } from '../../core/services/user';

import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-users',
  imports: [CommonModule, FormsModule],
  templateUrl: './users.html',
  styleUrl: './users.css'
})
export class Users implements OnInit {

  username = '';

  password = '';

  role = 'ROLE_OPERATOR';

  users: User[] = [];

  constructor(
    private authService: AuthService,
    private userService: UserService
  ) {}

  ngOnInit(): void {

    this.loadUsers();
  }

  loadUsers(): void {

    this.userService
      .getAll()
      .subscribe(users => {

        this.users = users;
      });
  }

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

        this.loadUsers();
      },

      error: (err) => {

        console.error(err);

        alert(
          'Error al crear usuario'
        );
      }
    });
  }

  deleteUser(
    id: number
  ): void {

    if (
      !confirm(
        '¿Eliminar usuario?'
      )
    ) {
      return;
    }

    this.userService
      .delete(id)
      .subscribe(() => {

        this.loadUsers();
      });
  }
}