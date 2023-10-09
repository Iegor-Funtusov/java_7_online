import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { map, Observable } from "rxjs";

import { ResponseData, ProductPlpData } from "../models/response";
import { AppApiConfig } from "../app-api.config";

@Injectable({
  providedIn: 'root'
})
export class ProductPlpService {

  private openBaseUrl: string = AppApiConfig.openBaseUrl;

  constructor(private http: HttpClient) { }

  loadProducts(): Observable<ProductPlpData[]> {
    return this.http.get<ResponseData<ProductPlpData[]>>(`${this.openBaseUrl}/products`)
      .pipe(
        map(res => res.data)
      );
  }
}
