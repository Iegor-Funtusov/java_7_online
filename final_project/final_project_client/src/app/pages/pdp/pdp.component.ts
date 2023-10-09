import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { AsyncPipe, JsonPipe, NgForOf, NgIf } from "@angular/common";
import { FormBuilder, FormControl, FormGroup, Validators } from "@angular/forms";
import { BehaviorSubject, Observable, of, take } from "rxjs";

import { ProductPdpService } from "../../services";
import { ProductPdpData } from "../../models/response";
import { ProductConfiguratorData } from "../../models/core/product";

@Component({
  selector: 'app-pdp',
  standalone: true,
  templateUrl: './pdp.component.html',
  imports: [
    AsyncPipe,
    NgIf,
    JsonPipe,
    NgForOf
  ],
  styleUrls: ['./pdp.component.scss']
})
export class PdpComponent implements OnInit, OnDestroy {

  private configuratorSub$ = new BehaviorSubject<ProductConfiguratorData>({});
  private enableBuyStatusSub$ = new BehaviorSubject<boolean>(false);
  readonly configurator$: Observable<ProductConfiguratorData> = this.configuratorSub$.asObservable();
  readonly enableBuyStatus$: Observable<boolean> = this.enableBuyStatusSub$.asObservable();

  private form: FormGroup = this.fb.group({
    os: new FormControl(null, [Validators.required]),
    cpu: new FormControl(null, [Validators.required]),
    ram: new FormControl(null, [Validators.required]),
    ssd: new FormControl(null, [Validators.required]),
    color: new FormControl(null, [Validators.required]),
    camera: new FormControl(null, [Validators.required]),
    displayResolution: new FormControl(null, [Validators.required]),
    displaySize: new FormControl(null, [Validators.required]),
    displayType: new FormControl(null, [Validators.required]),
  });

  product$: Observable<ProductPdpData | undefined> = of(undefined);

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private productPdpService: ProductPdpService) {}

  ngOnInit(): void {
    let url = this.router.routerState.snapshot.url;
    let id = url.split('/')[2];
    this.product$ = this.productPdpService.loadProductById(id);
    this.form.statusChanges.subscribe(status => {
      if (status === 'VALID') {
        this.enableBuyStatusSub$.next(true);
      } else {
        this.enableBuyStatusSub$.next(false);
      }
    })
  }

  setOs(os: string): void {
    this.configurator$
      .pipe(
        take(1)
      )
      .subscribe(data => {
      const conf: ProductConfiguratorData = { ...data };
      conf.os = os;
      this.configuratorSub$.next(conf);
      this.form.controls['os'].setValue(os);
    })
  }

  setCpu(cpu: string): void {
    this.configurator$
      .pipe(
        take(1)
      )
      .subscribe(data => {
        const conf: ProductConfiguratorData = { ...data };
        conf.cpu = cpu;
        this.configuratorSub$.next(conf);
        this.form.controls['cpu'].setValue(cpu);
      })
  }

  setRam(ram: number): void {
    this.configurator$
      .pipe(
        take(1)
      )
      .subscribe(data => {
        const conf: ProductConfiguratorData = { ...data };
        conf.ram = ram;
        this.configuratorSub$.next(conf);
        this.form.controls['ram'].setValue(ram);
      })
  }

  setSsd(ssd: number): void {
    this.configurator$
      .pipe(
        take(1)
      )
      .subscribe(data => {
        const conf: ProductConfiguratorData = { ...data };
        conf.ssd = ssd;
        this.configuratorSub$.next(conf);
        this.form.controls['ssd'].setValue(ssd);
      })
  }

  setColor(color: string): void {
    this.configurator$
      .pipe(
        take(1)
      )
      .subscribe(data => {
        const conf: ProductConfiguratorData = { ...data };
        conf.color = color;
        this.configuratorSub$.next(conf);
        this.form.controls['color'].setValue(color);
      })
  }

  setCamera(camera: string): void {
    this.configurator$
      .pipe(
        take(1)
      )
      .subscribe(data => {
        const conf: ProductConfiguratorData = { ...data };
        conf.camera = camera;
        this.configuratorSub$.next(conf);
        this.form.controls['camera'].setValue(camera);
      })
  }

  setDisplayResolution(displayResolution: string): void {
    this.configurator$
      .pipe(
        take(1)
      )
      .subscribe(data => {
        const conf: ProductConfiguratorData = { ...data };
        conf.displayResolution = displayResolution;
        this.configuratorSub$.next(conf);
        this.form.controls['displayResolution'].setValue(displayResolution);
      })
  }

  setDisplaySize(displaySize: string): void {
    this.configurator$
      .pipe(
        take(1)
      )
      .subscribe(data => {
        const conf: ProductConfiguratorData = { ...data };
        conf.displaySize = displaySize;
        this.configuratorSub$.next(conf);
        this.form.controls['displaySize'].setValue(displaySize);
      })
  }

  setDisplayType(displayType: string): void {
    this.configurator$
      .pipe(
        take(1)
      )
      .subscribe(data => {
        const conf: ProductConfiguratorData = { ...data };
        conf.displayType = displayType;
        this.configuratorSub$.next(conf);
        this.form.controls['displayType'].setValue(displayType);
      })
  }

  ngOnDestroy(): void {
    this.configuratorSub$.complete();
    this.enableBuyStatusSub$.complete();
  }
}
