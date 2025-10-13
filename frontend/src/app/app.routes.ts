import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home';
import { HomeAdmin } from './pages/home-admin/home-admin';
import {HomeProfessores} from './pages/home-professores/home-professores';
import {HomeAlunos} from './pages/home-alunos/home-alunos';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'admin', component: HomeAdmin },
  { path: 'professores', component: HomeProfessores },
  { path: 'alunos', component: HomeAlunos },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '**', redirectTo: 'home' }
];
