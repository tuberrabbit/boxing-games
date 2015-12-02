package com.tuber.fight;

import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ReporterTest {
    @Test
    public void should_record_message_when_attack_is_over() {
        Reporter reporter = new Reporter();
        
        reporter.record("this is a message1");
        reporter.record("this is a message2");
        reporter.record("this is a message3");

        assertThat(reporter.getMessages().size(),is(3));
    }

    @Test
    public void should_print_message_when_reporter_has_messages() {
        PrintStream printer = mock(System.out.getClass());
        String message = "this is a message";
        Reporter reporter = new Reporter();
        reporter.record(message);
        reporter.record(message);
        reporter.record(message);

        reporter.reportBy(printer);

        verify(printer, times(3)).println(message);
    }
}
