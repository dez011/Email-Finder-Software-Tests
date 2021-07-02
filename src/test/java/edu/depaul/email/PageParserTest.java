package edu.depaul.email;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PageParserTest {
    /*
     *easy way to test, create documents in the constructor that takes a string and verity
     * that the parser handles the documents correctly.  String you should consider using:
     * 1. html with no <a> tags
     * 2. html with 1<a> tag
     * 3. html with several <a> tags
     * 4. relative tags
     * 5. absolute tags
     */

    @Test
    @DisplayName("testing constructor with no <a> tags")
    void testNoTag() {
        String a = "<html><body></body></html";
        Document d = Jsoup.parse(a);
        PageParser p = new PageParser();
        Set<String> email = p.findEmails(d);
        assertEquals(0, email.size());
    }



    @Test
    @Disabled
    @DisplayName("test absolute tags")
    void absTest(){
        //String a = "https://www.w3schools.com/images/picture.jpg";
        //String a = "file:///Users/miguelh/Documents/GitHub/email-finder/src/test/resources/testOne.html";
        String a = "<html><body><a href=\"file:///Users/miguelh/Documents/GitHub/email-finder/src/test/resources/testOne.html\">absolute</a>\n</body></html>";
        Document d = Jsoup.parse(a);
        PageParser p = new PageParser();
        Set<String> email = p.findEmails(d);
        assertEquals(1,email.size());


    }

    @ParameterizedTest
    @MethodSource("emailList")
    @DisplayName("passing multiple emails to test")
    void testMultEmails(int expected, String html){
        Document d = Jsoup.parse(html);
        PageParser p = new PageParser();
        Set<String> emails = p.findEmails(d);
        assertEquals(expected, emails.size());
    }

    private static Stream<Arguments> emailList(){
        String arg0 = "<html><body></body></html>";
        String arg1 = "<html><body>email1@depaul.com</body></html>";
        String arg2 = "<html><body>email1@depaul.com,email2@depaul.edu</body></html>";
        String arg3 = "<html><body>email1@depaul.com,email2@depaul.edu,email3@depaul.edu</body></html>";
        String arg4 = "<html><body><a href =\"C:\\Users\\Miguel\\Documents\\GitHub\\email-finder\\src\\test\\resources\\testOne.html\">testOne</a>\n</body></html>";
        return Stream.of(

                Arguments.of(3,arg3),
                Arguments.of(0,arg0),
                Arguments.of(1,arg1),
                Arguments.of(2,arg2)
        );
    }

}
