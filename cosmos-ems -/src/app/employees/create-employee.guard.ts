import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  RouterStateSnapshot,
  UrlTree,
} from '@angular/router';
import { Observable, of } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class CreateEmployeeGuard implements CanActivate {

  constructor(private route:Router){}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    let depId: number = Number(route.paramMap.get('id'));


    if(depId%2==0){
      alert('You are not eligible to do that')
      this.route.navigate(["/home"])
    }

    return true;
  }
}
