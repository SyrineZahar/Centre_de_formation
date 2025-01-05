import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Formation } from '../classes/Formation';

@Injectable({
  providedIn: 'root'
})
export class FormationService {
  private baseUrl = 'http://localhost:8088/formations'; 

  constructor(private http: HttpClient) { }

  getAllFormations(): Observable<Formation[]> {
    return this.http.get<Formation[]>(`${this.baseUrl}`)

  }

  getFormationById(id: number): Observable<Formation> {
    return this.http.get<Formation>(`${this.baseUrl}/${id}`)
  }
 
}
