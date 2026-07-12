import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Category } from '../../models/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private readonly API_URL =
    '/api/categories';

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

  getById(
  id: number
): Observable<Category> {

  return this.http.get<Category>(
    `${this.API_URL}/${id}`
  );
}

update(
  id: number,
  category: Category
): Observable<Category> {

  return this.http.put<Category>(
    `${this.API_URL}/${id}`,
    category
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