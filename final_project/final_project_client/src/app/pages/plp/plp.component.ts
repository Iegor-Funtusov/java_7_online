import { Component, OnInit } from '@angular/core';
import { PlpService } from "../../services/plp.service";
import {Observable} from "rxjs";
import {PlpData} from "../../models/response/product/plp.data";
import {AsyncPipe, JsonPipe, NgForOf, NgIf} from "@angular/common";
import {Router} from "@angular/router";

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

  products$: Observable<PlpData[]> =  this.service.loadProducts();

  constructor(private service: PlpService, private router: Router) { }

  ngOnInit(): void { }

  redirectToPdp(productId: number): void {
    this.router.navigateByUrl('/pdp/' + productId)
  }
}
