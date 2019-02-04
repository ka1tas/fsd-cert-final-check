 import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class SignUpPage {

    navigateToSignUpPage() {
        return browser.get('/signup');
    }

    getSignUpButton() {
        return element(by.id('signupbutton'));
    }

    sendNameForSignup() {
        return element(by.id('signupname'));
    }

    sendEmailForSignup() {
        return element(by.id('signupemail'));
    }

    sendPasswordForSignup() {
        return element(by.id('signuppassword'));
    }

  /*   sendRoleForSignup() {
        return element(by.id('signuprole'));
    } */

    sendLanguageForSignup() {
        return element(by.id('signuplanguage'));
    }
   

    getSuccessMessage() {
        return element(by.id('successmessege'));
    }

    getErrorMessage() {
        return element(by.id('errormessege'));
    }

} 