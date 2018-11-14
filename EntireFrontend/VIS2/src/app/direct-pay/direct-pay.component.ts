import { Component, OnInit } from '@angular/core';
import { Directpay } from '../models/directpay';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-direct-pay',
  templateUrl: './direct-pay.component.html',
  styleUrls: ['./direct-pay.component.css']
})
export class DirectPayComponent{
  directpay:Directpay=new Directpay();
  constructor(private vs:VehicleService) { }

 direct(){
   this.vs.direct(this.directpay)
   .subscribe( data => {
    alert(data);
   });
 }


}


