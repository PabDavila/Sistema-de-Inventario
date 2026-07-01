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
  ActivatedRoute,
  Router
} from '@angular/router';

import {
  CommonModule
} from '@angular/common';

import {
  ProductService
} from '../../../core/services/product';

import {
  CategoryService
} from '../../../core/services/category';

import {
  Category
} from '../../../models/category';

@Component({
  selector: 'app-product-form',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './product-form.html'
})
export class ProductForm
implements OnInit {

  form: FormGroup;

  categories: Category[] = [];

  productId?: number;

  constructor(
    private fb: FormBuilder,
    private productService: ProductService,
    private categoryService: CategoryService,
    private route: ActivatedRoute,
    private router: Router
  ) {

    this.form = this.fb.group({

      name: [
        '',
        Validators.required
      ],

      description: [
        '',
        Validators.required
      ],

      stock: [
        0,
        Validators.required
      ],

      price: [
        0,
        Validators.required
      ],

      categoryId: [
        '',
        Validators.required
      ]
    });
  }

  ngOnInit(): void {

    this.loadCategories();

    const id =
      this.route.snapshot.paramMap.get('id');

    if (id) {

      this.productId = +id;

      this.loadProduct();
    }
  }

  loadCategories(): void {

    this.categoryService
      .getAll()
      .subscribe(data => {

        this.categories = data;
      });
  }

  loadProduct(): void {

    this.productService
      .getById(this.productId!)
      .subscribe(product => {

        this.form.patchValue(product);
      });
  }

  save(): void {

    if (this.form.invalid) {
      return;
    }

    if (this.productId) {

      this.productService
        .update(
          this.productId,
          this.form.value
        )
        .subscribe(() => {

          this.router.navigate([
            '/productos'
          ]);
        });

    } else {

      this.productService
        .create(
          this.form.value
        )
        .subscribe(() => {

          this.router.navigate([
            '/productos'
          ]);
        });
    }
  }
}