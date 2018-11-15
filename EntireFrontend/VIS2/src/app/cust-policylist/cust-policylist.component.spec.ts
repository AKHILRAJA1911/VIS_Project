import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustPolicylistComponent } from './cust-policylist.component';

describe('CustPolicylistComponent', () => {
  let component: CustPolicylistComponent;
  let fixture: ComponentFixture<CustPolicylistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustPolicylistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustPolicylistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
