import { Component, OnInit } from '@angular/core';
import { Accident } from '../models/accident';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-allclaims-list',
  templateUrl: './allclaims-list.component.html',
  styleUrls: ['./allclaims-list.component.css']
})
export class AllclaimsListComponent implements OnInit {
  accident:Accident=new Accident();
  accidents:Accident[];
  constructor(private vs:VehicleService) { }

  result:string=null;
  claim_id:string;
  ngOnInit() {

    this.vs.accidentpolicies()
    .subscribe( data => {        
      this.accidents = data;
      
    });
}

Accidentsubmit(result,i){
  this.result=result;
  this.vs.accidentsetStatus(this.accidents[i].claim_id).subscribe(res=>{});
 
}

Accidentsubmit2(result,i){
  this.result=result;
  this.vs.accidentsetStatus2(this.accidents[i].claim_id).subscribe(res=>{});
 
}

  }


