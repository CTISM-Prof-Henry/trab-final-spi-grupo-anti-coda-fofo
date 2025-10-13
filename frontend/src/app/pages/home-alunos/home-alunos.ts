import { Component } from '@angular/core';
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-home-alunos',
    imports: [
        NgIf
    ],
  templateUrl: './home-alunos.html',
  styleUrl: './home-alunos.css'
})
export class HomeAlunos {
  activeSection: string = 'home';

  setSection(section: string) {
    this.activeSection = section;
  }

}
