import { Component, OnInit } from '@angular/core';

import { CommonModule } from '@angular/common';

import { RouterModule } from '@angular/router';

import { OrderService } from '../../core/services/order';

import { Order } from '../../models/order';

@Component({
  selector: 'app-orders',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule
  ],
  templateUrl: './orders.html'
})
export class Orders implements OnInit {

  orders: Order[] = [];

  constructor(
    private service: OrderService
  ) {}

  ngOnInit(): void {

    this.loadOrders();
  }

  loadOrders(): void {

    this.service
      .getAll()
      .subscribe(data => {

        this.orders = data;
      });
  }

  deleteOrder(
    id: number
  ): void {

    if (
      !confirm(
        '¿Eliminar pedido?'
      )
    ) {
      return;
    }

    this.service
      .delete(id)
      .subscribe(() => {

        this.loadOrders();
      });
  }
}