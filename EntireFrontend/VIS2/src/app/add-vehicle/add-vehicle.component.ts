import { Component, OnInit } from '@angular/core';
import { VehicleService } from '../vehicle.service';
import { Router } from '@angular/router';
import { Vehicle } from '../models/vehicle';


@Component({
  selector: 'app-add-vehicle',
  templateUrl: './add-vehicle.component.html',
  styleUrls: ['./add-vehicle.component.css']
})
export class AddVehicleComponent {
  vehicle:Vehicle=new Vehicle();

  constructor(private router: Router,private vs:VehicleService) { }

  createPolicy() {
    this.vs.createPolicy(this.vehicle)
        .subscribe( data => {
        alert(data);
          
        });

  };

}
