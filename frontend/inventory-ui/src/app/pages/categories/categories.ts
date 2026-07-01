import {
  Component,
  OnInit
} from '@angular/core';

import { CommonModule } from '@angular/common';

import { Category } from '../../models/category';

import { CategoryService } from '../../core/services/category';

import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-categories',
  imports: [CommonModule, RouterLink],
  templateUrl: './categories.html',
  styleUrl: './categories.css'
})
export class Categories
  implements OnInit {

  categories: Category[] = [];

  constructor(
    private categoryService: CategoryService
  ) { }

  ngOnInit(): void {

    this.loadCategories();
  }

  loadCategories(): void {

    this.categoryService
      .getAll()
      .subscribe({

        next: (data) => {

          this.categories = data;
        },

        error: (err) => {

          console.error(err);
        }
      });
  }

  deleteCategory(
    id: number
  ): void {

    if (
      !confirm(
        '¿Eliminar categoría?'
      )
    ) {
      return;
    }

    this.categoryService
      .delete(id)
      .subscribe({

        next: () => {

          this.loadCategories();
        },

        error: (err) => {

          console.error(err);

          alert(
            'Error al eliminar categoría'
          );
        }
      });
  }

}