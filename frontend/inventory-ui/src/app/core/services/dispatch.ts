import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Dispatch } from '../../models/dispatch';

@Injectable({
  providedIn: 'root'
})
export class DispatchService {

  private readonly API_URL =
    '/api/dispatches';

  constructor(
    private http: HttpClient
  ) {}

  getAll(): Observable<Dispatch[]> {

    return this.http.get<Dispatch[]>(
      this.API_URL
    );
  }

  getById(
    id: number
  ): Observable<Dispatch> {

    return this.http.get<Dispatch>(
      `${this.API_URL}/${id}`
    );
  }

  create(
    dispatch: Dispatch
  ): Observable<Dispatch> {

    return this.http.post<Dispatch>(
      this.API_URL,
      dispatch
    );
  }

  update(
    id: number,
    dispatch: Dispatch
  ): Observable<Dispatch> {

    return this.http.put<Dispatch>(
      `${this.API_URL}/${id}`,
      dispatch
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