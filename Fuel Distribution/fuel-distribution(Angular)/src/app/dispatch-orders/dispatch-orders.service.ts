import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpService } from '../shared/http.service';

export class dispatchOrder {
  constructor(public id: any) {}
}

@Injectable({
  providedIn: 'root',
})
export class DispatchOrdersService {
  constructor(private httpService: HttpService, private http: HttpClient) {}

  getDispatchOrders() {
    return this.httpService.getAllDispatchOrders();
  }

  public dispatchOrder(order: object) {
    console.log({ id: order, dispatch: 1 }+"----");

    return this.http.put<dispatchOrder>('http://localhost:9090/submitOrder', {
      id: order,
      dispatch: 1,
    });
  }
}
