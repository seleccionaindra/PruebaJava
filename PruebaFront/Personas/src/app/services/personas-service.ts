import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import {Injectable} from '@angular/core';
import { environment } from 'src/environments/environment';


const httpOptionsNoParameters = {
    headers: new HttpHeaders({
        'Access-Control-Allow-Credentials':'true'
    })
}

@Injectable()
export class PersonaService{

    URL_SERVICE: string = environment.url;


    constructor(private httpClient: HttpClient){

    }

    public getPersonas(){
        return this.httpClient.get(this.URL_SERVICE+"devolverPersonas", httpOptionsNoParameters);
    }

    public eliminarPersonas(id:string){
        return this.httpClient.delete(this.URL_SERVICE+"eliminarPersona/"+id,httpOptionsNoParameters)
    }

    public actualizarPersonas(persona:any){
        return this.httpClient.post(this.URL_SERVICE+"actualizarPersona",persona)
    }

    public guardarPersonas(persona:any){
        return this.httpClient.post(this.URL_SERVICE+"ingresarPersona",persona);
    }

}