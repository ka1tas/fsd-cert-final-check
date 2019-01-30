import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { NewsComponent } from './news/news.component';
import { FindanalystComponent } from './findanalyst/findanalyst.component';
import { FavouriteComponent } from './favourite/favourite.component';

const routes: Routes = [
{path:"", component:LoginComponent},
{path:"login", component:LoginComponent},
{path:"signup", component:SignupComponent},
{path:"news", component:NewsComponent},
{path:"findanalyst", component:FindanalystComponent},
{path:"favourite", component:FavouriteComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
