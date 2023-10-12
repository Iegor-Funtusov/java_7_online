import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { map, Observable } from "rxjs";

import { AppApiConfig } from "../app-api.config";
import { ProductIndexData, ResponseData } from "../models/response";

@Injectable({
  providedIn: 'root'
})
export class ProductSearchService {

  private openBaseUrl: string = AppApiConfig.openBaseUrl;

  constructor(private http: HttpClient) { }

  search(query: string): Observable<ProductIndexData[]> {
    return this.http.get<ResponseData<ProductIndexData[]>>(`${this.openBaseUrl}/products/search?query=${query}`)
      .pipe(
        map(res => res.data)
      );
  }
}
