import { Component, OnInit } from '@angular/core';
import { VehicleService } from '../vehicle.service';
import { Theft } from '../models/theft';
import { Accident } from '../models/accident';

@Component({
  selector: 'app-accident-add',
  templateUrl: './accident-add.component.html',
  styleUrls: ['./accident-add.component.css']
})
export class AccidentAddComponent implements OnInit {

  policy_id:string;

accident:Accident=new Accident();
accidents:Accident[];
  constructor(private vs:VehicleService) { }

 saveaccident(){
  this.vs.saveaccident(this.accident)
        .subscribe( data => {
        alert(data);
          
        });

  }
 

accidentcheck(){
  this.vs.accidentcheck(this.accident)
  .subscribe( data => {        
    alert(data);
  });
}

onSubmit() {
  this.accidentcheck();
}
ngOnInit(){
 this.policy_id=null;
}



}


