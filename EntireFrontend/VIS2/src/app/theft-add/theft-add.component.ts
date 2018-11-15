import { Component, OnInit } from '@angular/core';
import { Theft } from '../models/theft';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-theft-add',
  templateUrl: './theft-add.component.html',
  styleUrls: ['./theft-add.component.css']
})
export class TheftAddComponent implements OnInit {
policy_id:string;
  theft:Theft=new Theft();
  constructor(private vs:VehicleService) { }

  savetheft(){
    this.vs.savetheft(this.theft)
          .subscribe( data => {
          alert(data);
            
          });
  
    }


  theftcheck(){
    this.vs.theftcheck(this.theft)
    .subscribe( data => {        
      alert(data);
    });
  }

  onSubmit() {
    this.theftcheck();
  }
  ngOnInit(){
   this.policy_id=null;
  }
}
