import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  emailPattern = "^[a-zA-Z0-9._%+-]+@[A-Za-z0-9.-]+\.[a-zA-Z]{2,4}$";
  json: any;
  error = false;
  userBlocked=false;
  status = {
    authStatus: true,
    isblocked:false
  };

  constructor(private http: HttpClient, private router: Router, private loginService: LoginService, public authService: AuthService
  ) { }

  ngOnInit() {

  }

  loginform = new FormGroup({
    email: new FormControl(
      '',
      [Validators.required,
      Validators.minLength(5),
      Validators.pattern(this.emailPattern)
      ]),
    password: new FormControl(
      '',
      [Validators.required,
      Validators.minLength(4),
      Validators.maxLength(40)]),
  });


  login() {

    this.json = this.loginform.value;
    console.log(this.json);

    this.loginService.login(this.json).subscribe(data => {
      console.log(data);
      this.status = data;
      console.log("blocked:"+this.status.isblocked);
      this.error = false;

      if (this.status.authStatus == true && this.status.isblocked == false) {
        this.authService.login(data);
        this.authService.setRole(data.user.role.name);
        this.authService.setLanguage(data.user.language.name);
        this.authService.setUserId(data.user.id);
        this.router.navigate(['/news']);
      }

    },
      error => {
        this.error = true;
       
      }

    )

  }


}
