import {Component, OnInit} from '@angular/core';
import {Usuario, UsuariosService} from '../../../../core/services/usuarios-service';
import {MatTableModule} from '@angular/material/table';

@Component({
  selector: 'app-usuario',
  imports: [
    MatTableModule
  ],
  templateUrl: './usuarios.html',
  styleUrl: './usuarios.css'
})

export class Usuarios implements OnInit{
  usuarios: Usuario[] = [];
  displayedColumns = ['id', 'register', 'email', 'role'];

  constructor(private usuarioService: UsuariosService) {}

  ngOnInit() {
    this.usuarioService.getAll().subscribe({
      next: (data) => (this.usuarios = data),
      error: (err) => console.error('Erro ao carregar usuários', err)
    });
  }

}
