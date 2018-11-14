import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AdminLoginComponent } from './admin-login/admin-login.component';
import { HomePageComponent } from './home-page/home-page.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { AddVehicleComponent } from './add-vehicle/add-vehicle.component';
import { VehicleRegComponent } from './vehicle-reg/vehicle-reg.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { UserSignupComponent } from './user-signup/user-signup.component';
import { UserMainpageComponent } from './user-mainpage/user-mainpage.component';
import { DirectPayComponent } from './direct-pay/direct-pay.component';
import { RegisteredPayComponent } from './registered-pay/registered-pay.component';
import { PaidDetailsComponent } from './paid-details/paid-details.component';
import { RegPaiddetailsComponent } from './reg-paiddetails/reg-paiddetails.component';


const routes: Routes = [

  {path:'',component:HomePageComponent},
  {path:'admin',component:AdminLoginComponent},
  {path:'user',component:UserLoginComponent},
  {path:'vehiclereg',component:VehicleRegComponent},
  {path:'addpolicy',component:AddVehicleComponent},
  {path:'listallpolicies',component:VehicleListComponent},
  {path:'signup',component:UserSignupComponent},
  {path:'usermain',component:UserMainpageComponent},
  {path:'directpay',component:DirectPayComponent},
  {path:'registeredpay',component:RegisteredPayComponent},
  {path:'paiddetails',component:PaidDetailsComponent},
  {path:'regpaiddetails',component:RegPaiddetailsComponent}
  
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
