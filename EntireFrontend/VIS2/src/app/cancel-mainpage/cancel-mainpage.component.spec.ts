import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelMainpageComponent } from './cancel-mainpage.component';

describe('CancelMainpageComponent', () => {
  let component: CancelMainpageComponent;
  let fixture: ComponentFixture<CancelMainpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CancelMainpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CancelMainpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
