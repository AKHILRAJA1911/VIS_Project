import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelpoliciesMainpageComponent } from './cancelpolicies-mainpage.component';

describe('CancelpoliciesMainpageComponent', () => {
  let component: CancelpoliciesMainpageComponent;
  let fixture: ComponentFixture<CancelpoliciesMainpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CancelpoliciesMainpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CancelpoliciesMainpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
