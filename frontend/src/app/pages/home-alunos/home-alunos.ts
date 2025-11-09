import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-home-alunos',
  templateUrl: './home-alunos.html',
  styleUrl: './home-alunos.css',
  imports: [CommonModule,]
})
export class HomeAlunos {
  activeSection = 'home';
  constructor(private router: Router) {}
  dias = ['Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta'];
  horarios = ['08:00 - 10:00', '10:00 - 12:00', '13:30 - 15:30', '15:30 - 17:30'];

  salas: any[] = [
    { dia: 'Segunda', hora: '08:00 - 10:00', agendada: true, sala: 'Lab 1', professor: 'Prof. Ricardo' },
    { dia: 'Quarta', hora: '13:30 - 15:30', agendada: true, sala: 'Lab 3', professor: 'Prof. Ana Paula' },
    { dia: 'Sexta', hora: '10:00 - 12:00', agendada: true, sala: 'Multimídia', professor: 'Prof. João' }
  ];

  navigate(path: string) {
    this.router.navigate([path]);
  }
  setSection(section: string) {
    this.activeSection = section;
  }

  logout() {
    console.log('Logout...');
  }

  getSala(dia: string, hora: string) {
    return this.salas.find(s => s.dia === dia && s.hora === hora);
  }

  protected readonly navigator = navigator;
}
