import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllcancelsList2Component } from './allcancels-list2.component';

describe('AllcancelsList2Component', () => {
  let component: AllcancelsList2Component;
  let fixture: ComponentFixture<AllcancelsList2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllcancelsList2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllcancelsList2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
