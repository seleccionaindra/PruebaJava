import { Component, OnInit } from '@angular/core';
import { HttpService } from 'src/app/_services/http.service';
import { Persona } from 'src/app/_schemas/persona-schema';
import { environment } from 'src/environments/environment';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-lista-persona',
  templateUrl: './lista-persona.component.html',
  styleUrls: ['./lista-persona.component.css']
})
export class ListaPersonaComponent implements OnInit {

  personas: Persona[];
  bsModalRef: BsModalRef;
  personaForm: FormGroup;
  modalTitle: string;
  estaCargando: boolean;

  constructor(
    private httpService: HttpService,
    private modalService: BsModalService,
    private formBuilder: FormBuilder,
    private toastr: ToastrService
  ) {
   }

  ngOnInit() {
    this.cargarPersonas();
  }

  cargarPersonas() {
    this.estaCargando = true;
    this.httpService.get(environment.personList).subscribe(
      (data: Persona[]) => {
        this.personas = data;
      },
      error => {
        this.toastr.error(error);
        this.estaCargando = false;
      },
      () => { this.estaCargando = false; }
    );
  }

  abrirPersonaForm(template, persona) {

    if (persona) {
      this.modalTitle = 'Actualizar Persona';
      this.personaForm = this.formBuilder.group(persona);
    } else {
      this.modalTitle = 'Crear Persona';
      this.personaForm = this.formBuilder.group(
        new Persona({nombres: '', apellidos: '', cedula: '', genero: '', edad: ''})
      );
    }

    this.bsModalRef = this.modalService.show(template, {
      class: 'modal-lg',
    });
  }


  guardarPersona() {
    this.estaCargando = true;
    if (this.personaForm.value.id) {
      this.httpService.put(environment.personAction.replace('{id}', this.personaForm.value.id), this.personaForm.value).subscribe(
        (data: Persona) => {
          this.personaGuardada('actualizada');
        },
        error => {
          this.toastr.error(error);
          this.estaCargando = false;
        }
      );
    } else {
      this.httpService.post(environment.personAdd, this.personaForm.value).subscribe(
        (data: Persona) => {
          this.personaGuardada('creada');
        },
        error => {
          this.toastr.error(error);
          this.estaCargando = false;
        }
      );
    }
  }

  eliminarPersona(id) {
    this.estaCargando = true;
    this.httpService.delete(environment.personAction.replace('{id}', id)).subscribe((data) => {
        this.personaGuardada('eliminada');
      },
      error => {
        this.toastr.error(error);
        this.estaCargando = false;
      }
    );
  }

  personaGuardada(action) {
    this.toastr.success(`La persona ha sido ${action}.`);
    this.cargarPersonas();
    if (action !== 'eliminada') {
      this.bsModalRef.hide();
    }
  }

}
