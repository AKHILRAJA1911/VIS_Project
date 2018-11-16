import { Component, OnInit } from '@angular/core';
import { Cancel } from '../models/cancel';
import { VehicleService } from '../vehicle.service';

@Component({
  selector: 'app-cancel-add',
  templateUrl: './cancel-add.component.html',
  styleUrls: ['./cancel-add.component.css']
})
export class CancelAddComponent {
cancel:Cancel=new Cancel();
  constructor(private vs:VehicleService) { }

  cancelcheck(){
    this.vs.cancelcheck(this.cancel)
    .subscribe( data => {        
      alert(data);
    });
  }


  savecancel() {
    this.vs.savecancel(this.cancel)
        .subscribe( data => {
          alert(data);
        });
  
  }
  
}
