import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private httpClient: HttpClient) {
  }

  login(email: string, password: string): Observable<string> {
    return this.httpClient.post<string>("http://localhost:8080/api/session", {email, password});
  }

  setToken(token: string) {
    localStorage.setItem('auth_token', JSON.stringify(token));
    console.log(this.getToken())
  }

  getToken(): string | null {
    const stored = localStorage.getItem('auth_token');
    if (!stored) return null;

    try {
      const parsed = JSON.parse(stored);
      return parsed.accessToken || null;
    } catch {
      return stored;
    }
  }

  logout() {
    localStorage.removeItem('auth_token');
  }
}
