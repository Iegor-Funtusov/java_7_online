import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { AsyncPipe, NgIf } from "@angular/common";
import { BehaviorSubject, Observable, Subscription } from "rxjs";

import { AuthData } from "../../models/request/auth.data";
import { AuthService } from "../../services/auth.service";

@Component({
  selector: 'app-login',
  standalone: true,
  templateUrl: './login.component.html',
  imports: [
    ReactiveFormsModule,
    NgIf,
    AsyncPipe
  ],
})
export class LoginComponent implements OnInit, OnDestroy {

  private subscription = new Subscription();
  private isValidFormSub$ = new BehaviorSubject<boolean>(false);

  isValidForm$: Observable<boolean> = this.isValidFormSub$.asObservable();

  loginForm: FormGroup = this.fb.group({
    username: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(8)]]
  });

  constructor(private fb: FormBuilder, private router: Router, private authService: AuthService) {
  }

  ngOnInit(): void {
    this.subscription.add(
      this.loginForm.statusChanges
        .subscribe(statusChanges => {
          this.isValidFormSub$.next(statusChanges === 'VALID')
        })
    );
  }

  login(): void {
    if (this.loginForm.valid) {
      const data: AuthData = { ...this.loginForm.value };
      this.subscription.add(
        this.authService.login(data)
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
