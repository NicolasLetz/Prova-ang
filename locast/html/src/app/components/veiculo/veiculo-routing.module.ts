import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { VeiculoListComponent } from './list/veiculo-list.component';
import { VeiculoFormComponent } from './form/veiculo-form.component';

const routes: Routes = [
  {path: '', component: VeiculoListComponent},
  {path: 'create', component: VeiculoFormComponent}
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class VeiculoRoutingModule { }
