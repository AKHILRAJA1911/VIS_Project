import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-claim-mainpage',
  templateUrl: './claim-mainpage.component.html',
  styleUrls: ['./claim-mainpage.component.css']
})
export class ClaimMainpageComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit() {
  }

  accident(){
    this.route.navigate(['accident']);
  }

  theft(){
    this.route.navigate(['theft']);
  }

  accidentlist(){
    this.route.navigate(['accidentlist']);
  }

  theftlist(){
    this.route.navigate(['theftlist']);
  }






  paypremium(){
    this.route.navigate(['usermain']);
  }
  
  
  claimpolicy(){
    this.route.navigate(['claimpolicy']);
  }
  
  cancelpolicy(){
    this.route.navigate(['cancelpolicy']);
  }



}
