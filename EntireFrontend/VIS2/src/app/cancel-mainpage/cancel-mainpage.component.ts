import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cancel-mainpage',
  templateUrl: './cancel-mainpage.component.html',
  styleUrls: ['./cancel-mainpage.component.css']
})
export class CancelMainpageComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit() {
  }

  cancel(){
    this.route.navigate(['addcancel']);
  }

  cancellist(){
    this.route.navigate(['cancellist']);
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
