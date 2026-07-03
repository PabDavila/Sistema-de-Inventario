import { Component, OnInit } from '@angular/core';

import { CommonModule } from '@angular/common';

import { ActivatedRoute } from '@angular/router';

import { OrderService } from '../../../core/services/order';

import { OrderDetailService } from '../../../core/services/order-detail';

import { Order } from '../../../models/order';

@Component({
  selector: 'app-order-detail',
  standalone: true,
  imports: [
    CommonModule
  ],
  templateUrl: './order-detail.html'
})
export class OrderDetail
implements OnInit {

  order?: Order;

  details: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private orderService: OrderService,
    private orderDetailService: OrderDetailService
  ) {}

  ngOnInit(): void {

    const id =
      Number(
        this.route.snapshot.paramMap.get('id')
      );

    this.orderService
      .getById(id)
      .subscribe(order => {

        this.order = order;
      });

    this.orderDetailService
      .getByOrder(id)
      .subscribe(details => {

        this.details = details;
      });
  }
}