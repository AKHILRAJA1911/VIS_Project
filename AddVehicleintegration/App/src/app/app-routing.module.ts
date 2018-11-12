import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddVehicleComponent } from './add-vehicle/add-vehicle.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { DashBoardComponent } from './dash-board/dash-board.component';

const routes: Routes = [

  {path:'',component:DashBoardComponent},
  {path:'addpolicy',component:AddVehicleComponent},
  {path:'listpolicy',component:VehicleListComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
