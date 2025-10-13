import { Component } from '@angular/core';
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
  activeSection: string = 'home';

  setSection(section: string) {
    this.activeSection = section;
  }

}
