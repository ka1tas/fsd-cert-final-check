import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  constructor(private http: HttpClient, private router: Router, private loginService: LoginService,
 ) { }

  ngOnInit() {

  }

  loginform = new FormGroup({
    userName: new FormControl(
      '',
      [Validators.required,
      Validators.minLength(3),
      Validators.maxLength(10)
      ]),
    password: new FormControl(
      '',
      [Validators.required,
      Validators.minLength(4),
      Validators.maxLength(15)]),
  });



  

}
