import { Component, OnInit } from '@angular/core';
import { Vehicle } from '../model/vehicle.model';
import { Router } from '@angular/router';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-add-vehicle',
  templateUrl: './add-vehicle.component.html',
  styleUrls: ['./add-vehicle.component.css']
})
export class AddVehicleComponent {

  vehicle:Vehicle=new Vehicle();


  constructor(private router: Router,private vs:VehicleService) { }

  createPolicy(): void {
    this.vs.createPolicy(this.vehicle)
        .subscribe( data => {
          alert("User created successfully.");
        });

  };
}




