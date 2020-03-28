import { Component, OnInit } from '@angular/core';
import { PersonaService } from '../services/personas-service';
import { Persona } from './personas.model';
import * as $ from 'jquery';

@Component({
  selector: 'app-personas',
  templateUrl: './personas.component.html',
  styleUrls: ['./personas.component.scss']
})
export class PersonasComponent implements OnInit {

  constructor(private personaService: PersonaService) { }
  public listaPersonas: any;
  public error: boolean;
  public mensajeError: string;
  public guardar: boolean;
  public agregar: boolean;
  public cedulaG: string;
  public nombresG: string;
  public apellidosG: string;
  public generoG: string;
  public edadG: string;


  ngOnInit(): void {
  }

  public devolverPersonas() {

    this.error = false;
    this.mensajeError = "";

    this.personaService.getPersonas().subscribe(result => {
      if (result["codigo"] === 200) {
        this.listaPersonas = result["resultado"];
        if (this.listaPersonas.length === 0) {
          this.listaPersonas = undefined;
          this.setearError(true, "Sin registros en la base de datos");
          this.cambiarError();
        }
      } else {
        this.setearError(true, result["mensaje"]);
        this.listaPersonas = undefined;
        this.cambiarError();
      }
    }, error => {
      this.setearError(true, error.error.mensaje);
      this.listaPersonas = undefined;
      this.cambiarError();
    });
  }

  public setearError(error: boolean, mensaje: string) {
    this.error = error;
    this.mensajeError = mensaje;
  }

  public eliminarPersona(id: string) {
    this.personaService.eliminarPersonas(id).subscribe(result => {
      if (result["codigo"] === 200) {
        this.devolverPersonas();
      } else {
        this.setearError(true, result["mensaje"]);
        this.listaPersonas = undefined;
        this.cambiarError();
      }
    }, error => {
      this.setearError(true, error.error.mensaje);
      this.listaPersonas = undefined;
      this.cambiarError();
    });
  }

  public cambiarGuardar() {
    setTimeout(() => {
      this.guardar = false
    }, 4000);
  }

  public cambiarError() {
    setTimeout(() => {
      this.error = false
    }, 4000);
  }

  public actualizarPersona(cedula: string, nombre: string, apellidos: string, genero: string, edad: string) {
    this.personaService.actualizarPersonas(new Persona(cedula, nombre, apellidos, genero, edad)).subscribe(result => {
      if (result["codigo"] === 200) {
        this.guardar = true;
        this.cambiarGuardar();
      } else {
        this.setearError(true, result["mensaje"]);
        this.listaPersonas = undefined;
        this.cambiarError();
      }
    }, error => {
      this.setearError(true, error.error.mensaje);
      this.listaPersonas = undefined;
      this.cambiarError();
    });
  }

  public verMenuAgregar() {
    this.agregar = true;
    this.limpiarCampos();
  }

  public esconderMenuAgregar() {

    this.agregar = false;
  }

  public limpiarCampos() {
 
    this.nombresG = "";
    this.apellidosG = "";
    this.cedulaG = "";
    this.edadG = "";
    this.generoG = "";
  }

  public guardarPersona() {
    this.esconderMenuAgregar();
    this.personaService.guardarPersonas(new Persona(this.cedulaG, this.nombresG, this.apellidosG, this.generoG, this.edadG)).subscribe(result => {
      if (result["codigo"] === 200) {
        this.guardar = true;
        this.cambiarGuardar();
        this.devolverPersonas();
      } else {
        this.setearError(true, result["mensaje"]);
        this.listaPersonas = undefined;
        this.cambiarError();
      }
    }, error => {
      this.setearError(true, error.error.mensaje);
      this.listaPersonas = undefined;
      this.cambiarError();
    });
  }
}
