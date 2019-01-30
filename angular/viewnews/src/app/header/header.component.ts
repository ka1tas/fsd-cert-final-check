import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  role: any;
  loggedin: any;

  constructor(public authService: AuthService, public router: Router) { }

  ngOnInit() {

  }

  logout(){

    this.authService.logout();
    this.router.navigate(['/login']);

  }

}
