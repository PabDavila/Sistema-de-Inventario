import { Component } from '@angular/core';

import { CommonModule } from '@angular/common';

import {
  RouterLink
} from '@angular/router';

import { Client } from '../../../models/client';

import {
  ClientService
} from '../../../core/services/client';

@Component({
  selector: 'app-client-list',
  standalone: true,
  imports: [
    CommonModule,
    RouterLink
  ],
  templateUrl: './client-list.html'
})
export class ClientList {

  clients: Client[] = [];

  constructor(
    private clientService: ClientService
  ) {}

  ngOnInit(): void {

    this.loadClients();
  }

  loadClients(): void {

    this.clientService
      .getAll()
      .subscribe(data => {

        this.clients = data;
      });
  }

  deleteClient(
    id: number
  ): void {

    this.clientService
      .delete(id)
      .subscribe(() => {

        this.loadClients();
      });
  }
}