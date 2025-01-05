import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/Services/admin-service.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {
    formations: any[] = [];
    showModal: boolean = false; 
    isEditMode: boolean = false;

    constructor(private adminService: AdminService) {}

    ngOnInit(): void {
      this.loadFormations();
    }

    loadFormations(): void {
      this.adminService.getAllFormations().subscribe((data) => {
        this.formations = data;
      });
    }

    openAddFormationModal(): void {
      this.isEditMode = false;
      this.showModal = true;
    }

    openEditFormationModal(formation: any): void {
      this.isEditMode = true;
      this.showModal = true;
    }


    deleteFormation(id: number): void {
      if (confirm('Are you sure you want to delete this formation?')) {
        this.adminService.deleteFormation(id).subscribe(() => {
          this.loadFormations();  
        });
      }
    }
}
