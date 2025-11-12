import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

import { env } from '../../../src/environment/environment';
import {AuthService} from './auth-service';

export interface Room {
  id: number;
  name: string;
  roomType: string;
  center: string;
  capacity: number;
}


@Injectable({ providedIn: 'root' })
export class SalasService {
  private readonly apiUrl = `${env.apiUrl}/rooms/`;

  constructor(private http: HttpClient, private authService: AuthService) {}

  listarSalas(): Observable<Room[]> {
    return this.http.get<Room[]>(this.apiUrl);
  }

  criarSala(sala: Room): Observable<Room> {

    const token = this.authService.getToken();
    console.log('[UsuariosService] Token usado na requisição:', token);
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });


    return this.http.post<Room>(this.apiUrl, sala, { headers });
  }
}
