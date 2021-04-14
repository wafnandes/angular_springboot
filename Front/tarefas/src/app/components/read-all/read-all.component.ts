import { Component, OnInit } from '@angular/core';
import { TarefasService } from 'src/app/services/tarefas.service';
import { Tarefas } from '../../models/tarefas';

@Component({
  selector: 'app-read-all',
  templateUrl: './read-all.component.html',
  styleUrls: ['./read-all.component.css']
})
export class ReadAllComponent implements OnInit {

  list: Tarefas[] = [
    
  ]


  constructor(private service: TarefasService) { }

  ngOnInit(): void {
    this.findAll();
  }

  findAll(): void{
    this.service.findAll().subscribe((resposta) => 
      this.list = resposta
    )
  }

}
