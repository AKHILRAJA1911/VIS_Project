import { Component, OnInit } from '@angular/core';
import { Cancel } from '../models/cancel';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-cancel-list',
  templateUrl: './cancel-list.component.html',
  styleUrls: ['./cancel-list.component.css']
})
export class CancelListComponent implements OnInit {
  customer_id:string;
  cancel:Cancel=new Cancel();
  cancels:Cancel[];
  constructor(private vs:VehicleService) {} 

  cancellist(){
    this.vs.cancellist(this.customer_id)
    .subscribe( data => {        
    this.cancels=data;
 
    });
    }


  onSubmit() {
    this.cancellist();
  }

  ngOnInit() {
    this.customer_id=null;
  }

}
