import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetalleComponent } from './detalle/detalle.component';
import { EditarFormularioComponent } from './editar-formulario/editar-formulario.component';
import { ListaComponent } from './lista/lista.component';
import { NuevoRolComponent } from './nuevo-rol/nuevo-rol.component';

const routes: Routes = [
  {path: "", component: ListaComponent},
  {path: "detalle/:id", component: DetalleComponent},
  {path: "nuevo", component: NuevoRolComponent},
  {path: "editar/:id", component:EditarFormularioComponent},
  {path: "**", redirectTo: "", pathMatch:"full"}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
