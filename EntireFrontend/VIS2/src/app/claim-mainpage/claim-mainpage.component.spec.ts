import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClaimMainpageComponent } from './claim-mainpage.component';

describe('ClaimMainpageComponent', () => {
  let component: ClaimMainpageComponent;
  let fixture: ComponentFixture<ClaimMainpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClaimMainpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClaimMainpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
