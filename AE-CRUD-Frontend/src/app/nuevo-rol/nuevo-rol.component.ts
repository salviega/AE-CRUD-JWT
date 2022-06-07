import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Rol } from '../models/rol';
import { RolServiceService } from '../services/rol-service.service';

@Component({
  selector: 'app-nuevo-rol',
  templateUrl: './nuevo-rol.component.html',
  styleUrls: ['./nuevo-rol.component.css']
})
export class NuevoRolComponent implements OnInit {

  constructor(private rolService: RolServiceService, private toaster:ToastrService, private router:Router) { }

  rolName:string = "";
  description:string = "";

  ngOnInit(): void {
  }

  crear() {

    const newRol = new Rol(this.rolName, this.description);
    this.rolService.crearRol(newRol).subscribe(dato => {
      this.toaster.success("Rol creado", 'OK',{
        timeOut: 3000,
        positionClass: 'toast-top-center'
      });
      this.router.navigate(["/"]);
    })
  }

}
