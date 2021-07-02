package edu.depaul.email;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/*
*to test,  you need to call addLocation() to set up where the test will write to, then call storeList()
* and check that the file specified in addLocation() was actually written to.
* you can create errors by passing bad paths to addLocation. storeList() should then produce
* the expected exception
 */

// Moch storageService Tests


public class storageServiceTest {


    @Test
    @DisplayName("testing the constructor to make sure it is not created null")
    void notNull(){
        StorageService storage = new StorageService();
        assertNotNull(storage);

    }
    @Test
    @DisplayName("Tests with mock & max emails")
    void testPageCrawlerMockMax() {
        StorageService storage = mock(StorageService.class);
        PageCrawler crawler = new PageCrawler(storage, 150);
        assertNotNull(crawler);
    }

    @Test
    @DisplayName("Tests with mock & min emails")
    void testPageCrawlerMockMin() {
        StorageService storage = mock(StorageService.class);
        PageCrawler crawler = new PageCrawler(storage, 0);
        assertNotNull(crawler);
    }

@Test
    @DisplayName("passing bad paths to addLocation")
    void badpathtest(){
        StorageService storage = new StorageService();
        Collection<String> collection= new ArrayList<String>();
        assertThrows(EmailFinderException.class,() -> storage.storeList(StorageService.StorageType.BADLINKS, collection));
}

    @Test
    @DisplayName("Tests PageCrawler getEmails()")
    void testPageCrawlerGet()
    {
        String url = "/Users/miguelh/Documents/GitHub/Email Finder Software Test/email.txt";
        StorageService storage = mock(StorageService.class);
        PageCrawler crawler = new PageCrawler(storage, 5);
        crawler.crawl(url);
        Collection<String> crawled = crawler.getEmails();
        for (String i : crawled)
        {
            assertTrue(i.contains("@"));
        }
    }

    @Test
    @DisplayName("Tests StorageService Constructor")
    void testStorageMockConstruction(){
        StorageService storage = new StorageService();
        assertTrue(storage instanceof StorageService);
    }
    @Test
    @DisplayName("Tests exception with GOODLINKS")
    void testGoodLinksMock(){
        StorageService storage = new StorageService();
        Collection<String> res = new ArrayList<String>();
        assertThrows(EmailFinderException.class, () -> storage.storeList(StorageService.StorageType.GOODLINKS, res));
    }

}
