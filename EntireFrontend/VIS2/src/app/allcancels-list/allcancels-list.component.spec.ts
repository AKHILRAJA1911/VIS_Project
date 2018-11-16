import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllcancelsListComponent } from './allcancels-list.component';

describe('AllcancelsListComponent', () => {
  let component: AllcancelsListComponent;
  let fixture: ComponentFixture<AllcancelsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllcancelsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllcancelsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
