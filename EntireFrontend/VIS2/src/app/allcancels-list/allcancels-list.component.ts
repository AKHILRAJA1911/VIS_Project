import { Component, OnInit } from '@angular/core';
import { Cancel } from '../models/cancel';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-allcancels-list',
  templateUrl: './allcancels-list.component.html',
  styleUrls: ['./allcancels-list.component.css']
})
export class AllcancelsListComponent implements OnInit {
cancel:Cancel=new Cancel();
cancels:Cancel[];

  result:string=null;
  constructor(private vs:VehicleService) { }

  ngOnInit() {

    this.vs.cancelpolicy()
    .subscribe( data => {        
      this.cancels = data;
      
    });


  }

}
