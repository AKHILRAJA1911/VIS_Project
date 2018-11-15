import { Component, OnInit } from '@angular/core';
import { Directpay } from '../models/directpay';
import { VehicleService } from '../vehicle.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-paid-details',
  templateUrl: './paid-details.component.html',
  styleUrls: ['./paid-details.component.css']
})
export class PaidDetailsComponent implements OnInit {
directpay:Directpay=new Directpay();
  directpays:Directpay[];

  policy_id:string;
  constructor(private route:Router,private vs:VehicleService) { }

  ngOnInit() {
    this.policy_id = null;
   
}
private paiddetails(){
this.vs.paiddetails(this.policy_id)
.subscribe( data => {        
  this.directpays = data;
});
}
onSubmit() {
  this.paiddetails();
}

}