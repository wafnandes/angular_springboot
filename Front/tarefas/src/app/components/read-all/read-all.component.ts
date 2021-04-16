import { Component, OnInit } from '@angular/core';
import { ShowOnDirtyErrorStateMatcher } from '@angular/material/core';
import { Router } from '@angular/router';
import { TarefasService } from 'src/app/services/tarefas.service';
import { Tarefas } from '../../models/tarefas';

@Component({
  selector: 'app-read-all',
  templateUrl: './read-all.component.html',
  styleUrls: ['./read-all.component.css']
})
export class ReadAllComponent implements OnInit {

  list: Tarefas[] = []
  listFinished: Tarefas[] = []
  closed = 0;

  constructor(private service: TarefasService, private router: Router) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void{
    this.service.findAll().subscribe((resposta) => {
      resposta.forEach(tarefas => {
        if(tarefas.finalizado) {
          this.listFinished.push(tarefas);
        } else {
          this.list.push(tarefas);
        }
      })
      this.closed = this.listFinished.length
    });
  }

  finalizar(item: Tarefas): void{
    item.finalizado = true;
    this.service.update(item).subscribe(() => {
      this.service.message('Tarefa finalizada com sucesso!');
      this.list = this.list.filter(tarefas => tarefas.id !== item.id);
      this.closed++;
    })
  }

  delete(id: any): void{
    this.service.delete(id).subscribe((resposta) => {
      if(resposta === null){
        this.service.message('Tarefa deletada com sucesso!');
        this.list = this.list.filter(tarefas => tarefas.id !== id)
      }
    })
  }

  navegarParaFinalizados(): void{
    this.router.navigate(['finalizados'])
  }

  novaTarefa(): void{
    this.router.navigate(['create'])
  }



}
