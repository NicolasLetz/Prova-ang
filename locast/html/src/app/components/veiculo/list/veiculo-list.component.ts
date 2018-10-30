import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Veiculo } from '../../model/veiculo.model';
import { VeiculoService } from '../../service/veiculo.service';

@Component({
  selector: 'app-veiculo-list',
  templateUrl: './veiculo-list.component.html',
  styleUrls: ['./veiculo-list.component.css']
})
export class VeiculoListComponent implements OnInit {
  
  public veiculos: Observable<Array<Veiculo>>
  
  constructor(private router: Router,
    private service: VeiculoService) { }

  ngOnInit() {
    this.getVeiculos();
  }

  private getVeiculos(): void {
    this.veiculos = this.service.getTodos();
  }
}
