import { Component, OnInit } from '@angular/core';
import { Registerpay } from '../models/registerpay';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-registered-pay',
  templateUrl: './registered-pay.component.html',
  styleUrls: ['./registered-pay.component.css']
})
export class RegisteredPayComponent  {




  regpay:Registerpay=new Registerpay();

  constructor(private vs:VehicleService) { }

 registerpay(){
  this.vs.registerpay(this.regpay)
  .subscribe( data => {        
    alert(data);
  });
}
    
makePayment() {
  this.vs.makePayment(this.regpay)
      .subscribe( data => {
        alert(data);
      });

}




}
