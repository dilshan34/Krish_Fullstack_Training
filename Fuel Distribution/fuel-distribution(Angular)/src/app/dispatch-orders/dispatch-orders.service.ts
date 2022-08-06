import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpService } from '../shared/http.service';
import { DispatchOrders } from './dispatch-orders.model';

@Injectable({
  providedIn: 'root'
})
export class DispatchOrdersService {

  constructor(private httpService:HttpService) { }

  getDispatchOrders(){
    return this.httpService.getAllDispatchOrders();
  }
}
