export class Persona { 
	cedula:string;
	nombre:string;
	apellidos:string;
	genero:string;
    edad:string;
    
    constructor(cedula:string, nombre:string, apellidos:string, genero:string, edad:string){

        this.cedula = cedula;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.genero=genero;
        this.edad=edad;
    }
}