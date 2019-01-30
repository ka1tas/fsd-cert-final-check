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

  alllanguages:any;
  allroles:any;
  error=false;
  status={
    signupStatus:false,
    emailExist:false
  };

  constructor(public service: SignupService) {  }

  ngOnInit() {

    this.service.getLanguages().subscribe(data=>{
      this.alllanguages=data;
    })

     this.service.getRoles().subscribe(data=>{
      this.allroles=data;
    })

  }
json:any;

  signupform = new FormGroup({
    name: new FormControl(
      '',
      [Validators.required,
      Validators.minLength(3),
      Validators.maxLength(10)
      ]),
    email: new FormControl(
      '',
      [Validators.required,
      Validators.minLength(4),
      Validators.maxLength(15)]),

    password: new FormControl(
      '',
      [Validators.required,
      Validators.minLength(4),
      Validators.maxLength(15)]),

    role: new FormControl(''),
    language: new FormControl('')

  });

signup(){

console.log("role id"+ this.signupform.controls['role'].value);

this.json = JSON.stringify({
  name: this.signupform.controls['name'].value,
  email:this.signupform.controls['email'].value,
  password:this.signupform.controls['password'].value,
  role:{
    id: this.signupform.controls['role'].value,
  },
  language:{
    id: this.signupform.controls['language'].value,
  },
  blocked:"no"
});

this.service.addUser(this.json).subscribe(data=>{

  console.log(data);
 
  this.status=data;
      this.error=false;
      console.log(this.status);
      if(this.status.signupStatus==true){
        this.signupform.reset();
      }
    
},
error=>{
  this.error=true;
}

)


}
  



}
