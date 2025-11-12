import { Component } from '@angular/core';
import {MatError, MatFormField, MatLabel} from '@angular/material/form-field';
import {MatInput} from '@angular/material/input';
import {MatButton} from '@angular/material/button';
import {MatCardActions} from '@angular/material/card';
import {Router, RouterLink} from '@angular/router';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {AuthService} from '../../core/services/auth-service';

@Component({
  selector: 'app-login-component',
  imports: [
    MatFormField,
    MatInput,
    MatButton,
    MatCardActions,
    MatLabel,
    MatError,
    RouterLink,
    ReactiveFormsModule
  ],
  templateUrl: './login-component.html',
  styleUrl: './login-component.css'
})
export class LoginComponent {
  form: FormGroup;

  constructor(
    private authService: AuthService,
    private fb: FormBuilder,
    private router: Router
  ) {
    this.form = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
  }

  protected onSubmit() {
    if (this.form.valid) {
      const {email, password} = this.form.value;

      this.authService.login(email, password).subscribe({
        next: (token) => {
          console.log('Login com sucesso, token', token);
          this.authService.setToken(token)
          this.router.navigate(['/home']);
        },
        error: (err) => {
          console.log('Login falhou', err)
        }
      });
    }
  }

}
