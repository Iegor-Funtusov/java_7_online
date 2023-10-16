import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { map, Observable } from "rxjs";

import { AppApiConfig } from "../app-api.config";
import { AuthData } from "../models/request/auth.data";
import { AuthenticationData } from "../models/response/auth/authentication.data";
import { ResponseData } from "../models/response";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private openBaseUrl: string = AppApiConfig.openBaseUrl;

  constructor(private http: HttpClient) { }

  isLoggedIn(): boolean {
    let token = localStorage.getItem('token');
    if (token) {
      let authData: AuthenticationData = JSON.parse(token);
      if (authData?.accessToken) {
        return true;
      }
    }
    return false;
  }

  login(data: AuthData): Observable<AuthenticationData> {
    return this.http.post<ResponseData<AuthenticationData>>(`${this.openBaseUrl}/auth/login`, data)
      .pipe(
        map(res => res.data)
      );
  }

  register(data: AuthData): Observable<AuthenticationData> {
    return this.http.post<ResponseData<AuthenticationData>>(`${this.openBaseUrl}/auth/register`, data)
      .pipe(
        map(res => res.data)
      );
  }
}
