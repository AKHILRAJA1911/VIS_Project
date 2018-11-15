import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TheftAddComponent } from './theft-add.component';

describe('TheftAddComponent', () => {
  let component: TheftAddComponent;
  let fixture: ComponentFixture<TheftAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TheftAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TheftAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
