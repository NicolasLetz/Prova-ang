import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Veiculo } from '../model/veiculo.model';
import { VeiculoForm } from '../model/veiculoForm.model';

@Injectable({
    providedIn: 'root'
})
export class VeiculoService {
    private URL_API = 'http://localhost:8080/veiculo';
    constructor(private http: HttpClient) { }

    public getTodos(): Observable<Array<Veiculo>> {
        return this.http.get<Array<Veiculo>>(this.URL_API);
    }
    public salvar(veiculo: VeiculoForm): Observable<void> {
        return this.http.post<void>(this.URL_API, veiculo);
    }
    public isDuplicado(placa: string): Observable<Veiculo> {
        return this.http.get<Veiculo>(this.URL_API + '/' + placa);
    }
}