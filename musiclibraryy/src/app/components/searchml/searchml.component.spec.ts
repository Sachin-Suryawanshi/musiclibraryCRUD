import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchmlComponent } from './searchml.component';

describe('SearchmlComponent', () => {
  let component: SearchmlComponent;
  let fixture: ComponentFixture<SearchmlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchmlComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchmlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
