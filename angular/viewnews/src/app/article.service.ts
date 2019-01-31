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
export class ArticleService {

  articlesaveurl: string = "viewnews/art/addfav";
  
 
  constructor( private http: HttpClient) { }
  
  addArticle (json): Observable<any> {
    return this.http.post<any>(this.articlesaveurl, json, httpOptions);
  }

}
