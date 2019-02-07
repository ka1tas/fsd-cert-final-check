import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponent } from './login.component';
import { DebugElement } from '@angular/core';
import { By, BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from '../signup/signup.component';
import { NewsComponent } from '../news/news.component';
import { FindanalystComponent } from '../findanalyst/findanalyst.component';
import { LoginService } from '../login.service';
import { FavouriteComponent } from '../favourite/favourite.component';

fdescribe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let de : DebugElement;
  let el : HTMLElement;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginComponent,FavouriteComponent, SignupComponent, NewsComponent, FindanalystComponent ],
      imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule
      ],
      providers : [ LoginService]
    })
    .compileComponents().then(() =>{
      fixture = TestBed.createComponent(LoginComponent);
      component = fixture.componentInstance;

      de = fixture.debugElement.query(By.css('form'));
      el = de.nativeElement;

    });
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('login form with valid inputs',async(()=> {
    //accessing controls
    component.loginform.controls['email'].setValue('saikat@gmail.com');
    component.loginform.controls['password'].setValue('12345');
    expect(component.loginform.valid).toBeTruthy();
  }));

  it('login form with empty inputs',async(()=> {
    //accessing controls
    component.loginform.controls['email'].setValue('');
    component.loginform.controls['password'].setValue('');
    expect(component.loginform.valid).toBeFalsy();
  }));

  it('should call the login method', async(()=> {
    fixture.detectChanges();
    spyOn(component, 'login');
    el =fixture.debugElement.query(By.css('button')).nativeElement;
    el.click();
    expect(component.login).toHaveBeenCalledTimes(1);
  })); 

});
