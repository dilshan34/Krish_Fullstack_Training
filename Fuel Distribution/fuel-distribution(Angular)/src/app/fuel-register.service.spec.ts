import { TestBed } from '@angular/core/testing';

import { FuelRegisterService } from './fuel-register.service';

describe('FuelRegisterService', () => {
  let service: FuelRegisterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FuelRegisterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
