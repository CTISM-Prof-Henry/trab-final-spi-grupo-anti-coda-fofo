import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class HomeComponent{
  constructor(private router: Router) {}

  navigate(path: string) {
    this.router.navigate([path]);
  }
}
