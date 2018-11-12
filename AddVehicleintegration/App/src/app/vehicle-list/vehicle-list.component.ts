import { Component, OnInit } from '@angular/core';
import { Vehicle } from '../model/vehicle.model';
import { VehicleService } from '../vehicle.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.css']
})
export class VehicleListComponent implements OnInit {

vehicles:Vehicle[];


  constructor(private router: Router, private vs: VehicleService) { }

  ngOnInit() {

    this.vs.getPolicies()
      .subscribe( data => {        
        this.vehicles = data;
      });
  };



  }


