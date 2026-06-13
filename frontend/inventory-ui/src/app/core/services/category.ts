import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Category } from '../../models/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private readonly API_URL =
    'http://localhost:8082/categories';

  constructor(
    private http: HttpClient
  ) {}

  getAll(): Observable<Category[]> {

    return this.http.get<Category[]>(
      this.API_URL
    );
  }

  create(
    category: Category
  ): Observable<Category> {

    return this.http.post<Category>(
      this.API_URL,
      category
    );
  }

}