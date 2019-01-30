import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    
  })
};

@Injectable({
  providedIn: 'root'
})
export class LoginService {


  loginurl: string = "viewnews/login/check";
  
 
  constructor( private http: HttpClient) { }
  
  login (json): Observable<any> {
    return this.http.post<any>(this.loginurl, json, httpOptions);
  }

}
