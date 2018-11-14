import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../models/customer';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  customer:Customer=new Customer();
  
  constructor(private route:Router,private vs:VehicleService) { }


signup(){
  this.route.navigate(['signup']);
}

login(){
     this.vs.login(this.customer)
      .subscribe(data => {
        if(data=='login successful')
        {
         
          this.route.navigate(['usermain']);}
          else{
            if(data=='Customer not found'){
              alert(data);
            }

         
          }
        },
      );
}


  ngOnInit() {
  }

}
