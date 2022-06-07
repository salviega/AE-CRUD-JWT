import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Rol } from '../models/rol';

@Injectable({
  providedIn: 'root'
})
export class RolServiceService {

  rolURL = "http://localhost:8080/roles";

  constructor(private http:HttpClient) {}

  public obtenerRoles(): Observable<Rol[]> {
    return this.http.get<Rol[]>(this.rolURL);
  }
  public obtenerRol(id:number): Observable<Rol> {
    return this.http.get<Rol>(this.rolURL + "/" + id);
  }
  public crearRol(rol:Rol): Observable<any> {
    return this.http.post<any>(this.rolURL, rol);
  }
  public modificarRol(id:number, rol:Rol): Observable<Rol> {
    return this.http.put<Rol>(this.rolURL + "/" + id, rol)
  }
  public eliminarRol(id:number): Observable<any> {
    return this.http.delete<any>(this.rolURL + "/" + id)
  }
}
