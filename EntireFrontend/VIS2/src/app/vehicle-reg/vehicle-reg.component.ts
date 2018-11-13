import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vehicle-reg',
  templateUrl: './vehicle-reg.component.html',
  styleUrls: ['./vehicle-reg.component.css']
})
export class VehicleRegComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit() {
  }

  newpolicy(){
    this.route.navigate(['addpolicy']);
  }
  listpolicy(){
    this.route.navigate(['listallpolicies']);
  }
updatepolicy(){
  this.route.navigate(['updatepolicies']);
}

}
