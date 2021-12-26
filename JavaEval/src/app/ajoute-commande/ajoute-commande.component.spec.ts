import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouteCommandeComponent } from './ajoute-commande.component';

describe('AjouteCommandeComponent', () => {
  let component: AjouteCommandeComponent;
  let fixture: ComponentFixture<AjouteCommandeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AjouteCommandeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouteCommandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
