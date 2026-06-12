import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { LoginRequest } from '../../models/login-request';
import { LoginResponse } from '../../models/login-response';
import { RegisterRequest } from '../../models/register-request';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly TOKEN_KEY = 'jwt_token';

  private readonly API_URL =
    'http://localhost:8081/auth';

  constructor(
    private http: HttpClient
  ) { }

  login(
    request: LoginRequest
  ): Observable<LoginResponse> {

    return this.http.post<LoginResponse>(
      `${this.API_URL}/login`,
      request
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

  logout(): void {

    localStorage.removeItem(
      this.TOKEN_KEY
    );
  }

  isAuthenticated(): boolean {

    return this.getToken() !== null;
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
}