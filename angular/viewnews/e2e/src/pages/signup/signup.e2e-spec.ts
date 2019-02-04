import { SignUpPage } from './signup.po';
import { protractor, browser } from 'protractor';
import { NewsPage } from '../news/news.po';
describe('SignUp page', () => {
    let page: SignUpPage;
    // tslint:disable-next-line:label-position
    // let news = new NewsPage();
    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new SignUpPage();
        page.navigateToSignUpPage();
    });


    it('successful signup', () => {
        page.sendNameForSignup().sendKeys('Raj');
        page.sendEmailForSignup().sendKeys('raj@gam.com');
       // page.sendRoleForSignup().sendKeys('News Analyst');
        page.sendLanguageForSignup().sendKeys("fr");
        page.sendPasswordForSignup().sendKeys('123456');
      
        page.getSignUpButton().click();
        browser.wait(EC.visibilityOf(page.getSuccessMessage()));
        expect(page.getSuccessMessage().getText()).toBe('User added successfully!');
       
    });

    it('shoud fail SignUp for existing email', () => {
        page.sendNameForSignup().sendKeys('Raj');
        page.sendEmailForSignup().sendKeys('s@g.com');
       /*  page.sendRoleForSignup().sendKeys("Admin"); */
        page.sendLanguageForSignup().sendKeys("en");
        page.sendPasswordForSignup().sendKeys('123456');
        page.getSignUpButton().click();
        browser.wait(EC.visibilityOf(page.getErrorMessage()));
        expect(page.getErrorMessage().getText()).toBe('Email Already Exists!');
    }); 
});


