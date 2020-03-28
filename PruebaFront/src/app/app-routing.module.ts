import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  // main redirect
  { path: '', redirectTo: 'persona', pathMatch: 'full' },
  { path: 'persona', loadChildren: './_modules/persona/persona.module#PersonaModule' },
  // Handle all other routes
  { path: '**', redirectTo: 'persona' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
