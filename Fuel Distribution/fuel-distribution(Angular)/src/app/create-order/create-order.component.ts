import { Component, OnInit } from '@angular/core';
import { Fuel } from '../fuel-register.service';
import { FuelRegisterService } from '../fuel-register.service';

@Component({
  selector: 'app-create-order',
  templateUrl: './create-order.component.html',
  styleUrls: ['./create-order.component.css'],
})
export class CreateOrderComponent implements OnInit {

  fuel: Fuel = new Fuel("", 0, 0, "");

  message: any;
  constructor(private service: FuelRegisterService) {}

  ngOnInit() {}

  public createOrderNow():void {
     this.service.createOrder(this.fuel).subscribe(
      (res)=>{
        alert("Your Order created successfully.");
        window.location.reload();
      },
      (err)=>{
        alert(err);

      }
     )
  }
}
