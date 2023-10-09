import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map, Observable } from "rxjs";

import { ResponseData, ProductPdpData } from "../models/response";
import { AppApiConfig } from "../app-api.config";

@Injectable({
  providedIn: 'root'
})
export class ProductPdpService {

  private openBaseUrl: string = AppApiConfig.openBaseUrl;

  constructor(private http: HttpClient) { }

  loadProductById(id: string): Observable<ProductPdpData> {
    return this.http.get<ResponseData<ProductPdpData>>(`${this.openBaseUrl}/products/${id}`)
      .pipe(
        map(res => res.data)
      );
  }
}
