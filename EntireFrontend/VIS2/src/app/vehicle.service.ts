import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { AdminLogin } from './models/AdminLogin';
import { Vehicle } from './models/vehicle';
import { Observable } from 'rxjs';
import { Customer } from './models/customer';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor(private http: HttpClient) { }

//  admin login
  public tryLogin(adlogin){
    
    return this.http.post('http://localhost:1212/vims/admin/login', adlogin,  { responseType: 'text'});
  }

// list of vehicle policies 
  public getPolicies() {
 
    return this.http.get<Vehicle[]>('http://localhost:1212/vims/vehicle/findall');
  }

 // vehicle registration

  public createPolicy(vehicle){

    return this.http.post('http://localhost:1212/vims/vehicle/save',vehicle, { responseType: 'text' as 'text'});
  }

  // user registration
  public userlogin(customer){

    return this.http.post('http://localhost:1212/vims/customer',customer,{ responseType: 'text' as 'text'})

  }
  
  // user login
 public login(customer){

   return this.http.post('http://localhost:1212/vims/customer/login',customer,  { responseType: 'text' as 'text'});
 }


}
