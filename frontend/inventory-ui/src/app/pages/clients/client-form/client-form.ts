import {
  Component
} from '@angular/core';

import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule
} from '@angular/forms';

import {
  Router
} from '@angular/router';

import {
  ClientService
} from '../../../core/services/client';

@Component({
  selector: 'app-client-form',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './client-form.html'
})
export class ClientForm {

  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private service: ClientService,
    private router: Router
  ) {

    this.form = this.fb.group({

      name: [
        '',
        Validators.required
      ],

      email: [
        '',
        Validators.required
      ],

      phone: [
        '',
        Validators.required
      ]
    });
  }

  save(): void {

    if (
      this.form.invalid
    ) {
      return;
    }

    this.service
      .create(
        this.form.value
      )
      .subscribe(() => {

        this.router.navigate([
          '/clients'
        ]);
      });
  }
}