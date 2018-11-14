import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VehicleService } from '../vehicle.service';
import { Customer } from '../models/customer';

@Component({
  selector: 'app-user-signup',
  templateUrl: './user-signup.component.html',
  styleUrls: ['./user-signup.component.css']
})
export class UserSignupComponent {

customer:Customer=new Customer();


  constructor(private route:Router,private vs:VehicleService) { }


userlogin(){
this.vs.userlogin(this.customer)
.subscribe( data => {
alert(data);
  alert("User created successfully.");
this.route.navigate(['user'])});
}


 

}

