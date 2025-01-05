import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Formation } from 'src/app/classes/Formation';
import { AdminService } from 'src/app/Services/admin-service.service';

@Component({
  selector: 'app-add-edit-formation',
  templateUrl: './add-edit-formation.component.html',
  styleUrls: ['./add-edit-formation.component.css']
})
export class AddEditFormationComponent implements OnInit {
  formationForm!: FormGroup;
  isEditMode = false;
  formationId!: number;

  constructor(
    private fb: FormBuilder,
    private adminService: AdminService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.formationForm = this.fb.group({
      title: ['', Validators.required],
      description: ['', Validators.required],
      price: [0, [Validators.required, Validators.min(0)]],
      duration: [0, [Validators.required, Validators.min(1)]],
      image: ['']
    });

    this.route.params.subscribe((params) => {
      if (params['id']) {
        this.isEditMode = true;
        this.formationId = +params['id'];
        this.loadFormation(this.formationId);
      }
    });
  }

  loadFormation(id: number): void {
    this.adminService.getFormationById(id).subscribe((formation) => {
      this.formationForm.patchValue(formation);
    });
  }

  onSubmit(): void {
    const formation: Formation = this.formationForm.value;

    if (this.isEditMode) {
      this.adminService.updateFormation(this.formationId, formation).subscribe(() => {
        alert('Formation updated successfully!');
        this.router.navigate(['/admin/dashboard']);
      });
    } else {
      this.adminService.addFormation(formation).subscribe(() => {
        alert('Formation added successfully!');
        this.router.navigate(['/admin/dashboard']);
      });
    }
  }

  onCancel(): void {
    this.router.navigate(['/admin/dashboard']);
  }
}
