import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscadorProvinciasComponent } from './buscador-provincias.component';

describe('BuscadorProvinciasComponent', () => {
  let component: BuscadorProvinciasComponent;
  let fixture: ComponentFixture<BuscadorProvinciasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BuscadorProvinciasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BuscadorProvinciasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
