import { Component } from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import { UsuariosService } from '../../../../../core/services/usuarios-service';
import {MatError, MatFormField, MatFormFieldModule, MatLabel} from '@angular/material/form-field';
import {MatInput, MatInputModule} from '@angular/material/input';
import {MatButton, MatButtonModule} from '@angular/material/button';
import {MatCardActions, MatCardModule} from '@angular/material/card';

@Component({
  selector: 'app-registrar-usuario',
  imports:[
    ReactiveFormsModule,
    RouterLink,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule
  ],
  templateUrl: './registrar-usuario.html',
  styleUrls: ['./registrar-usuario.css'] // note o plural
})
export class RegistrarUsuario {

  formReg: FormGroup;

  constructor(
    private usuariosService: UsuariosService,
    private fb: FormBuilder,
    private router: Router
  ) {
    this.formReg = this.fb.group({
      "register": ['', Validators.required],
      "email": ['', [Validators.required, Validators.email]],
      "password": ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.formReg.valid) {
      this.usuariosService.register(this.formReg.value).subscribe({
        next: (res) => {
          console.log('Usuário registrado!', res);
          this.router.navigate(['/usuarios']);
        },
        error: (err) => console.error('Erro ao registrar', err)
      });
    }
  }

}
