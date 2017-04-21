import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BtnSvgComponent } from './btn-svg.component';

describe('BtnSvgComponent', () => {
  let component: BtnSvgComponent;
  let fixture: ComponentFixture<BtnSvgComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BtnSvgComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BtnSvgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
