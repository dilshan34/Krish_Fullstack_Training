import { Component, Input, OnInit } from '@angular/core';
import { dispatchOrder } from './dispatch-orders.service';
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
  res: any;
  even: any;
  //fuel: dispatchOrder = new dispatchOrder(0);

  @Input() getId: number = 0;

  myClickFunction(event: Event) {
    this.even = event;
    console.log('hi ' + this.even);
    this.allOrders(this.even);
    window.location.reload();
  }

  constructor(
    private http: HttpClient,
    private service: DispatchOrdersService,
  ) {}
  ngOnInit(): void {
    this.http
      .get('http://localhost:9090/dispatchorders')
      .subscribe((Response) => {
        console.log(Response,"========");
        this.res = Response;
      });
  }

  public allOrders(res: any): void {
    this.service.dispatchOrder(res).subscribe(
      (res) => {
        // alert('Your Order dispatched successfully.');
      },
      (err) => {
        alert(err);
      }
    );
  }
}
