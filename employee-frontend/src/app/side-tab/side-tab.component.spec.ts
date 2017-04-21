import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SideTabComponent } from './side-tab.component';

describe('SideTabComponent', () => {
  let component: SideTabComponent;
  let fixture: ComponentFixture<SideTabComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SideTabComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SideTabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
