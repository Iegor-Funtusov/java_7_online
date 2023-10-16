import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { AsyncPipe, NgIf } from "@angular/common";
import { BehaviorSubject, Observable, Subscription } from "rxjs";

import { AuthService } from "../../services/auth.service";
import { AuthData } from "../../models/request/auth.data";

@Component({
  selector: 'app-registration',
  standalone: true,
  templateUrl: './registration.component.html',
  imports: [
    AsyncPipe,
    NgIf,
    ReactiveFormsModule
  ],
})
export class RegistrationComponent implements OnInit, OnDestroy {

  private subscription = new Subscription();
  private isValidFormSub$ = new BehaviorSubject<boolean>(false);

  isValidForm$: Observable<boolean> = this.isValidFormSub$.asObservable();

  registerForm: FormGroup = this.fb.group({
    username: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(8)]]
  });

  constructor(private fb: FormBuilder, private router: Router, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.subscription.add(
      this.registerForm.statusChanges
        .subscribe(statusChanges => {
          this.isValidFormSub$.next(statusChanges === 'VALID')
        })
    );
  }

  register(): void {
    if (this.registerForm.valid) {
      const data: AuthData = { ...this.registerForm.value };
      this.subscription.add(
        this.authService.register(data)
          .subscribe(
            (auth) => {
              localStorage.setItem("token", JSON.stringify(auth));
              this.router.navigateByUrl("/")
            },
            () => alert("Invalid credentials"))
      );
    }
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
    this.isValidFormSub$.complete();
  }
}
