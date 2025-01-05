import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Formation } from 'src/app/classes/Formation';
import { FormationService } from 'src/app/Services/formation.service';
import { FormationDetailsComponent } from '../formation-details/formation-details.component';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  courses: Formation[] = []; 

  constructor(private formationService: FormationService, private dialog: MatDialog) {}

  ngOnInit(): void {
    this.loadCourses();
  }


  loadCourses(): void {
    this.formationService.getAllFormations().subscribe(
      (data: Formation[]) => {
        console.log(data)
        this.courses = data;
      },
      (error) => {
        console.error('Failed to load courses', error);
      }
    );
  }

  openCourseDetails(course: any): void {
    this.dialog.open(FormationDetailsComponent, {
      data: { course },
      width: '80%',           
      maxWidth: '400px',     
    });
  }
}
