import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import * as Model from './../model';
import * as URL from './../../../environments/url.base';
import { catchError, map, mergeMap, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class PersonaService {
  private readonly personasLista$ = new BehaviorSubject<Model.PersonaRespuestaDto[]>(
    []
  );
  personasLista = this.personasLista$.asObservable();
  private readonly url_base: string = 'http://localhost:9090/api/v1/personas/';
  constructor(private readonly http: HttpClient) {}

  /**
   * Metodo que permite crear una nueva persona
   * @author Kaleth Bahena
   * @version 0.0.1 2020/11/06
   * @since 0.0.1 2020/11/06
   * @param peticion datos de la peticion
   * @return PersonaRespuestaDto
   */
  crearPersona(
    peticion: Model.CrearPersonaPeticionDto
  ): Observable<Model.PersonaRespuestaDto> {
    return this.http
      .post<Model.PersonaRespuestaDto>(
        `${this.url_base}`,
        JSON.stringify(peticion),
        URL.httpOptions
      )
      .pipe(
        map((data: Model.PersonaRespuestaDto) => {
          this.personasLista$.next([...this.personasLista$.value, data]);
          return data;
        })
      );
  }

  /**
   * Metodo que permite listar las personas
   * @author Kaleth Bahena
   * @version 0.0.1 2020/11/06
   * @since 0.0.1 2020/11/06
   * @param peticion datos de la peticion
   * @return PersonaRespuestaDto
   */
  listar(): Observable<Model.PersonaRespuestaDto[]> {
    return this.http.get<Model.PersonaRespuestaDto[]>(this.url_base).pipe(map(data => {
       this.personasLista$.next([...data]);
       console.log(data, 'asasdasdasd')
      return data;
    }));
  }

  /**
   * Metodo que permite buscar las personas por su nombre
   * @author Kaleth Bahena
   * @version 0.0.1 2020/11/06
   * @since 0.0.1 2020/11/06
   * @param peticion datos de la peticion
   * @return PersonaRespuestaDto
   */
  buscarPorNombre(nombre: string): Observable<Model.PersonaRespuestaDto[]> {
    return this.http.get<Model.PersonaRespuestaDto[]>(`${this.url_base}buscar-nombre/${nombre}`);
  }

  /**
   * Metodo que permite eliminar una persona por su id
   * @author Kaleth Bahena
   * @version 0.0.1 2020/11/06
   * @since 0.0.1 2020/11/06
   * @param peticion datos de la peticion
   * @return PersonaRespuestaDto
   */
  eliminar(id: number) {
    this.http.delete(`${this.url_base}eliminar/${id}`).pipe(tap(() =>
      this.listar().subscribe()
    )).subscribe();

  }

  /**
   * Metodo que permite eliminar una persona por su id
   * @author Kaleth Bahena
   * @version 0.0.1 2020/11/06
   * @since 0.0.1 2020/11/06
   * @param peticion datos de la peticion
   * @return PersonaRespuestaDto
   */
  actualizar(id: number, peticion: Model.CrearPersonaPeticionDto) {
    return this.http
    .put<Model.PersonaRespuestaDto>(
      `${this.url_base}actualizar/${id}`,
      JSON.stringify(peticion),
      URL.httpOptions
    )
    .pipe(
      map((data: Model.PersonaRespuestaDto) => {
        const nuevasPersonas = this.personasLista$.value.filter(persona => persona.id !== id);
        this.personasLista$.next([...nuevasPersonas, data]);
        return data;
      })
    );
  }

  /**
   * Metodo que permite buscar una persona por su id
   * @author Kaleth Bahena
   * @version 0.0.1 2020/11/06
   * @since 0.0.1 2020/11/06
   * @param peticion datos de la peticion
   * @return PersonaRespuestaDto
   */
  buscarPorId(id: number) {
    return this.http.get<Model.PersonaRespuestaDto[]>(`${this.url_base}buscar/${id}`);
  }
}
