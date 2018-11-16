import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllclaimsListComponent } from './allclaims-list.component';

describe('AllclaimsListComponent', () => {
  let component: AllclaimsListComponent;
  let fixture: ComponentFixture<AllclaimsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllclaimsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllclaimsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
