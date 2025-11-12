import { Component, OnInit } from '@angular/core';
import { SalasService, Room } from '../../../../../core/services/sala-service'
import { MatTableModule } from '@angular/material/table';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import {Router} from '@angular/router';
import { Sidebar } from '../sidebar/sidebar';

@Component({
  selector: 'app-salas',
  standalone: true,
  imports: [CommonModule, MatTableModule, MatCardModule, MatToolbarModule, MatIconModule, MatButtonModule, Sidebar],
  templateUrl: './ver-salas.html',
  styleUrls: ['./ver-salas.css']
})
export class VerSalas implements OnInit {
  activeSection: string = 'salas';
  salas: Room[] = [];
  displayedColumns: string[] = ['id', 'name', 'roomType', 'center', 'capacity'];

  constructor(private salasService: SalasService, private router: Router) {}

  ngOnInit() {
    this.salasService.listarSalas().subscribe({
      next: (data) => (this.salas = data),
      error: (err) => console.error('Erro ao carregar salas:', err),
    });
  }

  navigate(path: string) {
    this.router.navigate([path]);
  }
  setSection(section: string) {
    this.activeSection = section;
  }
}
