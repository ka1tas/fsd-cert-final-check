import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { ArticleService } from '../article.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {
  articles:any;
  lang:String="en";
  userId:any;
  constructor( public authServce: AuthService, public artService:ArticleService) { }

  ngOnInit() {

    if(this.authServce.loggedIn){
      this.lang= this.authServce.getLanguage();
    }

    this.userId = this.authServce.getUserId();

    console.log("User Id "+this.userId);

    console.log(" language "+this.lang);
    const NewsAPI = require('newsapi');
    const newsapi = new NewsAPI('71f791c2b2044004b9e096eb3ef76478');
    // To query /v2/top-headlines
    // All options passed to topHeadlines are optional, but you need to include at least one of them
    /*  newsapi.v2.topHeadlines({
    
     // category: 'business',
      language: 'this.lang',
      country: 'us'
    }).then(response => {
      console.log(response);
      this.articles= response.articles;
      /*
        {
          status: "ok",
          articles: [...]
        }
      
      
    });
     */
     
   
    newsapi.v2.everything({
    
      sources: 'bbc-news,the-verge,the-times-of-india',
      domains: 'bbc.co.uk, techcrunch.com',
      from: '2019-01-01',
      to: '2019-01-28',
      language: 'en',
      sortBy: 'relevancy',
      page: 2
    }).then(response => {
      console.log(response);
      this.articles= response.articles;
      /*
        {
          status: "ok",
          articles: [...]
        }
      */
    });

  
    
  }


addfav(article:any){
 // console.log(article);

 console.log("user id" +this.userId);
  let json = JSON.stringify({
    article:article,
    user:{
      id: this.userId
    }

  })
  console.log(json);
  this.artService.addArticle(json).subscribe(data=>{

    console.log(data);
      
  },
  error=>{
    console.log(error.status);
      
  }
  
  )
  

}



}
