import {
  Component,
  OnInit
} from '@angular/core';

import { CommonModule } from '@angular/common';

import { Product } from '../../models/product';

import { ProductService } from '../../core/services/product';

@Component({
  selector: 'app-products',
  imports: [CommonModule],
  templateUrl: './products.html',
  styleUrl: './products.css'
})
export class Products
implements OnInit {

  products: Product[] = [];

  constructor(
    private productService: ProductService
  ) {}

  ngOnInit(): void {

    this.loadProducts();
  }

  loadProducts(): void {

    this.productService
      .getAll()
      .subscribe({

        next: (data) => {

          this.products = data;
        },

        error: (err) => {

          console.error(err);
        }
      });
  }

}