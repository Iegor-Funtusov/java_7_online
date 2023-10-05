import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {map, Observable} from "rxjs";
import {ResponseData} from "../models/response/response.data";
import {PlpData} from "../models/response/product/plp.data";

@Injectable({
  providedIn: 'root'
})
export class PlpService {

  constructor(private http: HttpClient) { }

  loadProducts(): Observable<PlpData[]> {
    return this.http.get<ResponseData<PlpData[]>>('http://localhost:8080/api/open/products')
      .pipe(
        map(res => res.data)
      );
  }
}
