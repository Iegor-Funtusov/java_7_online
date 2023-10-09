import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { AsyncPipe, JsonPipe, NgForOf, NgIf } from "@angular/common";
import { Observable } from "rxjs";

import { ProductPlpService } from "../../services";
import { ProductPlpData } from "../../models/response";

@Component({
  selector: 'app-plp',
  standalone: true,
  templateUrl: './plp.component.html',
  imports: [
    NgIf,
    AsyncPipe,
    JsonPipe,
    NgForOf
  ],
  styleUrls: ['./plp.component.scss']
})
export class PlpComponent implements OnInit {

  products$: Observable<ProductPlpData[]> =  this.productPlpService.loadProducts();

  constructor(private productPlpService: ProductPlpService, private router: Router) { }

  ngOnInit(): void { }

  redirectToPdp(productId: number): void {
    this.router.navigateByUrl('/pdp/' + productId)
  }
}
