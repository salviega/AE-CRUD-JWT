import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Rol } from '../models/rol';
import { RolServiceService } from '../services/rol-service.service';

@Component({
  selector: 'app-lista',
  templateUrl: './lista.component.html',
  styleUrls: ['./lista.component.css']
})
export class ListaComponent implements OnInit {

  roles: Rol[] = [];
  constructor(private rolService: RolServiceService,  private toaster:ToastrService, private router:Router) { }

  ngOnInit(): void {

    this.cargarProducto();
  }

  cargarProducto(): void {

    this.rolService.obtenerRoles().subscribe(datos => {
      this.roles = Object.values(datos);
    });
  }
  
  borrar(id:number) {
    this.rolService.eliminarRol(id).subscribe(
    response => {
      this.toaster.success("Rol eliminado", 'OK',{
        timeOut: 3000,
        positionClass: 'toast-top-center'
      });
      this.cargarProducto();
    })
    
  }
}
