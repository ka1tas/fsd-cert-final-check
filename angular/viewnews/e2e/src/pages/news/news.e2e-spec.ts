
import { protractor, browser } from 'protractor';
import { NewsPage } from './news.po';
describe('News page', () => {
    let page: NewsPage;
    // tslint:disable-next-line:label-position
    // let news = new NewsPage();
    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new NewsPage();
        page.navigateToNewsPage();
    });


    it('successfuly searching  NewsArticle', () => {
        page.sendTopicForNews().sendKeys('india');
        page.getSearchButton().click();
        browser.wait(EC.visibilityOf(page.getTitle()));
        expect(page.getTitle().getText()).toBe('Top News');    
    });

 
});


