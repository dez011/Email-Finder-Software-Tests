/*
 * Assignment: class project
 * Topic: demonstrate a variety of tests
 * Author: Dan Walker
 */
package edu.depaul.email;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *Create your own test pages and pass in a file path instead of a URL.  to verify:
 * 1. output files were created
 * 2. Contents of output files are as expected
 */
public class EmailFinderTests {
    @Test
    @DisplayName("Checking if good-links.txt exists.")
    void TestFileGoodLinksExists(){
        String[] str = new String[] {"https://www.google.com/"};
        EmailFinder.main(str);
        File file = new File("/Users/miguelh/Documents/GitHub/Email Finder Software Test/good-links.txt");
        assertTrue(file.exists());
    }
    @Test
    @DisplayName("Checking good-links.txt if it displays the URL.")
    void TestGoodLinksUrlDisplay() throws IOException {
        String[] str = new String[] {"https://www.google.com/"};
        EmailFinder.main(str);
        String goodLink = "https://safebrowsing.google.com/?utm_source=pp&hl=en";
        String firstLine = Files.readAllLines(Paths.get("good-links.txt")).get(0);
        assertTrue(goodLink.equals(firstLine));
    }


    @Test
    @DisplayName("Checking if email.txt is created")
    void TestFileEmailLinksExists() {
        String[] str = new String[]{"https://www.google.com/"};
        EmailFinder.main(str);
        File file = new File("/Users/miguelh/Documents/GitHub/Email Finder Software Test/email.txt");
        assertTrue(file.exists());
    }
    @Test
    @DisplayName("Checking email.txt to see if it displays the URL used.")
    void TestEmailLinksUrlDisplay() throws IOException {
        String[] str = new String[] {"https://www.google.com/"};
        EmailFinder.main(str);
        String email = "apps-help@google.com";
        String firstLine = Files.readAllLines(Paths.get("email.txt")).get(0);
        assertTrue(email.equals(firstLine));
    }


    @Test
    @DisplayName("Checking if badlinks.txt exists")
    void TestFileBadLinksExists(){
        String[] str = new String[]{"https://www.google.com/"};
        EmailFinder.main(str);
        File file = new File("/Users/miguelh/Documents/GitHub/Email Finder Software Test/badlinks.txt");
        assertTrue(file.exists());
    }
    @Test
    @DisplayName("Checking if badlinks.txt displays the URL.")
    void TestBadLinksUrlDisplay() throws IOException {
        String[] str = new String[] {"https://www.google.com/terms?hl=en#toc-what-you-expect"};
        EmailFinder.main(str);
        String badLink = "https://www.google.com/terms?hl=en#toc-what-you-expect";
            String firstLine = Files.readAllLines(Paths.get("badlinks.txt")).get(0);
            assertTrue(badLink.equals(firstLine));
    }



}
