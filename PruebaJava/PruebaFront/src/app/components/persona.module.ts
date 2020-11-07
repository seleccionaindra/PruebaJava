import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PersonaRoutingModule } from './persona-routing.module';
import { PersonaListComponent } from './persona-list/persona-list.component';
import { PersonaFormComponent } from './persona-form/persona-form.component';
import { PersonaDetailComponent } from './persona-detail/persona-detail.component';
import { PersonaHomeComponent } from './persona-home/persona-home.component';
import { MaterialModule } from '../shared/material.module';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [PersonaListComponent, PersonaFormComponent, PersonaDetailComponent, PersonaHomeComponent],
  imports: [
    CommonModule,
    PersonaRoutingModule,
    MaterialModule
  ]
})
export class PersonaModule { }
