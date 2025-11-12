import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home';
import { HomeAdmin } from './pages/home-admin/home-admin';

import {HomeProfessores} from './pages/home-professores/home-professores';

import {authGuard} from '../core/guards/auth.guard';
import {Usuarios} from './pages/home-admin/usuarios/usuarios'
import { RegistrarUsuario} from './pages/home-admin/components/registrar-usuario/registrar-usuario'
import { VerSalas } from './pages/home-admin/components/ver-salas/ver-salas'
import {AdminBase} from './pages/home-admin/components/admin-base/admin-base'
import {RegistrarSala} from './pages/home-admin/components/registrar-sala/registrar-sala';
import {HomeAlunos} from './pages/home-alunos/home-alunos';


export const routes: Routes = [
  {
    path: 'login',
    loadComponent: () =>
      import('../modules/login/login-component').then(m => m.LoginComponent)
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'home-admin',
    canActivate: [authGuard],
    component: HomeAdmin,
    children: [
      {path: "", component: AdminBase},
      { path: 'usuarios', component: Usuarios },
      { path: 'usuario-registrar', component: RegistrarUsuario },
      { path: 'salas', component: VerSalas },
      { path: 'sala-registrar', component: RegistrarSala}
    ]
  },
  {
    path: 'usuarios',
    canActivate: [authGuard],
    component: Usuarios
  },
  {
    path: 'usuario-registrar',
    canActivate: [authGuard],
    component: RegistrarUsuario
  },
  {
    path: 'aulas',
    component: HomeAlunos
  },
  {
    path: 'professores',
    component: HomeProfessores
  }
];

