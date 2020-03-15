import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/Modelo/Persona';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  persona :Persona=new Persona();
  constructor(private router:Router, private service: ServiceService) {

   }

  ngOnInit(): void {
    this.Editar();
  }

  Editar(){
    let cedula=localStorage.getItem("cedula");
    this.service.getPersonaId(+cedula)
    .subscribe(data=>{
      this.persona=data;
    })
  }

  Actualizar(persona:Persona){
    this.service.updatePersona(persona)
    .subscribe(data=>{
      this.persona=data;
      alert("Se actualizo con exito")
      this.router.navigate(["listar"])
    })
  }

}
