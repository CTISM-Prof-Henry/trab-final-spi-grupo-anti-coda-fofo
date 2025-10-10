import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home';
import { HomeAdmin } from './pages/home-admin/home-admin';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'admin', component: HomeAdmin },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '**', redirectTo: 'home' }
];
