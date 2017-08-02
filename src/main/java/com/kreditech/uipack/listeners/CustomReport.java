package com.kreditech.uipack.listeners;

import com.codeborne.selenide.logevents.EventsCollector;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.logevents.SimpleReport;
import com.google.common.base.Joiner;
import io.qameta.allure.Attachment;


import java.util.Collections;
import java.util.OptionalInt;
import java.util.logging.Logger;

/**
 * Created by pc on 31.07.2017.
 */
public class CustomReport extends SimpleReport {

    private static final Logger log = Logger.getLogger(SimpleReport.class.getName());

    public void start() {
        SelenideLogger.addListener("simpleReport", new EventsCollector());
    }

    public void finish(String title) {
        EventsCollector logEventListener = SelenideLogger.removeListener("simpleReport");

        OptionalInt maxLineLength = logEventListener.events()
                .stream()
                .map(LogEvent::getElement)
                .map(String::length)
                .mapToInt(Integer::intValue)
                .max();

        int count = maxLineLength.orElse(0) >= 20 ? (maxLineLength.getAsInt() + 1) : 20;

        StringBuilder sb = new StringBuilder();
        sb.append("Report for ").append(title).append('\n');

        String delimiter = '+' + Joiner.on('+').join(line(count), line(60), line(10), line(10)) + "+\n";

        sb.append(delimiter);
        sb.append(String.format("|%-" + count + "s|%-60s|%-10s|%-10s|%n", "Element", "Subject", "Status", "ms."));
        sb.append(delimiter);

        for (LogEvent e : logEventListener.events()) {
            sb.append(String.format("|%-" + count + "s|%-60s|%-10s|%-10s|%n", e.getElement(), e.getSubject(),
                    e.getStatus(), e.getDuration()));
        }
        sb.append(delimiter);
        log.info(sb.toString());
        attachText(sb.toString());
    }

    private String line(int count) {
        return Joiner.on("").join(Collections.nCopies(count, "-"));
    }

    @Attachment(value = "Test log")
    public String attachText(String text){
        return text;
    }
}
