import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Order } from '../../models/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private readonly API_URL =
    'http://localhost:8080/orders';

  constructor(
    private http: HttpClient
  ) {}

  getAll(): Observable<Order[]> {

    return this.http.get<Order[]>(
      this.API_URL
    );
  }

  getById(
    id: number
  ): Observable<Order> {

    return this.http.get<Order>(
      `${this.API_URL}/${id}`
    );
  }

  create(
    order: Order
  ): Observable<Order> {

    return this.http.post<Order>(
      this.API_URL,
      order
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