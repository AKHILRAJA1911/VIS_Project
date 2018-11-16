import { Component, OnInit } from '@angular/core';
import { Accident } from '../models/accident';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-accident-list',
  templateUrl: './accident-list.component.html',
  styleUrls: ['./accident-list.component.css']
})
export class AccidentListComponent implements OnInit {
accident:Accident=new Accident();
accidents:Accident[];
customer_id:string;
  constructor(private vs:VehicleService) { }


  accidentlist(){
    this.vs.accidentlist(this.customer_id)
    .subscribe( data => {        
     this.accidents=data;
    });
    }
    ngOnInit() {
      this.customer_id = null;
     
  }

    onSubmit() {
      this.accidentlist();
    }
}
