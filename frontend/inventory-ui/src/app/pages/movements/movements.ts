import {
  Component,
  OnInit
} from '@angular/core';

import { CommonModule } from '@angular/common';

import { Movement } from '../../models/movement';

import { MovementService } from '../../core/services/movement';

@Component({
  selector: 'app-movements',
  imports: [CommonModule],
  templateUrl: './movements.html',
  styleUrl: './movements.css'
})
export class Movements
implements OnInit {

  movements: Movement[] = [];

  constructor(
    private movementService: MovementService
  ) {}

  ngOnInit(): void {

    this.loadMovements();
  }

  loadMovements(): void {

    this.movementService
      .getAll()
      .subscribe({

        next: (data) => {

          this.movements = data;
        },

        error: (err) => {

          console.error(err);
        }
      });
  }

}