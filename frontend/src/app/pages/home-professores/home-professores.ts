import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-home-professores',
    imports: [
        NgIf
    ],
  templateUrl: './home-professores.html',
  styleUrl: './home-professores.css'
})
export class HomeProfessores {
  constructor(private router: Router) {}
  navigate(path: string) {
    this.router.navigate([path]);
  }
  activeSection: string = 'home';

  setSection(section: string) {
    this.activeSection = section;
  }

}
