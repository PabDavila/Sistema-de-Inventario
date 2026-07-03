export interface Order {

  id?: number;

  clientId: number;

  status: string;

  observation: string;

  orderDate?: string;
}