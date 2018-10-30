import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Modelo } from '../model/modelo.model';

@Injectable({
    providedIn: 'root'
  })
  export class ModeloService {
      private URL_API = 'http://localhost:8080/modelo';
      
      constructor(private http: HttpClient) { }

      public get(): Observable<Array<Modelo>> {
          return this.http.get<Array<Modelo>>(this.URL_API);
      }
      getOnChangeSelect(idModelo: number): Observable<Array<Modelo>> {
        return this.http.get<Array<Modelo>>("http://localhost:8080/modelo/" + idModelo);
      }
  }