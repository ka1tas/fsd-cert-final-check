import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {
  articles:any;

  constructor() { }

  ngOnInit() {

    const NewsAPI = require('newsapi');
    const newsapi = new NewsAPI('71f791c2b2044004b9e096eb3ef76478');
    // To query /v2/top-headlines
    // All options passed to topHeadlines are optional, but you need to include at least one of them
    /* newsapi.v2.topHeadlines({
    
      category: 'business',
      language: 'en',
      country: 'us'
    }).then(response => {
      console.log(response);
      /*
        {
          status: "ok",
          articles: [...]
        }
      
    });
    
     */
    
    newsapi.v2.everything({
    
      sources: 'bbc-news,the-verge',
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

}
