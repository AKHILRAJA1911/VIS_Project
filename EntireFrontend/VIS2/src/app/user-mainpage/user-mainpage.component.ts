import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../models/customer';

@Component({
  selector: 'app-user-mainpage',
  templateUrl: './user-mainpage.component.html',
  styleUrls: ['./user-mainpage.component.css']
})
export class UserMainpageComponent implements OnInit {
customer : Customer=new Customer();
  constructor(private route:Router) { }

directpay(){
this.route.navigate(['directpay']);
}

registeredpay(){
this.route.navigate(['registeredpay']);
}

paiddetails(){
this.route.navigate(['paiddetails']);
}

regpaiddetails(){
  this.route.navigate(['regpaydetails']);
}

policylist(){
  this.route.navigate(['custpolicylist']);
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





  ngOnInit() {
  }

}
