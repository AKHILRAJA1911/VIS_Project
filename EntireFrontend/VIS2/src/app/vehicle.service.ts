import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { AdminLogin } from './models/AdminLogin';
import { Vehicle } from './models/vehicle';
import { Observable } from 'rxjs';
import { Customer } from './models/customer';
import { Directpay } from './models/directpay';
import { Accident } from './models/accident';
import { Theft } from './models/theft';
import { Cancel } from './models/cancel';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  constructor(private http: HttpClient) { }

//  admin login
  public tryLogin(adlogin){
    
    return this.http.post('http://localhost:1216/vims/admin/login', adlogin,  { responseType: 'text'});
  }

// list of vehicle policies 
  public getPolicies() {
 
    return this.http.get<Vehicle[]>('http://localhost:1216/vims/vehicle/findall');
  }

 // vehicle registration

  public createPolicy(vehicle){

    return this.http.post('http://localhost:1216/vims/vehicle/save',vehicle, { responseType: 'text' as 'text'});
  }

  // user registration
  public userlogin(customer){

    return this.http.post('http://localhost:1216/vims/customer',customer,{ responseType: 'text' as 'text'})

  }
  
  // user login
 public login(customer){

   return this.http.post('http://localhost:1216/vims/customer/login',customer,  { responseType: 'text' as 'text'});
 }

 // Direct Pay
 public direct(directpay){
  return this.http.post('http://localhost:1216/vims/directpay/save',directpay, { responseType: 'text' as 'text'});
 }

// Direct Pay Details
 public paiddetails(policy_id:string):Observable<any>{
  return this.http.get('http://localhost:1216/vims/directpay/findallpay/'+`${policy_id}`);
 }

 // Register pay check

 public registerpay(regpay){
   return this.http.post('http://localhost:1216/vims/registeredpay/lastpaid',regpay, { responseType: 'text' as 'text'});
 }

// Register Payment

public makePayment(regpay){
  return this.http.post('http://localhost:1216/vims/registeredpay',regpay,{ responseType: 'text' as 'text'});
}

// registered paid details
public regpaiddetails(policy_id:string):Observable<any>{
  return this.http.get('http://localhost:1216/vims/registeredpay/findallpay/'+`${policy_id}`);
}

// Customer policies 
public custpolicies(customer_id:string):Observable<any>{
  return this.http.get('http://localhost:1216/vims/vehicle/findvehiclesbycustomerid/'+`${customer_id}`);  

}

// accident Claim
public saveaccident(accident){
  return this.http.post('http://localhost:1216/vims/accidentclaim/save',accident,{ responseType: 'text' as 'text'});
}

// accidentclaim check
accidentcheck(accident){
  return this.http.post('http://localhost:1216/vims/findtotalamount',accident, { responseType: 'text' as 'text'});
}
// theftclaim check 
theftcheck(theft){
  return this.http.post('http://localhost:1216/vims/findtotalamount',theft, { responseType: 'text' as 'text'});
}

// theft claim
savetheft(theft){
  return this.http.post('http://localhost:1216/vims/theftclaim/save',theft,{ responseType: 'text' as 'text'});
}

accidentlist(customer_id:string):Observable<any>{
  return this.http.get('http://localhost:1216/vims/accidentclaim/findaccidentclaimsbycustid/'+`${customer_id}`);
}

theftlist(customer_id:string):Observable<any>{
  return this.http.get('http://localhost:1216/vims/theftclaim/findtheftclaimsbycustid/'+`${customer_id}`);
}

// cancel check
public cancelcheck(cancel){
  return this.http.post('http://localhost:1216/vims/cancel/viewCancellation',cancel, { responseType: 'text' as 'text'});
}

// cancel save
public savecancel(cancel){
  return this.http.post('http://localhost:1216/vims/cancel/save',cancel, { responseType: 'text' as 'text'});
}

// cancel list
cancellist(customer_id:string):Observable<any>{
  return this.http.get('http://localhost:1216/vims/cancel/customer/'+`${customer_id}`);
}

// all accident claim policies

accidentpolicies(){
  return this.http.get<Accident[]>('http://localhost:1216/vims/accidentclaim/findall');
}

// all theft claim policies
theftpolicies(){
  return this.http.get<Theft[]>('http://localhost:1216/vims/theftclaim/findall');
}

// all cancel policies
cancelpolicy(){
  return this.http.get<Cancel[]>('http://localhost:1216/vims/cancel/findall/');
}

// user request cancel policies
cancelreqpolicy(){
  return this.http.get<Cancel[]>('http://localhost:1216/vims/cancel/findallduevehicles/');
}

// set status to Approve
setStatus(claim_id:string):Observable<any>{
  return this.http.get('http://localhost:1216/vims/theftclaim/approve/'+claim_id,{ responseType: 'text' as 'text'});
}

// set status to Reject
setStatus2(claim_id:string):Observable<any>{
  return this.http.get('http://localhost:1216/vims/theftclaim/reject/'+claim_id,{ responseType: 'text' as 'text'});
}

// Set status to Approve
accidentsetStatus(claim_id:string):Observable<any>{
  return this.http.get('http://localhost:1216/vims/accidentclaim/approve/'+claim_id,{ responseType: 'text' as 'text'});
}


// Set status to Reject
accidentsetStatus2(claim_id:string):Observable<any>{
  return this.http.get('http://localhost:1216/vims/accidentclaim/reject/'+claim_id,{ responseType: 'text' as 'text'});
}



}






