import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-sidebar-public',
  imports: [CommonModule, RouterLink],
  templateUrl: './sidebar-public.html',
  standalone: true,
  styleUrl: './sidebar-public.css'
})
export class SidebarPublic {
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
