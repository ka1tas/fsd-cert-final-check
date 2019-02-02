import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',

  })
};
@Injectable({
  providedIn: 'root'
})
export class ArticleService {


  articlesaveurl: string = "viewnews/art/addfav";
  showfavurl: string = "viewnews/art/showfav";
  deletefavurl: string = "viewnews/art/deletefav";
  showAnalysturl: string = "";

  constructor(private http: HttpClient) { }

  addArticle(json): Observable<any> {
    return this.http.post<any>(this.articlesaveurl, json, httpOptions);
  }

  showArticle(lang): Observable<any> {
    let viewarticle = "https://newsapi.org/v2/top-headlines?language=" + lang + "&apiKey=71f791c2b2044004b9e096eb3ef76478";
    return this.http.get<any>(viewarticle);
  }

  showFavs(userId): Observable<any> {
    return this.http.post<any>(this.showfavurl, userId, httpOptions);
  }

  deletefav(id): Observable<any> {
    return this.http.post<any>(this.deletefavurl, id, httpOptions);
  }


  showAnalyst(name):Observable<any> {
    return this.http.post<any>(this.showAnalysturl, name, httpOptions);
  }

}
