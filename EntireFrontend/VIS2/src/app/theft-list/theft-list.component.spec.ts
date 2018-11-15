import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TheftListComponent } from './theft-list.component';

describe('TheftListComponent', () => {
  let component: TheftListComponent;
  let fixture: ComponentFixture<TheftListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TheftListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TheftListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
