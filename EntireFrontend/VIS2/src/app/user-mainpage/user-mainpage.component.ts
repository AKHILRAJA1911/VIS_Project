import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-mainpage',
  templateUrl: './user-mainpage.component.html',
  styleUrls: ['./user-mainpage.component.css']
})
export class UserMainpageComponent implements OnInit {

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






  ngOnInit() {
  }

}
