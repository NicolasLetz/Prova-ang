import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ReactiveFormsModule } from '@angular/forms';
import { VeiculoRoutingModule } from './veiculo-routing.module';

import { VeiculoFormComponent } from './form/veiculo-form.component';
import { VeiculoListComponent } from './list/veiculo-list.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    VeiculoRoutingModule
  ],
  declarations: [
    VeiculoFormComponent,
     VeiculoListComponent
    ]
})
export class VeiculoModule { }
