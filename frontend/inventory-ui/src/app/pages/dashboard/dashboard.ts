import { Component } from '@angular/core';

import { OnInit } from '@angular/core';

import { ProductService }
from '../../core/services/product';

import { CategoryService }
from '../../core/services/category';

import { MovementService }
from '../../core/services/movement';

import {
  Router,
  RouterLink
} from '@angular/router';

import { AuthService }
from '../../core/services/auth';

@Component({
  selector: 'app-dashboard',
  imports: [RouterLink],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard implements OnInit {

  totalProducts = 0;

  totalCategories = 0;

  totalMovements = 0;

  constructor(

  private authService: AuthService,

  private router: Router,

  private productService: ProductService,

  private categoryService: CategoryService,

  private movementService: MovementService

) {}

  logout(): void {

    this.authService.logout();

    this.router.navigate([
      '/login'
    ]);
  }

  ngOnInit(): void {

  this.loadDashboard();

}

loadDashboard(): void {

  this.productService
    .getAll()
    .subscribe(data => {

      this.totalProducts =
        data.length;

    });

  this.categoryService
    .getAll()
    .subscribe(data => {

      this.totalCategories =
        data.length;

    });

  this.movementService
    .getAll()
    .subscribe(data => {

      this.totalMovements =
        data.length;

    });

}


}