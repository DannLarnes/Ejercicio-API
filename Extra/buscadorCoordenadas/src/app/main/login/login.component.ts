import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { environment } from './../../../environments/environment';
import { MatSnackBar } from '@angular/material';
import {Router} from "@angular/router"

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  apiUrl:String;

  nombreUsuario:String="";
  password:String="";

  constructor(private http: HttpClient, private _snackBar: MatSnackBar,private router: Router) {
    this.apiUrl=environment.ApiUrl;
   }

  ngOnInit() {
    
  }

  login(){
    this.http.post(this.apiUrl.concat("/login"),{nombre:this.nombreUsuario,password:this.password},{observe: 'response'}).subscribe(resp => {
      this._snackBar.open("Ingreso correctamente", "cerrar",{
        horizontalPosition: "center",
        verticalPosition: "top",
      });
      this.router.navigate(["/buscadorProvincias"])
   },error =>{
     console.log(error)
     this._snackBar.open("usuario o contraseña incorrectos", "cerrar",{
      horizontalPosition: "center",
      verticalPosition: "top",
    });
   });
  }

  isLoginButtonDisabled(){
    var res= this.nombreUsuario=="" || this.password=="";
    return res? true: null;
  }

}
