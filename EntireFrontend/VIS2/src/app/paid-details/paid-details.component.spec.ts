import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaidDetailsComponent } from './paid-details.component';

describe('PaidDetailsComponent', () => {
  let component: PaidDetailsComponent;
  let fixture: ComponentFixture<PaidDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaidDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaidDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
