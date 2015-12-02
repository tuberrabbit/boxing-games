package com.tuber.fight;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Reporter {
    private List<String> messages;

    public Reporter() {
        this.messages = new ArrayList<>();
    }

    public List<String> getMessages() {
        return messages;
    }

    public void record(String message) {
        messages.add(message);
    }

    public void reportBy(PrintStream printer) {
        for(String message : messages){
            printer.println(message);
        }
    }

    public Integer getMessagesSize() {
        return messages.size();
    }
}
