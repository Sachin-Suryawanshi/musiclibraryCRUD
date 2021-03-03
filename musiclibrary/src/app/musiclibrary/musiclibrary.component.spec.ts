import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MusiclibraryComponent } from './musiclibrary.component';

describe('MusiclibraryComponent', () => {
  let component: MusiclibraryComponent;
  let fixture: ComponentFixture<MusiclibraryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MusiclibraryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MusiclibraryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
