import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { ServiceService} from '../../Service/service.service';
import { Persona } from 'src/app/Modelo/Persona';


@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  personas:Persona[];
  constructor(private service:ServiceService, private router:Router) { }

  ngOnInit(): void {
    this.service.getPersonas()
    .subscribe(data=>{this.personas=data;})
  }

  Editar(persona:Persona): void{
    localStorage.setItem("cedula",persona.cedula.toString());
    this.router.navigate(["edit"]);
  }

  Delete(persona:Persona): void{
    this.service.deletePersona(persona)
    .subscribe(data=>{
      this.personas=this.personas.filter(p=>p!==persona);
      alert("Usuario Eliminado")
    })
  }
}
