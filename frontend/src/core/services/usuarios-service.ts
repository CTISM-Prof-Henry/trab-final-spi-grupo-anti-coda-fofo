import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import { env } from '../../environment/environment';
import { AuthService } from './auth-service';



export interface Usuario {
  id: string;
  register: string;
  email: string;
  role: string;
  password?: string;
}
@Injectable({ providedIn: 'root' })
export class UsuariosService {
  private readonly apiUrl = `${env.apiUrl}/users/`;

  constructor(private http: HttpClient,
              private authService: AuthService)
  {}

  getAll(): Observable<Usuario[]> {

    const token = this.authService.getToken();

    console.log('[UsuariosService] Token usado na requisição:', token);

    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    });

    return this.http.get<Usuario[]>(this.apiUrl, { headers });

  }

  register(user: Usuario): Observable<Usuario> {

    const token = this.authService.getToken();
    console.log('[UsuariosService] Token usado na requisição:', token);
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });

    return this.http.post<Usuario>(this.apiUrl, user, { headers });
  }
}
