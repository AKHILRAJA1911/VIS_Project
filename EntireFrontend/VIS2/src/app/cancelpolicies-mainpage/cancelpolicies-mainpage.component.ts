import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cancelpolicies-mainpage',
  templateUrl: './cancelpolicies-mainpage.component.html',
  styleUrls: ['./cancelpolicies-mainpage.component.css']
})
export class CancelpoliciesMainpageComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit() {
  }

  cancelapolicy(){
    this.route.navigate(['cancelrequest']);
  }

  duecancelpolicy(){
    this.route.navigate(['duecancellation']);
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




}
