import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';
import { Observable } from 'rxjs';
import * as Model from './../../lib/model';

@Component({
  selector: 'app-persona-form',
  templateUrl: './persona-form.component.html',
  styleUrls: ['./persona-form.component.scss'],
})
export class PersonaFormComponent implements OnInit {
  @Input() persona: Observable<Model.CrearPersonaPeticionDto>;
  @Output() saveEvent = new EventEmitter<Model.CrearPersonaPeticionDto>();

  personaForm: FormGroup;
  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.personaForm = this.fb.group({
      nombres: [
        '',
        [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(250),
        ],
      ],
      apellidos: [
        '',
        [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(250),
        ],
      ],
      cedula: [0, [Validators.required]],
      genero: ['', [Validators.required]],
      edad: ['', [Validators.required]],
    });
    if (this.persona) {
      this.persona.subscribe((persona) => {
        this.personaForm.patchValue({
          nombres: persona.nombres,
          apellidos: persona.apellidos,
          cedula: persona.cedula,
          genero: persona.genero,
          edad: persona.edad,
        });
      });
    }
  }

  get apellidos() {
    return this.personaForm.get('apellidos');
  }

  get nombres() {
    return this.personaForm.get('nombres');
  }

  get cedula() {
    return this.personaForm.get('cedula');
  }

  get genero() {
    return this.personaForm.get('genero');
  }
  get edad() {
    return this.personaForm.get('edad');
  }

  getApellidosInputError() {
    if (this.apellidos.hasError('required')) {
      return 'El campo apellidos es obligatorio.';
    }

    if (this.apellidos.hasError('minLength')) {
      return 'El campo apellidos debe tener mínimo 2 caracteres.';
    }

    if (this.apellidos.hasError('maxLength')) {
      return 'El campo apellidos debe tener máximo 249 caracteres.';
    }
  }

  getNombresInputError() {
    if (this.nombres.hasError('required')) {
      return 'El campo nombres es obligatorio.';
    }
    if (this.nombres.hasError('minLength')) {
      return 'El campo nombre debe tener mínimo 2 caracteres.';
    }

    if (this.nombres.hasError('maxLength')) {
      return 'El campo nombre debe tener máximo 249 caracteres.';
    }
  }

  getCedulaInputError() {
    if (this.cedula.hasError('required')) {
      return 'El campo tipo de cédula es obligatorio.';
    }
  }

  getGeneroInputError() {
    if (this.genero.hasError('required')) {
      return 'El campo genero es obligatorio.';
    }
  }
  getEdadInputError() {
    if (this.edad.hasError('required')) {
      return 'El campo edad es obligatorio.';
    }
  }

  savePersona() {
    if (this.personaForm.invalid) {
      return;
    }

    let persona: Model.CrearPersonaPeticionDto = {
      nombres: this.nombres.value,
      apellidos: this.apellidos.value,
      cedula: this.cedula.value,
      genero: this.genero.value,
      edad: this.edad.value,
    };

    this.saveEvent.emit(persona);
    this.personaForm.reset();
  }
}
