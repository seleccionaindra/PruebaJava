import { Component, OnInit } from '@angular/core';
import { Persona } from './../../classes/persona';
import { PersonaService } from './../../services/persona.service';

@Component({
  selector: 'app-personas',
  templateUrl: './personas.component.html'
})
export class PersonasComponent implements OnInit {
  
  personas: Persona[] = [];

  constructor(private _personaService:PersonaService) { }

  ngOnInit(): void {
    this._personaService.getPersonas().subscribe(e => this.personas = e);
  }
  
  actualizar(): void {

  }

  retirar(persona: Persona): void {
    this._personaService.delete(persona.cedula).subscribe(response => this.personas = this.personas.filter(e => e !== persona));
  }
}
