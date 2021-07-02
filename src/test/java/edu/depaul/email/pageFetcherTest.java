package edu.depaul.email;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/*
*1. get returns a document when the url is good
* same for getstring
* try to force some exceptions to verify you get the expected types
 */
public class pageFetcherTest {

    @Test
    @Disabled
    @DisplayName("Checks for invalid exception")
    void testException(){
        PageFetcher fetch = new PageFetcher();
        String url = "http//www.qwertyytrewq.com";
        assertThrows(IllegalArgumentException.class,() -> fetch.get(url));
    }
    @Test
    @DisplayName("Checks for email exception with invalid url")
    void testInvEmail(){
        PageFetcher fetch = new PageFetcher();
        String url = "http//www.qwertyytrewq.com";
        assertThrows(EmailFinderException.class,() -> fetch.get(url));
    }
}
