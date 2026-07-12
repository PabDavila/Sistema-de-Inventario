import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { OrderDetail } from '../../models/order-detail';

@Injectable({
  providedIn: 'root'
})
export class OrderDetailService {

  private readonly API_URL =
    '/api/order-details';

  constructor(
    private http: HttpClient
  ) {}

  create(
    detail: OrderDetail
  ): Observable<any> {

    return this.http.post(
      this.API_URL,
      detail
    );
  }

  getByOrder(
    orderId: number
  ): Observable<any[]> {

    return this.http.get<any[]>(
      `${this.API_URL}/order/${orderId}`
    );
  }
}