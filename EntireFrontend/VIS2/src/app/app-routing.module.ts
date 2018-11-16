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
import { CustPolicylistComponent } from './cust-policylist/cust-policylist.component';
import { ClaimMainpageComponent } from './claim-mainpage/claim-mainpage.component';
import { AccidentAddComponent } from './accident-add/accident-add.component';
import { AccidentListComponent } from './accident-list/accident-list.component';
import { TheftAddComponent } from './theft-add/theft-add.component';
import { TheftListComponent } from './theft-list/theft-list.component';
import { CancelAddComponent } from './cancel-add/cancel-add.component';
import { CancelListComponent } from './cancel-list/cancel-list.component';
import { CancelMainpageComponent } from './cancel-mainpage/cancel-mainpage.component';
import { ClaimsMainpageComponent } from './claims-mainpage/claims-mainpage.component';
import { CancelpoliciesMainpageComponent } from './cancelpolicies-mainpage/cancelpolicies-mainpage.component';
import { AllclaimsListComponent } from './allclaims-list/allclaims-list.component';
import { AllclaimsList2Component } from './allclaims-list2/allclaims-list2.component';
import { AllcancelsListComponent } from './allcancels-list/allcancels-list.component';
import { AllcancelsList2Component } from './allcancels-list2/allcancels-list2.component';


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
  {path:'regpaydetails',component:RegPaiddetailsComponent},
  {path:'custpolicylist',component:CustPolicylistComponent},
  {path:'claimpolicy',component:ClaimMainpageComponent},
  {path:'accident',component:AccidentAddComponent},
  {path:'accidentlist',component:AccidentListComponent},
  {path:'theft',component:TheftAddComponent},
  {path:'theftlist',component:TheftListComponent},
  {path:'cancelpolicy',component:CancelMainpageComponent},
  {path:'addcancel',component:CancelAddComponent},
  {path:'cancellist',component:CancelListComponent},
  {path:'claims',component:ClaimsMainpageComponent},
  {path:'cancelpolicies',component:CancelpoliciesMainpageComponent},
  {path:'accidentclaimslist',component:AllclaimsListComponent},
  {path:'theftclaimslist',component:AllclaimsList2Component},
  {path:'cancelrequest',component:AllcancelsListComponent},
  {path:'duecancellation',component:AllcancelsList2Component}
  
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
