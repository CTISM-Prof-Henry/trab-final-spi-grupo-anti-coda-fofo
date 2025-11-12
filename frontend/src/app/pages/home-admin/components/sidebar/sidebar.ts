import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './sidebar.html',
  styleUrls: ['./sidebar.css']
})
export class Sidebar {
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
