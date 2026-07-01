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
  CategoryService
} from '../../../core/services/category';

@Component({
  selector: 'app-category-form',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './category-form.html'
})
export class CategoryForm
implements OnInit {

  form: FormGroup;

  categoryId?: number;

  constructor(
    private fb: FormBuilder,
    private service: CategoryService,
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
      ]
    });
  }

  ngOnInit(): void {

    const id =
      this.route.snapshot.paramMap.get('id');

    if (id) {

      this.categoryId = +id;

      this.loadCategory();
    }
  }

  loadCategory(): void {

    this.service
      .getById(this.categoryId!)
      .subscribe(category => {

        this.form.patchValue(category);
      });
  }

  save(): void {

    if (this.form.invalid) {
      return;
    }

    if (this.categoryId) {

      this.service
        .update(
          this.categoryId,
          this.form.value
        )
        .subscribe(() => {

          this.router.navigate([
            '/categorias'
          ]);
        });

    } else {

      this.service
        .create(
          this.form.value
        )
        .subscribe(() => {

          this.router.navigate([
            '/categorias'
          ]);
        });
    }
  }
}