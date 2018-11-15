import { Component, OnInit } from '@angular/core';
import { Registerpay } from '../models/registerpay';
import { Router } from '@angular/router';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-reg-paiddetails',
  templateUrl: './reg-paiddetails.component.html',
  styleUrls: ['./reg-paiddetails.component.css']
})
export class RegPaiddetailsComponent implements OnInit {
  regpay:Registerpay=new Registerpay();
  regpays:Registerpay[];
  policy_id:string;
  constructor(private route:Router,private vs:VehicleService) { }

  ngOnInit() {
    this.policy_id = null;
  }

  private regpaiddetails(){
    this.vs.regpaiddetails(this.policy_id)
    .subscribe( data => {        
      this.regpays = data;
    });
    }

    onSubmit() {
      this.regpaiddetails();
    }


}
