import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonaHomeComponent } from './persona-home.component';

describe('PersonaHomeComponent', () => {
  let component: PersonaHomeComponent;
  let fixture: ComponentFixture<PersonaHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PersonaHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonaHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
