import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Vehicle } from './model/vehicle.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor(private http:HttpClient) { }

  private userUrl = 'http://localhost:8090/vehiclemodule/vehicle/list';
  private userUrl1 = 'http://localhost:8090/vehiclemodule/vehicle/create';


  public getPolicies() {
    alert("invoking getPolicies");
    return this.http.get<Vehicle[]>(this.userUrl);
  }

 

  public createPolicy(vehicle) {
    return this.http.post<Vehicle>(this.userUrl1, vehicle);
  }

}



