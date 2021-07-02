package edu.depaul.email;
/*
*Constructed with an output stream
* can pass it an object of your choosing and then verify it contains the expected results after you call writeList
* Consider using a moc or just a handler OutputStream implementation such as a ByteArrayOutputStream
 */


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class listWriterTest {

    @Test
    @DisplayName("testing a list with writing")
    void testWriter() throws IOException {

        ArrayList<String> list = new ArrayList<String>();
        String first = "test one\n";
        String second = "test two\n";
        String third = "test three\n";
        String four = "test four";

        String combinatedStrings = first +"\n" + second +"\n" + third +"\n" + four+"\n";
        list.add(first);
        list.add(second);
        list.add(third);
        list.add(four);
        OutputStream stream = new ByteArrayOutputStream();
        ListWriter writer = new ListWriter(stream);
        writer.writeList(list);
        assertEquals(combinatedStrings, stream.toString());

    }





}
