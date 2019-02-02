import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';

@Component({
  selector: 'app-findanalyst',
  templateUrl: './findanalyst.component.html',
  styleUrls: ['./findanalyst.component.css']
})
export class FindanalystComponent implements OnInit {
  list:any;


  constructor(public artService : ArticleService) { }

  ngOnInit() {
  }


  searchAnalyst(name:any){
    console.log(name);

    this.artService.showAnalyst(name).subscribe(data=>{
      this.list= data;
      console.log(data);
        console.log("inside the showana");
        
    },
    error=>{

    });

  }

}
