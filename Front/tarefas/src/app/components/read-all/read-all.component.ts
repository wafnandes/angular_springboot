import { Component, OnInit } from '@angular/core';
import { ShowOnDirtyErrorStateMatcher } from '@angular/material/core';
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

  constructor(private service: TarefasService) { }

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

  delete(id: any): void{
    this.service.delete(id).subscribe((resposta) => {
      if(resposta === null){
        this.service.message('Tarefa deletada com sucesso!');
        this.list = this.list.filter(tarefas => tarefas.id !== id)
      }
    })
  }


}
