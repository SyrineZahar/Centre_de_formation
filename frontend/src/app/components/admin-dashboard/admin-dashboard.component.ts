import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/Services/admin-service.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
  formations: any[] = [];
  searchTitle: string = '';

  constructor(private adminService: AdminService, private router: Router) {}

  ngOnInit(): void {
    this.loadFormations();
  }

  loadFormations(): void {
    this.adminService.getAllFormations().subscribe((data) => {
      this.formations = data;
    });
  }

  onSearchChange(): void {
    if (this.searchTitle.trim() == '') {
      this.loadFormations(); 
    }
  }

  searchFormations(): void {
    if (this.searchTitle.trim() == '') {
      this.loadFormations(); 
    } else {
      this.adminService.getFormationsByTitle(this.searchTitle).subscribe((data) => {
        this.formations = data;
      });
    }
  }

  openAddFormation(): void {
    this.router.navigate(['/admin/formation']);
  }

  openEditFormation(formation: any): void {
    this.router.navigate(['/admin/formation', formation.id]);
  }

  deleteFormation(id: number): void {
    if (confirm('Are you sure you want to delete this formation?')) {
      this.adminService.deleteFormation(id).subscribe(() => {
        this.loadFormations();
      });
    }
  }
}
