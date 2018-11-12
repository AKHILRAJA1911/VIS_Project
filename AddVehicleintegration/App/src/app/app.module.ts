import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddVehicleComponent } from './add-vehicle/add-vehicle.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { DashBoardComponent } from './dash-board/dash-board.component';
import {HttpClientModule} from "@angular/common/http";
import { VehicleService } from './vehicle.service';

@NgModule({
  declarations: [
    AppComponent,
    AddVehicleComponent,
    VehicleListComponent,
    DashBoardComponent
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
