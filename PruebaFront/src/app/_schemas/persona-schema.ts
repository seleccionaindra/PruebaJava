export class Persona {
    public id: number;
    public nombres: string;
    public apellidos: string;
    public cedula: string;
    public genero: string;
    public edad: number;

    constructor(data?: any) {
        if (data !== undefined) {
            this.id = data.id !== undefined ? data.id : null;
            this.nombres = data.nombres !== undefined ? data.nombres : null;
            this.apellidos = data.apellidos !== undefined ? data.apellidos : null;
            this.cedula = data.cedula !== undefined ? data.cedula : null;
            this.genero = data.genero !== undefined ? data.genero : null;
            this.edad = data.edad !== undefined ? data.edad : null;
        }
    }
}
