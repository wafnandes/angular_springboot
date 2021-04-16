import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TarefasService } from 'src/app/services/tarefas.service';
import { Tarefas } from '../../models/tarefas';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  tarefa: Tarefas = {
    titulo: '',
    descricao: '',
    dataParaFinalizar: new Date(),
    finalizado: false
  }

  constructor(private router: Router, private service: TarefasService) { }

  ngOnInit(): void {
  }

  create(): void{
    this.formataData()
    this.service.create(this.tarefa).subscribe((resposta) => {
      this.service.message('Tarefa criada com sucesso!')
      this.router.navigate([''])
    }, err => {
      this.service.message('Erro ao criar tarefa');
      this.router.navigate([''])
    })  
  }

  cancel(): void{
    this.router.navigate([''])
  }

  formataData(): void{
    let data = new Date(this.tarefa.dataParaFinalizar)
    this.tarefa.dataParaFinalizar = `${data.getDate()}/${data.getMonth() + 1}/${data.getFullYear()}`
  }
}
