import { Component, OnInit } from '@angular/core';
import { DispatchOrders } from './dispatch-orders.model';
import { DispatchOrdersService } from './dispatch-orders.service';
import orders from './data/dispatch-orders.json';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-dispatch-orders',
  templateUrl: './dispatch-orders.component.html',
  styleUrls: ['./dispatch-orders.component.css'],
})
export class DispatchOrdersComponent implements OnInit {
  orders: any[] = orders;
  li:any;
  lis=[];

  //constructor(private dispatchOrderService:DispatchOrdersService) { }
  constructor(private http: HttpClient) {}
  ngOnInit(): void {
    // this.dispatchOrderService.getDispatchOrders().subscribe({
    //   next: (data) => {
    //     this.orders=data;
    //     console.log(data+" json data");
    //   }
    // });

    this.http.get('http://localhost:9090/dispatchorders').subscribe(Response=>{
      console.log(Response)
      this.li=Response;
      this.lis=this.li.list;
    });

  }
}
