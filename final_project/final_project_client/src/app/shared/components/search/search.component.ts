import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {ProductSearchService} from "../../../services/product-search.service";
import {BehaviorSubject, Observable, Subscription, switchMap} from "rxjs";
import {ProductIndexData} from "../../../models/response";
import {AsyncPipe, JsonPipe, NgForOf, NgIf} from "@angular/common";
import {Router} from "@angular/router";

@Component({
  selector: 'app-search',
  standalone: true,
  templateUrl: './search.component.html',
  imports: [
    ReactiveFormsModule,
    NgForOf,
    AsyncPipe,
    NgIf,
    JsonPipe
  ],
  styleUrls: ['./search.component.scss']
})
export class SearchComponent implements OnInit, OnDestroy {

  private subscription = new Subscription();
  private productSearchStoreSub$ = new BehaviorSubject<ProductIndexData[]>([]);
  readonly productSearchStore$: Observable<ProductIndexData[]> = this.productSearchStoreSub$.asObservable();

  searchForm: FormGroup = this.fb.group({
    query: new FormControl()
  });

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private productSearchService: ProductSearchService) {
  }

  ngOnInit(): void {
    this.subscription.add(
      this.searchForm.valueChanges
        .pipe(
          switchMap(value => this.productSearchService.search(value.query))
        )
        .subscribe(res => {
          this.productSearchStoreSub$.next(res);
        })
    );
  }

  navigateToVariant(vId: number, pId: number): void {
    this.router.navigateByUrl('/pdp/' + pId + '?variant=' + vId)
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
