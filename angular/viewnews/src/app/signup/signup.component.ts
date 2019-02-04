import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { SignupService } from '../signup.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  emailPattern = "^[a-zA-Z0-9._%+-]+@[A-Za-z0-9.-]+\.[a-zA-Z]{2,4}$";
  alllanguages: any;
  allroles: any;
  error = false;
  status = {
    signupStatus: false,
    emailExist: false
  };

  constructor(public service: SignupService) { }

  ngOnInit() {

    this.service.getLanguages().subscribe(data => {
      this.alllanguages = data;
    })

    this.service.getRoles().subscribe(data => {
      this.allroles = data;
    })

  }
  json: any;

  signupform = new FormGroup({
    name: new FormControl(
      '',
      [Validators.required,
      Validators.minLength(1),
      Validators.maxLength(50)
      ]),
    email: new FormControl(
      '',
      [Validators.required,
      Validators.minLength(5),
      Validators.maxLength(250),
      Validators.pattern(this.emailPattern)
      ]),


    password: new FormControl(
      '',
      [Validators.required,
      Validators.minLength(5),
      Validators.maxLength(25)]),

    role: new FormControl(''
      , [Validators.required]),

    language: new FormControl('',
      [Validators.required])

  });

  signup() {

    console.log("role id" + this.signupform.controls['role'].value);

    this.json = JSON.stringify({
      name: this.signupform.controls['name'].value,
      email: this.signupform.controls['email'].value,
      password: this.signupform.controls['password'].value,
      /* role: {
        id: this.signupform.controls['role'].value,
      }, */
      language: {
        id: this.signupform.controls['language'].value,
      },
      blocked: "no"
    });

    console.log(this.json);

    this.service.addUser(this.json).subscribe(data => {
      console.log(data);
      this.status = data;
      this.error = false;
      console.log(this.status);
      if (this.status.signupStatus == true) {
        this.signupform.reset();
      }
    },
      error => {
        this.error = true;
      });


  }




}
