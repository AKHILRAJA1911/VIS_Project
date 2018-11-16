import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllclaimsList2Component } from './allclaims-list2.component';

describe('AllclaimsList2Component', () => {
  let component: AllclaimsList2Component;
  let fixture: ComponentFixture<AllclaimsList2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllclaimsList2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllclaimsList2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
