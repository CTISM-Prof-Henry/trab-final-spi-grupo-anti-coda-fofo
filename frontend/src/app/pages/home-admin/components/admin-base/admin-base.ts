import { Component } from '@angular/core';
import {Router, RouterLink, RouterOutlet} from '@angular/router';
import {CommonModule} from '@angular/common';
import { NgModule } from '@angular/core';


@Component({
  selector: 'app-admin-base',
  imports: [CommonModule, RouterLink, RouterOutlet],
  templateUrl: './admin-base.html',
  styleUrl: './admin-base.css'
})
export class AdminBase {
  activeSection: string = 'home';
  constructor(private router: Router) {}

  navigate(path: string) {
    this.router.navigate([path]);
  }
  setSection(section: string) {
    this.activeSection = section;
  }
}
