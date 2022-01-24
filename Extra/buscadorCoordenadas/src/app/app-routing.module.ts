import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './main/login/login.component';
import { MainModule } from './main/main.module';


const routes: Routes = [
  {
    path:'',
    loadChildren: () => import('./main/main.module').then(m => m.MainModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
