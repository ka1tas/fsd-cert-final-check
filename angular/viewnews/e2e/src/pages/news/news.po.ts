import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class NewsPage {

    navigateToNewsPage() {
        return browser.get('/news');
    }

    getTitle() {
        return element(by.id('titlee'));
    }
 
    sendTopicForNews() {
        return element(by.id('newsTopic'));
    }


    getSearchButton() {
        return element(by.id('searchbutton'));
    }
 
}
