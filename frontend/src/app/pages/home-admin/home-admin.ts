import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home-admin',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home-admin.html',
  styleUrls: ['./home-admin.css']
})
export class HomeAdmin {
  activeSection: string = 'home';
  constructor(private router: Router) {}

  navigate(path: string) {
    this.router.navigate([path]);
  }
  setSection(section: string) {
    this.activeSection = section;
  }
}
