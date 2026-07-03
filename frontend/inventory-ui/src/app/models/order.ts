export interface Order {

  id: number;

  clientId: number;

  clientName?: string;

  clientAddress?: string;

  status: string;

  observation: string;

  orderDate?: string;
}