import {
  Component,
  OnInit
} from '@angular/core';

import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule
} from '@angular/forms';

import {
  Router,
  ActivatedRoute
} from '@angular/router';

import {
  ProductService
} from '../../../core/services/product';

import {
  MovementService
} from '../../../core/services/movement';

import {
  Product
} from '../../../models/product';

import {
  CommonModule
} from '@angular/common';

@Component({
  selector: 'app-movement-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './movement-form.html'
})
export class MovementForm implements OnInit {

  form: FormGroup;

  products: Product[] = [];

  movementId: number | null = null;

  isEdit = false;

  constructor(
    private readonly fb: FormBuilder,
    private readonly service: MovementService,
    private readonly productService: ProductService,
    private readonly router: Router,
    private readonly route: ActivatedRoute
  ) {

    this.form = this.fb.group({

      productId: [''],

      type: [''],

      quantity: [1],

      status: ['PENDING']
    });
  }

  ngOnInit(): void {

    const id =
      this.route.snapshot.paramMap.get('id');

    if (id) {

      this.isEdit = true;

      this.movementId =
        Number(id);

      this.service
        .getById(this.movementId)
        .subscribe(movement => {

          this.form.patchValue({

            status:
              movement.status
          });
        });

    } else {

      this.form = this.fb.group({

        productId: [
          '',
          Validators.required
        ],

        type: [
          '',
          Validators.required
        ],

        quantity: [
          1,
          Validators.required
        ]
      });

      this.productService
        .getAll()
        .subscribe(products => {

          this.products = products;
        });
    }
  }

  save(): void {

    if (this.form.invalid) {
      return;
    }

    if (
      this.isEdit &&
      this.movementId
    ) {

      this.service
        .updateStatus(
          this.movementId,
          this.form.value.status
        )
        .subscribe({

          next: () => {

            this.router.navigate([
              '/movimientos'
            ]);
          },

          error: err => {

            alert(
              err.error
            );
          }
        });

    } else {

      this.service
        .create(
          this.form.value
        )
        .subscribe(() => {

          this.router.navigate([
            '/movimientos'
          ]);
        });
    }
  }
}