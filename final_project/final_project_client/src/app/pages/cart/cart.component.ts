import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { AuthService } from "../../services/auth.service";

@Component({
  selector: 'app-cart',
  standalone: true,
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService) {
  }

  ngOnInit(): void {
    let isLoggedIn = this.authService.isLoggedIn();
    console.log('isLoggedIn', isLoggedIn)
    if (!isLoggedIn) {
      this.router.navigateByUrl('login');
    }
  }
}
