import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { User } from '../../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly API_URL =
    'http://localhost:8080/users';

  constructor(
    private http: HttpClient
  ) {}

  getAll(): Observable<User[]> {

    return this.http.get<User[]>(
      this.API_URL
    );
  }

  delete(
    id: number
  ): Observable<void> {

    return this.http.delete<void>(
      `${this.API_URL}/${id}`
    );
  }
}