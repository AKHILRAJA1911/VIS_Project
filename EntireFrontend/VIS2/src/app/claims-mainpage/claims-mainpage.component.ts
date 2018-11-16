import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-claims-mainpage',
  templateUrl: './claims-mainpage.component.html',
  styleUrls: ['./claims-mainpage.component.css']
})
export class ClaimsMainpageComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit() {
  }
 
  vehiclereg(){
    this.route.navigate(['vehiclereg']);
  }

  claims(){
    this.route.navigate(['claims']);
  }

  cancelpolicies(){
    this.route.navigate(['cancelpolicies']);
  }




  accidentclaimslist(){
    this.route.navigate(['accidentclaimslist']);
  }

  theftclaimslist(){
    this.route.navigate(['theftclaimslist']);
  }


}
