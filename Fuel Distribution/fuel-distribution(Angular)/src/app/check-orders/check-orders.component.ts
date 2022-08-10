import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-check-orders',
  templateUrl: './check-orders.component.html',
  styleUrls: ['./check-orders.component.css']
})
export class CheckOrdersComponent implements OnInit {


  id:number=0;
  res: any;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    // this.http
    //   .get('http://localhost:9090/checkOrders/'+this.id)
    //   .subscribe((Response) => {
    //     console.log(Response);
    //     this.res=Response;
    //   });
  }

  onCheck(){
    console.log("Checked"+this.id);
    this.http
    .get('http://localhost:9090/checkOrders/'+this.id)
    .subscribe((Response) => {
      console.log(Response);
      this.res=Response;
    });

  }


}
