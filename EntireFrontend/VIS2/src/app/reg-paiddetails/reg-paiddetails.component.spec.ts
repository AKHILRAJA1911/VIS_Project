import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegPaiddetailsComponent } from './reg-paiddetails.component';

describe('RegPaiddetailsComponent', () => {
  let component: RegPaiddetailsComponent;
  let fixture: ComponentFixture<RegPaiddetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegPaiddetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegPaiddetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
