import { Component } from '@angular/core';

import { OnInit } from '@angular/core';

import { ProductService }
  from '../../core/services/product';

import { CategoryService }
  from '../../core/services/category';

import { MovementService }
  from '../../core/services/movement';
import { Movement } from '../../models/movement';

import { OrderService }
  from '../../core/services/order';

import { Order }
  from '../../models/order';

import { CommonModule } from '@angular/common';

import {
  Router,
  RouterLink
} from '@angular/router';

import { AuthService }
  from '../../core/services/auth';



@Component({
  selector: 'app-dashboard',
  imports: [RouterLink, CommonModule],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard implements OnInit {

  totalProducts = 0;

  totalCategories = 0;

  totalMovements = 0;

  totalOrders = 0;

  recentMovements: Movement[] = [];

  recentOrders: Order[] = [];

  constructor(

    private authService: AuthService,

    private router: Router,

    private productService: ProductService,

    private categoryService: CategoryService,

    private movementService: MovementService,

    private orderService: OrderService

  ) { }

  logout(): void {

    this.authService.logout();

    this.router.navigate([
      '/login'
    ]);
  }

  ngOnInit(): void {

    this.loadDashboard();

    this.movementService
      .getAll()
      .subscribe(data => {

        this.recentMovements = data
          .sort((a, b) =>
            new Date(b.movementDate).getTime() -
            new Date(a.movementDate).getTime()
          )
          .slice(0, 5);

      });

    this.orderService
      .getAll()
      .subscribe(data => {

        this.recentOrders = data
          .sort((a, b) =>
            new Date(
              b.orderDate ?? ''
            ).getTime()
            -
            new Date(
              a.orderDate ?? ''
            ).getTime()
          )
          .slice(0, 5);

      });

    this.orderService
      .getAll()
      .subscribe(data => {

        this.totalOrders =
          data.length;

      });

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