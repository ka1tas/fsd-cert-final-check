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


export class SignupService {
  saveuser: string = "/viewnews/signup/add";
  getlang: string = "/viewnews/signup/languages";
  getrole: string = "/viewnews/signup/roles";
  
 
  constructor( private http: HttpClient) { }
  
  addUser (json): Observable<any> {
    return this.http.post<any>(this.saveuser, json, httpOptions);
  }

  getLanguages (): Observable<any> {
    return this.http.get<any>(this.getlang );
  }

  getRoles (): Observable<any> {
    return this.http.get<any>(this.getrole);
  }

}
