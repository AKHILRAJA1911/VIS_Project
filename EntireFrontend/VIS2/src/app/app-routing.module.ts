import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AdminLoginComponent } from './admin-login/admin-login.component';
import { HomePageComponent } from './home-page/home-page.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { AddVehicleComponent } from './add-vehicle/add-vehicle.component';
import { VehicleRegComponent } from './vehicle-reg/vehicle-reg.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';


const routes: Routes = [

  {path:'',component:HomePageComponent},
  {path:'admin',component:AdminLoginComponent},
  {path:'user',component:UserLoginComponent},
  {path:'vehiclereg',component:VehicleRegComponent},
  {path:'addpolicy',component:AddVehicleComponent},
  {path:'listallpolicies',component:VehicleListComponent}
  
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
