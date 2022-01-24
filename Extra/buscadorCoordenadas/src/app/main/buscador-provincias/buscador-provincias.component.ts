import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material';
import { environment } from 'src/environments/environment';

export interface Coordenadas{
  lat:Number;
  lon:Number;
}

@Component({
  selector: 'app-buscador-provincias',
  templateUrl: './buscador-provincias.component.html',
  styleUrls: ['./buscador-provincias.component.css']
})
export class BuscadorProvinciasComponent implements OnInit {
  apiUrl:String;

  provincia:string;

  constructor(private http: HttpClient, private _snackBar: MatSnackBar) {
    this.apiUrl=environment.ApiUrl;
   }

  ngOnInit() {
  }

  buscarCoordenadas(){
    let params = new HttpParams();

    // Begin assigning parameters
    params = params.append('provincia',this.provincia);

    this.http.get(this.apiUrl+"/coordenadas",{params:params}).subscribe((resp:Coordenadas) => {
      console.log(resp);
      window.open("http://www.google.com/maps/place/"+resp.lat+","+resp.lon, "_blank");
   },(error:HttpErrorResponse ) =>{
     console.log(error);
     this._snackBar.open( error.error, "cerrar",{
      horizontalPosition: "center",
      verticalPosition: "top",
    });
   });
  }

}
