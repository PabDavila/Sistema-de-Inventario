import {
  Component,
  OnInit
} from '@angular/core';

import { CommonModule } from '@angular/common';

import { Category } from '../../models/category';

import { CategoryService } from '../../core/services/category';

@Component({
  selector: 'app-categories',
  imports: [CommonModule],
  templateUrl: './categories.html',
  styleUrl: './categories.css'
})
export class Categories
implements OnInit {

  categories: Category[] = [];

  constructor(
    private categoryService: CategoryService
  ) {}

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

}