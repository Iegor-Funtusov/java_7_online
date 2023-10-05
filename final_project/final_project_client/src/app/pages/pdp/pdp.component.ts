import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-pdp',
  standalone: true,
  templateUrl: './pdp.component.html',
  styleUrls: ['./pdp.component.scss']
})
export class PdpComponent implements OnInit {

  constructor(private router: Router) {
  }

  ngOnInit(): void {
    let url = this.router.routerState.snapshot.url;
    let id = url.split('/')[2];
  }
}
