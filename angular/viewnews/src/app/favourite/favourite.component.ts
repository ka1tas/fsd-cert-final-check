import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { ArticleService } from '../article.service';

@Component({
  selector: 'app-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.css']
})
export class FavouriteComponent implements OnInit {
  userId:any;
  articles:any;
  constructor(public authServce: AuthService, public artService:ArticleService) { }

  ngOnInit() {
    this.userId = this.authServce.getUserId();

    this.artService.showFavs(this.userId).subscribe(data=>{
      this.articles= data;
      console.log(data); 
        console.log("inside the whole");
    },
    error=>{

    }); 

  }


  removefav(article:any){
    console.log("Article to delete:")
    console.log(article);
    this.artService.deletefav(article.id).subscribe(data=>{
      this.articles= data;
      console.log(data);
        console.log("inside the delete");
        if(data){
          alert("Deleted!")
        }
        this.ngOnInit();
    },
    error=>{

    }); 

  }

}
