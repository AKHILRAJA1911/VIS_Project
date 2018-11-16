import { Component, OnInit } from '@angular/core';
import { Cancel } from '../models/cancel';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-allcancels-list2',
  templateUrl: './allcancels-list2.component.html',
  styleUrls: ['./allcancels-list2.component.css']
})
export class AllcancelsList2Component implements OnInit {
cancel:Cancel=new Cancel();
cancels:Cancel[];

result:string=null;
  constructor(private vs:VehicleService) { }

  ngOnInit() {

    this.vs.cancelreqpolicy()
    .subscribe( data => {        
      this.cancels = data;
      
    });

  }

}
