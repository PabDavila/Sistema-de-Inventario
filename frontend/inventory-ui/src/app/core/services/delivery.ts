import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Delivery } from '../../models/delivery';

@Injectable({
  providedIn: 'root'
})
export class DeliveryService {

  private readonly API_URL =
    'http://localhost:8080/deliveries';

  constructor(
    private http: HttpClient
  ) {}

  getAll(): Observable<Delivery[]> {

    return this.http.get<Delivery[]>(
      this.API_URL
    );
  }

  getById(
    id: number
  ): Observable<Delivery> {

    return this.http.get<Delivery>(
      `${this.API_URL}/${id}`
    );
  }

  create(
    delivery: Delivery
  ): Observable<Delivery> {

    return this.http.post<Delivery>(
      this.API_URL,
      delivery
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