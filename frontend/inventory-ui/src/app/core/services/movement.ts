import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Movement } from '../../models/movement';



@Injectable({
  providedIn: 'root'
})
export class MovementService {

  private readonly API_URL =
    'http://localhost:8080/movements';

  constructor(
    private http: HttpClient
  ) { }

  getAll(): Observable<Movement[]> {

    return this.http.get<Movement[]>(
      this.API_URL
    );
  }

  getByProduct(
    productId: number
  ): Observable<Movement[]> {

    return this.http.get<Movement[]>(
      `${this.API_URL}/product/${productId}`
    );
  }

  create(
    movement: Movement
  ): Observable<Movement> {

    return this.http.post<Movement>(
      this.API_URL,
      movement
    );
  }

  getById(id: number): Observable<Movement> {
    return this.http.get<Movement>(
      `${this.API_URL}/${id}`
    );
  }

  updateStatus(
    id: number,
    status: string
  ): Observable<any> {

    return this.http.put(
      `${this.API_URL}/${id}/status`,
      { status }
    );
  }
}
