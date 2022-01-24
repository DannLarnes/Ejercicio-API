import { TestBed } from '@angular/core/testing';

import { BuscadorProvinciasServService } from './buscador-provincias-serv.service';

describe('BuscadorProvinciasServService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BuscadorProvinciasServService = TestBed.get(BuscadorProvinciasServService);
    expect(service).toBeTruthy();
  });
});
