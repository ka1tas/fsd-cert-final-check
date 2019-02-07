import { LoginPage } from './login.po';
import { protractor, browser } from 'protractor';
import { NewsPage } from '../news/news.po';
describe('Login page', () => {
    let page: LoginPage;
    // tslint:disable-next-line:label-position
     let news = new NewsPage();
    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new LoginPage();
        page.navigateToLoginPage();
    });


    it('successful login', () => {
        page.sendEmailForLogin().sendKeys('s@g.com');
        page.sendPasswordForLogin().sendKeys('12345');
        page.getLoginButton().click();
        browser.wait(EC.visibilityOf(news.getTitle()));
        expect(news.getTitle().isPresent()).toBeTruthy();
        expect(browser.driver.getCurrentUrl()).toContain('/news');
    });

    it('failed login', () => {
        page.sendEmailForLogin().sendKeys('email@gmail.com');
        page.sendPasswordForLogin().sendKeys('A123456');
        page.getLoginButton().click();
        browser.wait(EC.visibilityOf(page.getErrorMessage()));
        expect(page.getErrorMessage().getText()).toBe('Email or Password did not matched!');
    });


    


});



// https://trailheadtechnology.com/ui-automation-testing-of-angular-apps-using-protractor-jasmine/
// https://scotch.io/@charlieoduk/angular-end-to-end-testing507


// --- Karma

// https://scotch.io/tutorials/testing-angular-with-jasmine-and-karma-part-1