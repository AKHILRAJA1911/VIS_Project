import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClaimsMainpageComponent } from './claims-mainpage.component';

describe('ClaimsMainpageComponent', () => {
  let component: ClaimsMainpageComponent;
  let fixture: ComponentFixture<ClaimsMainpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClaimsMainpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClaimsMainpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
