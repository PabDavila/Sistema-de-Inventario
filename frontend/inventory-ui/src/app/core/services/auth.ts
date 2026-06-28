import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { LoginResponse } from '../../models/login-response';
import { RegisterRequest } from '../../models/register-request';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly TOKEN_KEY = 'jwt_token';

  private readonly ROLE_KEY = 'user_role';

  private readonly API_URL =
    'http://localhost:8080/auth';

  constructor(
    private http: HttpClient
  ) {}

  login(credentials: any) {

    return this.http.post<LoginResponse>(
      `${this.API_URL}/login`,
      credentials
    );
  }

  register(
    request: RegisterRequest
  ) {

    return this.http.post(
      `${this.API_URL}/register`,
      request,
      {
        responseType: 'text'
      }
    );
  }

  saveToken(token: string): void {

    localStorage.setItem(
      this.TOKEN_KEY,
      token
    );
  }

  getToken(): string | null {

    return localStorage.getItem(
      this.TOKEN_KEY
    );
  }

  saveRole(role: string): void {

    localStorage.setItem(
      this.ROLE_KEY,
      role
    );
  }

  getRole(): string | null {

    return localStorage.getItem(
      this.ROLE_KEY
    );
  }

  logout(): void {

    localStorage.removeItem(
      this.TOKEN_KEY
    );

    localStorage.removeItem(
      this.ROLE_KEY
    );
  }

  isAuthenticated(): boolean {

    return this.getToken() !== null;
  }
}