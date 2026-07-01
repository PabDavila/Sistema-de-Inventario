import {
  Component,
  OnInit
} from '@angular/core';

import { CommonModule } from '@angular/common';

import { Product } from '../../models/product';

import { ProductService } from '../../core/services/product';

import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-products',
  imports: [CommonModule, RouterLink],
  templateUrl: './products.html',
  styleUrl: './products.css'
})
export class Products
  implements OnInit {

  products: Product[] = [];

  constructor(
    private productService: ProductService
  ) { }

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

  deleteProduct(
    id: number
  ): void {

    if (
      !confirm(
        '¿Eliminar producto?'
      )
    ) {
      return;
    }

    this.productService
      .delete(id)
      .subscribe({

        next: () => {

          this.loadProducts();
        },

        error: (err) => {

          console.error(err);

          alert(
            'Error al eliminar producto'
          );
        }
      });
  }

}