import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Tarefas } from 'src/app/models/tarefas';
import { TarefasService } from 'src/app/services/tarefas.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  tarefa: Tarefas = {
    titulo: '',
    descricao: '',
    dataParaFinalizar: new Date(),
    finalizado: false
  }

  constructor(private router: Router, private service: TarefasService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.tarefa.id = this.route.snapshot.paramMap.get("id")!;
    this.findById();
  }

  findById(): void{
    this.service.findById(this.tarefa.id).subscribe((resposta) => {
      this.tarefa = resposta;
    })
  }

  update(): void{
    this.service.update(this.tarefa).subscribe((resposta) => {
      this.service.message('Informações atualizadas com sucesso!');
      this.router.navigate([''])
    }, err => {
      this.service.message('Falha ao atualizar a tarefa!');
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
