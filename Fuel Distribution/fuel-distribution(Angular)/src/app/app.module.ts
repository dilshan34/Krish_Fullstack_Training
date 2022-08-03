import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateOrderComponent } from './create-order/create-order.component';
import { DispatchOrdersComponent } from './dispatch-orders/dispatch-orders.component';
import { AllOrdersComponent } from './all-orders/all-orders.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'

@NgModule({
  declarations: [
    AppComponent,
    CreateOrderComponent,
    DispatchOrdersComponent,
    AllOrdersComponent
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
      { path: '', redirectTo: 'create',pathMatch:'full' },

    ]),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }