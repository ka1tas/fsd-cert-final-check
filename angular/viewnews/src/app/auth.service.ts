import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loggedIn = false;
  role: string;
  userId: number;
  language:string;

  constructor() { }

 
  
  getUserId() {
    return this.userId;
  }

  setUserId(userId: any) {
    this.userId = userId;
  }

 

  login() {
    console.log("Inside auth service login()");
    this.loggedIn = true;
  }

  logout() {
    console.log("Inside auth service logout()");
    this.loggedIn = false;
  }

  getRole() {
    return this.role;
  }

  setRole(role: string) {
    this.role = role;
  }


  getLanguage() {
    return this.language;
  }

  setLanguage(language: string) {
    this.language = language;
  }
}
