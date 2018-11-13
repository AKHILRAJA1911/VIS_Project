import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { AdminLogin } from './models/AdminLogin';
import { Vehicle } from './models/vehicle';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor(private http: HttpClient) { }


  public tryLogin(adlogin){
    
    return this.http.post('http://localhost:1212/vims/admin/login', adlogin,  {  responseType: 'text'});
  }


  public getPolicies() {
 
    return this.http.get<Vehicle[]>('http://localhost:1212/vims/vehicle/findall');
  }

 

  public createPolicy(vehicle) {
    return this.http.post<Vehicle>('http://localhost:1212/vims/vehicle/save/{custId}', vehicle);
  }

}
