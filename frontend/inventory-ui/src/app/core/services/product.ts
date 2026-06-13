import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Product } from '../../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private readonly API_URL =
    'http://localhost:8082/products';

  constructor(
    private http: HttpClient
  ) {}

  getAll(): Observable<Product[]> {

    return this.http.get<Product[]>(
      this.API_URL
    );
  }

  create(
    product: Product
  ): Observable<Product> {

    return this.http.post<Product>(
      this.API_URL,
      product
    );
  }

}