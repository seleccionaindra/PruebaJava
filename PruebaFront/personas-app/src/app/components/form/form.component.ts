import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

import { Persona } from 'src/app/classes/persona';
import { PersonaService } from 'src/app/services/persona.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {
  _tituloFormulario:string = "Persona";
  _persona:Persona = new Persona();

  constructor(private _personaService:PersonaService,
              private _router: Router,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.getPersona();
  }

  createPersona(): void {
    this._personaService.createPersona(this._persona)
      .subscribe(e => this._router.navigate(['/personas']));
  }

  getPersona(): void {
    this.activatedRoute.params.subscribe(params => {
      let cedula: number = params['cedula']
      if (cedula) {
        this._personaService.getPersona(cedula).subscribe(e => this._persona = e);
      }
    });
  }

  updatePersona():void {
    this._personaService.updatePersona(this._persona)
    .subscribe(e => this._router.navigate(['/personas']));
  }

}
