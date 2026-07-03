import {
  Component,
  OnInit
} from '@angular/core';

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



@Component({
  selector: 'app-client-form',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './client-form.html'
})
export class ClientForm implements OnInit {

  form: FormGroup;

  isEditMode = false;

  clientId = 0;

  constructor(
    private fb: FormBuilder,
    private service: ClientService,
    private router: Router,
    private route: ActivatedRoute
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
  ],

  address: [
    '',
    Validators.required
  ]
});
  }

  ngOnInit(): void {

    const id =
      this.route.snapshot.paramMap.get('id');

    if (id) {

      this.isEditMode = true;

      this.clientId = +id;

      this.service
        .getById(this.clientId)
        .subscribe(client => {

          this.form.patchValue(client);
        });
    }
  }

  save(): void {

    if (
      this.form.invalid
    ) {
      return;
    }

    if (this.isEditMode) {

      this.service
        .update(
          this.clientId,
          this.form.value
        )
        .subscribe(() => {

          this.router.navigate([
            '/clientes'
          ]);
        });

    } else {

      this.service
        .create(
          this.form.value
        )
        .subscribe(() => {

          this.router.navigate([
            '/clientes'
          ]);
        });
    }
  }
}