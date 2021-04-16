import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Tarefas } from '../models/tarefas';
import { Observable } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar';
import { validateHorizontalPosition } from '@angular/cdk/overlay';

@Injectable({
  providedIn: 'root'
})
export class TarefasService {

  baseUrl = environment.baseUrl;

  constructor(private http: HttpClient, private snack: MatSnackBar) { }

  findAll(): Observable<Tarefas[]> {
    return this.http.get<Tarefas[]>(this.baseUrl);
  }

  findById(id: any): Observable<Tarefas>{
    const url = `${this.baseUrl}/${id}`
    return this.http.get<Tarefas>(url);
  }

  update(tarefa: Tarefas): Observable<Tarefas>{
    const url = `${this.baseUrl}/${tarefa.id}`
    return this.http.put<Tarefas>(url, tarefa);
  }

  delete(id: any): Observable<void>{
    const url = `${this.baseUrl}/${id}`
    return this.http.delete<void>(url);
  }

  create(tarefa: Tarefas): Observable<Tarefas>{
    return this.http.post<Tarefas>(this.baseUrl, tarefa);
  }

  message(msg: String): void{
    this.snack.open(`${msg}`, 'OK', {
        horizontalPosition: 'end',
        verticalPosition: 'top',
        duration: 4000
      }
    )
  }
}
