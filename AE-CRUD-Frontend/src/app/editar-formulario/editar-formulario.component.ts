import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Rol } from '../models/rol';
import { RolServiceService } from '../services/rol-service.service';

@Component({
  selector: 'app-editar-formulario',
  templateUrl: './editar-formulario.component.html',
  styleUrls: ['./editar-formulario.component.css']
})
export class EditarFormularioComponent implements OnInit {

  rol:Rol = null;
  constructor(private rolService:RolServiceService, private activateRoute:ActivatedRoute, private toaster:ToastrService, private router:Router) {}

  ngOnInit(): void {
    
    const id = this.activateRoute.snapshot.params['id'];
    this.rolService.obtenerRol(id).subscribe(data => {
      this.rol = data;
      });
  }

  modificar() {
    const id = this.activateRoute.snapshot.params['id'];
    this.rolService.modificarRol(id, this.rol).subscribe(
      data => {
        this.toaster.success('rl actualizado', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
      });
    this.router.navigate(["/"]);
  }
}
