import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Rol } from '../models/rol';
import { RolServiceService } from '../services/rol-service.service';

@Component({
  selector: 'app-detalle',
  templateUrl: './detalle.component.html',
  styleUrls: ['./detalle.component.css']
})
export class DetalleComponent implements OnInit {

  rol:Rol = null;
  
  constructor(private rolService:RolServiceService, private activateRoute:ActivatedRoute, private toaster:ToastrService, private router:Router) { }

  ngOnInit(): void {

    const id = this.activateRoute.snapshot.params['id'];
    this.rolService.obtenerRol(id).subscribe(data => {
      this.rol = data;
    })
    
  }

  volver() {
    this.router.navigate(["/"]);
  }

}
