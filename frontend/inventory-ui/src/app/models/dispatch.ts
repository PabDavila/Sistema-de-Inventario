export interface Dispatch {

  id?: number;

  orderId: number;

  status: string;

  deliveryAddress: string;

  deliveryUserId: number;

  operatorUserId: number;

  dispatchDate?: string;
}