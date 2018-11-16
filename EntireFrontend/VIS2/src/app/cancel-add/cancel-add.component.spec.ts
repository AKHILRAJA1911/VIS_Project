import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelAddComponent } from './cancel-add.component';

describe('CancelAddComponent', () => {
  let component: CancelAddComponent;
  let fixture: ComponentFixture<CancelAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CancelAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CancelAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
