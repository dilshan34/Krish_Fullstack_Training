import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export class Fuel{
  constructor(
  public  f_name:string,
   public f_id:number,
   public f_capacity:number,
   public f_type:string,
    ){}
}


@Injectable({
  providedIn: 'root',
})
export class FuelRegisterService {
  constructor(private http: HttpClient) {}

  public createOrder(fuel:object){
    console.log(fuel);

    return this.http.post<Fuel>('http://localhost:9090/createorder', fuel);
  }
}
