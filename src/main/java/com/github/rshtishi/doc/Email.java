package com.github.rshtishi.doc;

public class Email {

    private String to;
    private String subject;
    private String body;

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public Email(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public void setFormat(Format format) {
    }
}
