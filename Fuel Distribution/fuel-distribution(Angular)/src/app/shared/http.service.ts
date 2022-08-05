import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DispatchOrders } from '../dispatch-orders/dispatch-orders.model';


@Injectable({
  providedIn: 'root',
})
export class HttpService {
  getAllDispatchOrders(): Observable<DispatchOrders[]> {
    throw new Error('Method not implemented.');
  }
 private employeeUrl: string = 'http://localhost:9090/dispatchorders';

  constructor(private http: HttpClient) {}

  getDispatchOrders() :Observable<DispatchOrders[]>{

    return this.http.get<DispatchOrders[]>(this.employeeUrl);
  }
}
