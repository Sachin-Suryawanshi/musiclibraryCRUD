import { TestBed } from '@angular/core/testing';

import { MusiclibraryService } from './musiclibrary.service';

describe('MusiclibraryService', () => {
  let service: MusiclibraryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MusiclibraryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
