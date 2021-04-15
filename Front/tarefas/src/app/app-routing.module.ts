import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReadAllComponent } from './components';
import { FinalizadosComponent } from './components/finalizados/finalizados.component';

const routes: Routes = [
  {
    path:'',
    component: ReadAllComponent
  },
  {
    path:'finalizados',
    component: FinalizadosComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
