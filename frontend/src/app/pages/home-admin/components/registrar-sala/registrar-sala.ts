import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { SalasService } from '../../../../../core/services/sala-service';
import { Router, RouterLink } from '@angular/router';

// Importação correta dos módulos Angular Material
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatCardModule } from '@angular/material/card';
import {NgFor} from '@angular/common';

@Component({
  selector: 'app-registrar-sala',
  templateUrl: './registrar-sala.html',
  styleUrls: ['./registrar-sala.css'],
  standalone: true,
  imports: [
    ReactiveFormsModule,
    RouterLink,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatCardModule,
    NgFor
  ]
})
export class RegistrarSala {
  formSala: FormGroup;
  centers: string[] = ['A','B','C','D','E','F','G','OUTRO'];

  constructor(
    private fb: FormBuilder,
    private salaService: SalasService,
    private router: Router
  ) {
    this.formSala = this.fb.group({
      name: ['', Validators.required],
      roomType: ['', Validators.required],
      center: ['', Validators.required],
      capacity: [null, [Validators.required, Validators.min(1)]]
    });
  }

  onSubmit() {
    if (this.formSala.valid) {
      const salaData = this.formSala.value; // JSON correto
      console.log('Dados da Sala:', salaData);

      this.salaService.criarSala(salaData).subscribe({
        next: (res) => {
          console.log('Sala registrada!', res);
          this.router.navigate(['/home-admin/salas']);
        },
        error: (err) => console.error('Erro ao registrar sala', err)
      });
    }
  }
}
