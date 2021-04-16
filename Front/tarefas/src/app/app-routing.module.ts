import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReadAllComponent } from './components';
import { CreateComponent } from './components/create/create.component';
import { FinalizadosComponent } from './components/finalizados/finalizados.component';
import { UpdateComponent } from './components/update/update.component';

const routes: Routes = [
  {
    path:'',
    component: ReadAllComponent
  },
  {
    path:'finalizados',
    component: FinalizadosComponent
  },
  {
    path:'create',
    component: CreateComponent
  },
  {
    path:'update/:id',
    component: UpdateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
