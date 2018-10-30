import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Fabricante } from '../model/fabricante.model';

@Injectable({
    providedIn: 'root'
  })
  export class FabricanteService {
  
    private URL_API = 'http://localhost:8080/fabricante';
  
    constructor(private http: HttpClient) { }
  
    public get(): Observable<Array<Fabricante>> {
      return this.http.get<Array<Fabricante>>(this.URL_API);
    }
    public onChangeSelect(id: number): Observable<Array<Fabricante>> {
      return this.http.get<Array<Fabricante>>(this.URL_API + "/" + id);
    }
  }