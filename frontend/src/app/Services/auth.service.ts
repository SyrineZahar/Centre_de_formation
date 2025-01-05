import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8088/auth';  

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {
    const credentials = { username, password };
    return this.http.post<any>(`${this.apiUrl}/login`, credentials)
  }
  setToken(token: string): void {
    localStorage.setItem('token', token);
  }

  getToken(): string | null {
    const token = localStorage.getItem('token');
    return token;
  }
  
  clearToken(): void {
    localStorage.removeItem('token');
  }
}
