import {Component, EventEmitter, Input, Output} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Router, RouterLink} from '@angular/router';

@Component({
  selector: 'app-professor-sidebar',
  imports: [CommonModule, RouterLink],
  templateUrl: './professor-sidebar.html',
  styleUrl: './professor-sidebar.css'
})
export class ProfessorSidebar {
  @Input() activeSection: string = 'home';
  @Output() activeSectionChange = new EventEmitter<string>();

  isSidebarOpen = false;

  constructor(private router: Router) {}

  setSection(section: string) {
    this.activeSectionChange.emit(section);
  }

  navigate(path: string) {
    this.router.navigate([path]);
  }

  toggleSidebar() {
    this.isSidebarOpen = !this.isSidebarOpen;
  }
}
