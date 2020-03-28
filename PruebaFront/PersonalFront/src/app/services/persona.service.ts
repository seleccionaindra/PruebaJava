import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Persona } from '../interfaces/persona';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  domainURL = "http://localhost:8080";

constructor(public httpClient: HttpClient) { }

obtenerPersonas() {
  let url = `${ this.domainURL }/get`;
  return this.httpClient.get( url );
}

obtenerPersona(idx: string) {
  let url = `${ this.domainURL }/get/${idx}`;
  return this.httpClient.get( url );
}

agregarPersona(persona: Persona) {
  let body:string = JSON.stringify(persona);
    let headers:HttpHeaders  = new HttpHeaders({
      'Content-Type':'application/json'
    });
    let urlPost = `${ this.domainURL }/create`;
    return this.httpClient.post( urlPost, body, {headers: headers} );
}

actualizarPersona(persona: Persona) {
  let body:string = JSON.stringify(persona);
  let headers:HttpHeaders  = new HttpHeaders({
    'Content-Type':'application/json'
  });
  let urlPut = `${ this.domainURL }/update`;
  return this.httpClient.put( urlPut, body, {headers: headers} );
}

borrarPersona(idx: string) {
  let url = `${ this.domainURL }/delete/${idx}`;
  return this.httpClient.delete( url );
}

}
