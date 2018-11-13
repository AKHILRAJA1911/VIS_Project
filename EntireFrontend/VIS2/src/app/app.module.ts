import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { HomePageComponent } from './home-page/home-page.component';
import { UserLoginComponent } from './user-login/user-login.component';
import {HttpClientModule} from '@angular/common/http';
import { AddVehicleComponent } from './add-vehicle/add-vehicle.component';
import { VehicleService } from './vehicle.service';
import { VehicleRegComponent } from './vehicle-reg/vehicle-reg.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';


@NgModule({
  declarations: [
    AppComponent,
    AdminLoginComponent,
    HomePageComponent,
    UserLoginComponent,
    AddVehicleComponent,
    VehicleRegComponent,
    VehicleListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
 
  ],
  providers: [VehicleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
