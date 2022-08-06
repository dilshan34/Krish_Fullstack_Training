import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-all-orders',
  templateUrl: './all-orders.component.html',
  styleUrls: ['./all-orders.component.css'],
})
export class AllOrdersComponent implements OnInit {
  res: any;
  size: number = 0;
  pending: number = 0;
  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.http.get('http://localhost:9090/allorders').subscribe((Response) => {
      console.log(Response);
      this.res = Response;
      this.size = Object.keys(Response).length;
    });

    this.http
      .get('http://localhost:9090/dispatchorders')
      .subscribe((Response) => {
        console.log(Response);
        this.pending = Object.keys(Response).length;
      });
  }
}
