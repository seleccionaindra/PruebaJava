import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersonasComponent } from './componentes/personas/personas.component';
import { PersonaComponent } from './componentes/persona/persona.component';


const routes: Routes = [
  { path: 'home', component: PersonasComponent },
  { path: 'persona/:id', component: PersonaComponent },
  { path: '**', pathMatch:'full', redirectTo: 'home' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
