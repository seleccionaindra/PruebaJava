import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
//import { PERSONAS } from './../components/personas/personas.json';
import { Persona } from './../classes/persona';
import { of, Observable } from 'rxjs';


@Injectable({providedIn: 'root'})
export class PersonaService {
    
    private endPointAPI:string = "http://localhost:8080/api";
    private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

    constructor(private _httpClient:HttpClient) {

    }
    
    createPersona(persona: Persona) : Observable<Persona> {
        return this._httpClient.post<Persona>(`${this.endPointAPI}/persona`, persona, {headers: this.httpHeaders});
    }
    
    getPersona(cedula: number) : Observable<Persona> {
        return this._httpClient.get<Persona>(`${this.endPointAPI}/persona/${cedula}`);
    }

    getPersonas(): Observable<Persona[]> {
        return this._httpClient.get(`${this.endPointAPI}/personas`).pipe(
            map(e => e as Persona[])
        );
        //return of(PERSONAS);
    }
    
    updatePersona(persona: Persona) : Observable<Persona> {
        return this._httpClient.put<Persona>(`${this.endPointAPI}/persona/${persona.cedula}`, persona, {headers: this.httpHeaders});
    }

    delete(cedula: number): Observable<Persona>{
      return this._httpClient.delete<Persona>(`${this.endPointAPI}/persona/${cedula}`);
    }

}