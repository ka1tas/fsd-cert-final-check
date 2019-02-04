import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../article.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-findanalyst',
  templateUrl: './findanalyst.component.html',
  styleUrls: ['./findanalyst.component.css']
})
export class FindanalystComponent implements OnInit {
  list:any;
  showActive=false;
  userName:any;
  constructor(public artService : ArticleService, public authService:AuthService) { }

  ngOnInit() {

    console.log(this.authService.role)
    if(this.authService.role=="Admin"){
      this.showActive=true;
    }

    console.log(this.showActive);
  }


  searchUser(name:any){
    console.log(name);
    this.userName=name;
    this.artService.showAnalyst(name).subscribe(data=>{
      this.list= data;
      console.log(data);    
    },
    error=>{

    });

  }

  toggllingStatus(user){
    console.log(user);
    this.artService.changeStatus(user).subscribe(data=>{
      console.log(data);    
      if(data){
        this.searchUser(this.userName);
      }
    },
    error=>{

    });


  }

}
