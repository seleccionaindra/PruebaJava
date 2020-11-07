import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersonaHomeComponent } from './components/persona-home/persona-home.component';

const routes: Routes = [{
  path: '',
  component: PersonaHomeComponent
}, {
  path: '**', redirectTo: '',
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
