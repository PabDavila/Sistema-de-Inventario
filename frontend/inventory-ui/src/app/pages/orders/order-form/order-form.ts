import { Component, OnInit } from '@angular/core';

import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule,
  FormsModule
} from '@angular/forms';

import {
  Router,
  ActivatedRoute
} from '@angular/router';

import {
  ClientService
} from '../../../core/services/client';

import {
  OrderService
} from '../../../core/services/order';

import {
  ProductService
} from '../../../core/services/product';

import {
  OrderDetailService
} from '../../../core/services/order-detail';

import {
  Client
} from '../../../models/client';

import {
  Product
} from '../../../models/product';

import {
  CommonModule
} from '@angular/common';

@Component({
  selector: 'app-order-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './order-form.html'
})
export class OrderForm
  implements OnInit {

  form: FormGroup;

  clients: Client[] = [];

  products: Product[] = [];

  details: any[] = [];

  selectedProductId = 0;

  selectedQuantity = 1;

  isEditMode = false;

  orderId = 0;

  constructor(
    private fb: FormBuilder,
    private orderService: OrderService,
    private orderDetailService: OrderDetailService,
    private clientService: ClientService,
    private productService: ProductService,
    private router: Router,
    private route: ActivatedRoute
  ) {

    this.form = this.fb.group({

      clientId: [
        '',
        Validators.required
      ],

      status: [
        'PENDING'
      ],

      observation: [
        ''
      ]
    });
  }

  ngOnInit(): void {

    this.clientService
      .getAll()
      .subscribe(data => {

        this.clients = data;
      });

    this.productService
      .getAll()
      .subscribe(data => {

        this.products = data;
      });

    const id =
      this.route.snapshot.paramMap.get('id');

    if (id) {

      this.isEditMode = true;

      this.orderId = +id;

      this.orderService
        .getById(this.orderId)
        .subscribe(order => {

          this.form.patchValue(order);

          this.form
            .get('clientId')
            ?.disable();
        });

      this.orderDetailService
        .getByOrder(this.orderId)
        .subscribe(details => {

          this.details = details;
        });
    }
  }

  addProduct(): void {

    if (this.isEditMode) {
      return;
    }

    const product =
      this.products.find(
        p => p.id === Number(this.selectedProductId)
      );

    if (!product) {
      return;
    }

    this.details.push({

      productId:
        product.id,

      productName:
        product.name,

      quantity:
        this.selectedQuantity
    });

    this.selectedProductId = 0;

    this.selectedQuantity = 1;
  }

  save(): void {

    if (
      this.form.invalid
    ) {
      return;
    }

    if (this.isEditMode) {

      const data = {

        status:
          this.form.get('status')?.value,

        observation:
          this.form.get('observation')?.value,

        clientId:
          this.form.getRawValue().clientId
      };

      this.orderService
        .update(
          this.orderId,
          data
        )
        .subscribe(() => {

          this.router.navigate([
            '/orders'
          ]);
        });

      return;
    }

    if (
      this.details.length === 0
    ) {

      alert(
        'Debe agregar al menos un producto'
      );

      return;
    }

    this.orderService
      .create(
        this.form.value
      )
      .subscribe(order => {

        let pending =
          this.details.length;

        for (
          const detail
          of this.details
        ) {

          this.orderDetailService
            .create({

              orderId:
                order.id!,

              productId:
                detail.productId,

              quantity:
                detail.quantity

            })
            .subscribe({

              next: () => {

                pending--;

                if (
                  pending === 0
                ) {

                  this.router.navigate([
                    '/orders'
                  ]);
                }
              }
            });
        }
      });
  }
}