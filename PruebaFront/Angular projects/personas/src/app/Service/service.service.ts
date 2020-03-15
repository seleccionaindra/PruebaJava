import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Persona } from '../Modelo/Persona';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

 
  constructor(private http:HttpClient) { }
  Url="http://localhost:8080/api/personas/buscarPersonasTodo";
  UrlCreate="http://localhost:8080/api/personas";

 

  getPersonas(){
    return this.http.get<Persona[]>(this.Url);
  }
  createPersona(persona:Persona){
    return this.http.post<Persona>(this.UrlCreate,persona)
  }
  getPersonaId(cedula:String){
    return this.http.get<Persona>(this.Url+"/"+cedula);
  }
  updatePersona(persona:Persona){
    return this.http.put<Persona>(this.UrlCreate,persona);
  }

  deletePersona(persona:Persona){
    return this.http.delete<Persona>(this.UrlCreate+"/"+persona.cedula);
  }
}
