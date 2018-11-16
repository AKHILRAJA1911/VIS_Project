import { Component, OnInit } from '@angular/core';
import { Theft } from '../models/theft';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-allclaims-list2',
  templateUrl: './allclaims-list2.component.html',
  styleUrls: ['./allclaims-list2.component.css']
})
export class AllclaimsList2Component implements OnInit {
theft:Theft=new Theft();
thefts:Theft[];
  constructor(private vs:VehicleService) { }


result:string=null;
claim_id:string;
  ngOnInit() {

    this.vs.theftpolicies()
    .subscribe( data => {        
      this.thefts = data;
      
    });
}
submit(result,i){
  this.result=result;
  this.vs.setStatus(this.thefts[i].claim_id).subscribe(res=>{});
 
}

submit2(result,i){
  this.result=result;
  this.vs.setStatus2(this.thefts[i].claim_id).subscribe(res=>{});
 
}


  }


