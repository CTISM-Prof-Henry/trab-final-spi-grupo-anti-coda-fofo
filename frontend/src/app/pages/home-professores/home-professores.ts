import { Component } from '@angular/core';
import {Router, RouterLink, RouterOutlet} from '@angular/router';
import {CommonModule} from '@angular/common';
import {ProfessorSidebar} from './components/professor-sidebar/professor-sidebar';


@Component({
  selector: 'app-home-professores',
  imports: [CommonModule, RouterLink, RouterOutlet, ProfessorSidebar],
  templateUrl: './home-professores.html',
  styleUrl: './home-professores.css'
})
export class HomeProfessores {
  activeSection: string = 'home';


  constructor(private router: Router) {}

  setSection(section: string) {
    this.activeSection = section;

    if (section === 'home') {
      this.router.navigate(['/professores']);
    }
  }

}
