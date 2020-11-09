import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';

//Componentes
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { FormComponent } from './components/form/form.component';
import { BodyComponent } from './components/body/body.component';
import { PersonasComponent } from './components/personas/personas.component';

//Rutas
import {APP_ROUTING} from './app.routes';

//Servicios
//import {PersonaService} from './services/persona.service';

@NgModule({
  declarations: [
    AppComponent,
    BodyComponent,
    FormComponent,
    FooterComponent,
    HeaderComponent,
    PersonasComponent
  ],
  imports: [
    APP_ROUTING,
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    //PersonaService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
