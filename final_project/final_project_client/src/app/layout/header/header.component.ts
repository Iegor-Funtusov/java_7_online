import { Component } from '@angular/core';
import {SearchComponent} from "../../shared/components/search/search.component";

@Component({
  selector: 'app-header',
  standalone: true,
  templateUrl: './header.component.html',
  imports: [
    SearchComponent
  ],
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent { }
