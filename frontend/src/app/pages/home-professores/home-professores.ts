import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home-professores',
  imports: [],
  templateUrl: './home-professores.html',
  styleUrl: './home-professores.css'
})
export class HomeProfessores {
  constructor(private router: Router) {}
  navigate(path: string) {
    this.router.navigate([path]);
  }
}
