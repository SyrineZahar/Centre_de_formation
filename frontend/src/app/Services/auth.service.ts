import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8088/auth';  

  private isLoggedInSubject = new BehaviorSubject<boolean>(this.getToken() !== null); 
  public isLoggedIn$: Observable<boolean> = this.isLoggedInSubject.asObservable(); 

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {
    const credentials = { username, password };
    return this.http.post<any>(`${this.baseUrl}/login`, credentials);
  }

  setToken(token: string): void {
    localStorage.setItem('token', token);
    this.isLoggedInSubject.next(true); 
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  clearToken(): void {
    localStorage.removeItem('token');
    this.isLoggedInSubject.next(false); 
  }
}
