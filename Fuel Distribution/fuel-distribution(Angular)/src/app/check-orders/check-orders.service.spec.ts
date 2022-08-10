import { TestBed } from '@angular/core/testing';

import { CheckOrdersService } from './check-orders.service';

describe('CheckOrdersService', () => {
  let service: CheckOrdersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CheckOrdersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
