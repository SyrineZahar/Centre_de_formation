import { CanActivateFn } from '@angular/router';
import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../Services/auth.service';

export const authGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);  
  const router = inject(Router);  

  const token = authService.getToken();
  if (token) {
    return true; 
  }

  router.navigate(['admin/login']);
  return false; 
};
