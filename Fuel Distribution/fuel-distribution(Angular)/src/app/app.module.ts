import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { DatePipe } from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateOrderComponent } from './create-order/create-order.component';
import { DispatchOrdersComponent } from './dispatch-orders/dispatch-orders.component';
import { AllOrdersComponent } from './all-orders/all-orders.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { CheckOrdersComponent } from './check-orders/check-orders.component'

@NgModule({
  declarations: [
    AppComponent,
    CreateOrderComponent,
    DispatchOrdersComponent,
    AllOrdersComponent,
    CheckOrdersComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule.forRoot([
      { path: 'create', component: CreateOrderComponent },
      { path: 'all', component: AllOrdersComponent },
      { path: 'dispatch', component: DispatchOrdersComponent },
      { path: 'check', component: CheckOrdersComponent },
      { path: '', redirectTo: 'create',pathMatch:'full' },

    ]),
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
