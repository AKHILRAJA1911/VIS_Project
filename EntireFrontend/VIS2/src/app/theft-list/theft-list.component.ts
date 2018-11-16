import { Component, OnInit } from '@angular/core';
import { Theft } from '../models/theft';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-theft-list',
  templateUrl: './theft-list.component.html',
  styleUrls: ['./theft-list.component.css']
})
export class TheftListComponent implements OnInit{
theft:Theft=new Theft();
thefts:Theft[];
customer_id:string;
  constructor(private vs:VehicleService) { }

  theftlist(){
    this.vs.theftlist(this.customer_id)
    .subscribe( data => {        
    this.thefts=data;
 
    });
    }

    ngOnInit() {
      this.customer_id = null;
     
  }
  onSubmit() {
    this.theftlist();
  }

}
