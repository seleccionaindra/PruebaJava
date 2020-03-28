import { Component } from '@angular/core';
import { Persona } from 'src/app/interfaces/persona';
import { PersonaService } from 'src/app/services/persona.service';

@Component({
  selector: 'app-personas',
  templateUrl: './personas.component.html',
  styleUrls: ['./personas.component.css']
})
export class PersonasComponent {

  personas: Persona[] = [];
  loading:boolean = true;

  constructor(private _persona: PersonaService) {
    this.cargarPersonas();
   }

   borrarPersona(idx: string) {
     this._persona.borrarPersona(idx)
                  .subscribe(response => {
                    if(response){
                      console.error(response)
                    } else {
                      this.cargarPersonas();
                    }
                  })
   }

   cargarPersonas() {
    this._persona.obtenerPersonas()
      .subscribe( (personas:any[]) => {
        this.personas = personas;
        this.loading = false;
      });
   }

}
