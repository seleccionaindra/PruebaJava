import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { PersonaService } from './../../lib/services/persona.service';
import * as Model from './../../lib/model';
@Component({
  selector: 'app-persona-home',
  templateUrl: './persona-home.component.html',
  styleUrls: ['./persona-home.component.scss']
})
export class PersonaHomeComponent implements OnInit {
  listaPersonas: Observable<Model.PersonaRespuestaDto[]> = this.pService.personasLista;
  personaActualizar: Model.CrearPersonaPeticionDto;
  idPersonaActualizar: number;
  constructor(private readonly pService: PersonaService) { }

  ngOnInit(): void {
    this.cargarPersonas();
  }

  cargarPersonas(){
    this.pService.listar().subscribe(console.log);
  }

  crearPersona(persona: Model.CrearPersonaPeticionDto){
    this.pService.crearPersona(persona).subscribe();
  }

  eliminarPersona(id: number){
    this.pService.eliminar(id);
  }

  goActualizar(persona: {id: number, persona: Model.CrearPersonaPeticionDto }){
   this.personaActualizar = persona.persona;
   console.log(this.personaActualizar)
   this.idPersonaActualizar = persona.id;
  }

}
