import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Formation } from 'src/app/classes/Formation'; 
import { AuthService } from './auth.service'; 

@Injectable({
  providedIn: 'root',
})
export class AdminService {
  private apiUrl = 'http://localhost:8088/admin/formations'; 
  constructor(private http: HttpClient, private authService: AuthService) {}

  private getAuthHeaders(): HttpHeaders {
    return new HttpHeaders({
      Authorization: `Bearer ${this.authService.getToken()}`,
    });
  }

  getAllFormations(): Observable<Formation[]> {
    return this.http.get<Formation[]>(this.apiUrl, {
      headers: this.getAuthHeaders(),
    });
  }

  getFormationById(id: number): Observable<Formation> {
    return this.http.get<Formation>(`${this.apiUrl}/${id}`, {
      headers: this.getAuthHeaders(),
    });
  }

  addFormation(formation: Formation): Observable<Formation> {
    return this.http.post<Formation>(this.apiUrl, formation, {
      headers: this.getAuthHeaders(),
    });
  }

  updateFormation(id: number, formation: Formation): Observable<Formation> {
    return this.http.put<Formation>(`${this.apiUrl}/${id}`, formation, {
      headers: this.getAuthHeaders(),
    });
  }

  deleteFormation(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`, {
      headers: this.getAuthHeaders(),
    });
  }
}
