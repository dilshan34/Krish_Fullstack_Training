import { TestBed } from '@angular/core/testing';

import { DispatchOrdersService } from './dispatch-orders.service';

describe('DispatchOrdersService', () => {
  let service: DispatchOrdersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DispatchOrdersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
