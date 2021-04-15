import { Component, OnInit } from '@angular/core';
import { TarefasService } from '../../services/tarefas.service';
import { Tarefas } from '../../models/tarefas';
import { Router } from '@angular/router';

@Component({
  selector: 'app-finalizados',
  templateUrl: './finalizados.component.html',
  styleUrls: ['./finalizados.component.css']
})
export class FinalizadosComponent implements OnInit {

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
        } 
      })
    });
  }

  voltar(): void{
    this.router.navigate(['']);
  }
}
