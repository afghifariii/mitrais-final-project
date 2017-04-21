import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeSearchComponent } from './employee-search.component';

describe('EmployeeSearchComponent', () => {
  let component: EmployeeSearchComponent;
  let fixture: ComponentFixture<EmployeeSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployeeSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
