package com.ScheduleChuckNorris.ChuckScheduler;
import org.springframework.stereotype.Component;

@Component
public class Quote {

    private String value;

    public Quote() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "value='" + value + '\'' +
                '}';
    }
}
