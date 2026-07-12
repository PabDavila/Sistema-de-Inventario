import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Client } from '../../models/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private readonly API_URL =
    '/api/clients';

  constructor(
    private http: HttpClient
  ) {}

  getAll(): Observable<Client[]> {

    return this.http.get<Client[]>(
      this.API_URL
    );
  }

  getById(
    id: number
  ): Observable<Client> {

    return this.http.get<Client>(
      `${this.API_URL}/${id}`
    );
  }

  create(
    client: Client
  ): Observable<Client> {

    return this.http.post<Client>(
      this.API_URL,
      client
    );
  }

  update(
    id: number,
    client: Client
  ): Observable<Client> {

    return this.http.put<Client>(
      `${this.API_URL}/${id}`,
      client
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