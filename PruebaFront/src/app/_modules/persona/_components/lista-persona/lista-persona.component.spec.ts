import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaPersonaComponent } from './lista-persona.component';
import { ReactiveFormsModule } from '@angular/forms';
import {RouterTestingModule} from '@angular/router/testing';
import { HttpService } from 'src/app/_services/http.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { BsModalService } from 'ngx-bootstrap';

describe('ListaPersonaComponent', () => {
  let component: ListaPersonaComponent;
  let fixture: ComponentFixture<ListaPersonaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [ReactiveFormsModule,
        RouterTestingModule,
        HttpClientModule],
      declarations: [ ListaPersonaComponent ],
      providers: [
        HttpService,
        HttpClient,
        HttpClientModule,
        BsModalService
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaPersonaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
