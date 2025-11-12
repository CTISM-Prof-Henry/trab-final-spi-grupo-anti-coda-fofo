import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Router, RouterLink, RouterOutlet} from '@angular/router';
import {Sidebar} from './components/sidebar/sidebar';

@Component({
  selector: 'app-home-admin',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterOutlet, Sidebar],
  templateUrl: './home-admin.html',
  styleUrls: ['./home-admin.css']
})
export class HomeAdmin {
  activeSection: string = 'home';
  constructor(private router: Router) {}


  setSection(section: string) {
    this.activeSection = section;

    if (section === 'home') {
      this.router.navigate(['/home-admin']);
    } else if (section === 'usuarios') {
      this.router.navigate(['/home-admin/usuarios']);
    } else if (section === 'salas') {
      this.router.navigate(['/home-admin/salas']);
    }
  }
}
