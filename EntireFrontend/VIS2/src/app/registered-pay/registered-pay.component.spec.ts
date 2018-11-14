import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisteredPayComponent } from './registered-pay.component';

describe('RegisteredPayComponent', () => {
  let component: RegisteredPayComponent;
  let fixture: ComponentFixture<RegisteredPayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisteredPayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisteredPayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
