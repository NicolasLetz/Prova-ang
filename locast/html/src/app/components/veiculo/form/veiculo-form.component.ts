import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { VeiculoService } from '../../service/veiculo.service';
import { ModeloService } from '../../service/modelo.service';
import { FabricanteService } from '../../service/fabricante.service';
import { VeiculoForm } from '../../model/veiculoForm.model';
import { Modelo } from '../../model/modelo.model';
import { Fabricante } from '../../model/fabricante.model';

@Component({
  selector: 'app-veiculo-form',
  templateUrl: './veiculo-form.component.html',
  styleUrls: ['./veiculo-form.component.css']
})
export class VeiculoFormComponent implements OnInit {
  
  public modelos: Array<Modelo>;
  public fabricantes: Array<Fabricante>;
  public formCadastro: FormGroup;

  constructor(private form: FormBuilder,
    private veiculoService: VeiculoService,
    private modeloService: ModeloService,
    private fabricanteService: FabricanteService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {

    this.formCadastro = this.form.group({
      ano: [null, [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(4)
      ]],
      placa: [null, [
        Validators.required,
        Validators.minLength(7),
        Validators.maxLength(7)
      ]],
      idModelo:['', [Validators.required]],
      idFabricante:['', [Validators.required]]
    });

    this.getModelos();
    this.getFabricantes();
  }
  public salvar(veiculo: VeiculoForm): void {
    this.veiculoService.salvar(veiculo).subscribe(() =>this.voltar(), (err) => 
      erro => console.log("Erro ao inserir", erro))
  }
  verificaDuplicidade(placa: string): void {
    if(!placa) return;

    this.veiculoService.isDuplicado(placa).subscribe(isDuplicado =>{
      if(isDuplicado) {
        alert("Placa ja cadastrada!");
        this.formCadastro.controls.placa.reset();
      }
    });
  }
  private voltar(): void {
    this.router.navigate(['/veiculo/'])
  }
  getModelos(): void {
    this.modeloService.get().subscribe(modelos =>this.modelos = modelos);

  }
  getFabricantes(): void {
    this.fabricanteService.get().subscribe(fabricantes => this.fabricantes = fabricantes);
  }
  getFabricante(id : number): void {
    this.modeloService.getOnChangeSelect(id).subscribe(modelos => this.modelos = modelos);
    this.fabricanteService.onChangeSelect(this.modelos[0].fabricante.id).subscribe(fabricantes=> this.fabricantes = fabricantes);
    this.getModelos();
  }

}