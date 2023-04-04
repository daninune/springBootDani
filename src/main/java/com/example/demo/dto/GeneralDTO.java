package com.example.demo.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public abstract class GeneralDTO implements Serializable {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat
            = new SimpleDateFormat("HH:mm");
    private static final String defaultTimezone = "GMT+2";
    private String date;


    public Date getSubmissionDateConverted(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(this.date);
    }

    public Date getSubmissionTimeConverted(String timezone) throws ParseException {
        timeFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return timeFormat.parse(this.date);
    }

    public void setSubmissionDate(Date date, String timezone) {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        this.date = dateFormat.format(date);
    }

    public void setSubmissionTime(Date date, String timezone) {
        timeFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        this.date = timeFormat.format(date);
    }


    public Date dateConversion(String dateString) {
        timeFormat.setTimeZone(TimeZone.getTimeZone(defaultTimezone));
        try {
            return timeFormat.parse(dateString);
        } catch (ParseException e) {
            var d = new Date();
            d.setHours(0);
            d.setMinutes(0);
            d.setSeconds(0);
            return d;
        }
    }
}
