import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

import { Persona } from 'src/app/interfaces/persona';
import { PersonaService } from 'src/app/services/persona.service';

@Component({
  selector: 'app-persona',
  templateUrl: './persona.component.html',
  styleUrls: ['./persona.component.css']
})
export class PersonaComponent {

  persona: Persona = {
    nombres: '',
    apellidos: '',
    cedula: '',
    genero: 'M',
    edad: 0
  }

  id: string;
  nuevo: boolean = false;
  procesoEditar: string;
  mostrarMensaje: boolean = false;

  constructor(public _personaService: PersonaService, private router: Router, private activatedRoute: ActivatedRoute) {

    this.activatedRoute.params
      .subscribe(parametros => {
        this.procesoEditar = (parametros['id'] == 'nuevo') ? 'Agregar' : 'Editar';
        this.id = parametros['id'];
        if (this.id != 'nuevo') {
          this.consultarPersona(this.id);
        }
      })
  }

  guardarFormulario() {
    if (this.id == 'nuevo') {
      this.guardarPersona();
    } else {
      this.actualizarPersona();
    }
  }

  guardarPersona() {
    this._personaService.agregarPersona(this.persona)
      .subscribe(response => {

        this.mostrarMensaje = true;

        setTimeout(() => {
          let idx = response['id'];
          this.router.navigate(['/home']);
        }, 3000);
      },
        error => console.error(error)
      );
  }

  actualizarPersona() {
    this.persona.id = Number(this.id);
    this._personaService.actualizarPersona(this.persona)
                        .subscribe(response => {
                          this.mostrarMensaje = true;

                          setTimeout(() => {
                            this.mostrarMensaje = false;
                          }, 3000);
                        }, error => console.error(error));
  }

  consultarPersona(idx: string) {
    this._personaService.obtenerPersona(this.id)
      .subscribe((persona: any) => this.persona = persona);
  }



}
