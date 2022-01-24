import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { BuscadorProvinciasComponent } from './buscador-provincias/buscador-provincias.component';
import { RouterModule, Routes } from '@angular/router';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import {MatSnackBarModule} from '@angular/material/snack-bar';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  },
  {
    path:'buscadorProvincias',
    component:BuscadorProvinciasComponent
  }
];

@NgModule({
  declarations: [LoginComponent, BuscadorProvinciasComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MatButtonModule,
    MatFormFieldModule,
    FormsModule,
    MatSnackBarModule
  ],
  exports: [RouterModule]
})
export class MainModule { }
