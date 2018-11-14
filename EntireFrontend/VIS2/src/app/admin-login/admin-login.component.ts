import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VehicleService } from '../vehicle.service';
import { AdminLogin } from '../models/AdminLogin';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent{

  adlogin:AdminLogin=new AdminLogin();

  
  constructor(private router: Router,private vs:VehicleService) { }

  tryLogin():void {
    this.vs.tryLogin(this.adlogin)
      .subscribe(data => {
        if(data=='login successful')
        {
          
          this.router.navigateByUrl('vehiclereg');}
          else{
            alert("Invalid Credentials");
          }
        },
      );
  }

}
