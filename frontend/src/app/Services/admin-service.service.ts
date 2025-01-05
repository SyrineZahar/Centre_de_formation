import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Formation } from 'src/app/classes/Formation';  // Update with the correct path to your Formation class
import { AuthService } from './auth.service'; // Inject AuthService for token

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private apiUrl = 'http://localhost:8088/admin/formations';  // Update with your actual API URL

  constructor(private http: HttpClient, private authService: AuthService) { }

  // Get all formations
  getAllFormations(): Observable<Formation[]> {
    const headers = { Authorization: `Bearer ${this.authService.getToken()}` };
    return this.http.get<Formation[]>(this.apiUrl, { headers });
  }

  // Get a formation by ID
  getFormationById(id: number): Observable<Formation> {
    const headers = { Authorization: `Bearer ${this.authService.getToken()}` };
    return this.http.get<Formation>(`${this.apiUrl}/${id}`, { headers });
  }

  // Add a new formation
  addFormation(formation: Formation): Observable<Formation> {
    const headers = { Authorization: `Bearer ${this.authService.getToken()}` };    return this.http.post<Formation>(this.apiUrl, formation, { headers });
  }

  // Update an existing formation
  updateFormation(id: number, formation: Formation): Observable<Formation> {
    const headers = { Authorization: `Bearer ${this.authService.getToken()}` };    return this.http.put<Formation>(`${this.apiUrl}/${id}`, formation, { headers });
  }

  // Delete a formation by ID
  deleteFormation(id: number): Observable<void> {
    const headers = { Authorization: `Bearer ${this.authService.getToken()}` };

        return this.http.delete<void>(`${this.apiUrl}/${id}`, { headers });
  }
}
