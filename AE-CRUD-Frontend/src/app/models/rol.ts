export class Rol {

    id?:number;
    rolName:String;
    description:string;

    constructor (nombre:string, descripcion:string) {
        this.rolName = nombre;
        this.description = descripcion;
    }
}
