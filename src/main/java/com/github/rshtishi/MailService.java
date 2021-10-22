package com.github.rshtishi;

import com.github.rshtishi.doc.DeliveryPlatform;
import com.github.rshtishi.doc.Email;
import com.github.rshtishi.doc.Format;

public class MailService {

    private DeliveryPlatform platform;

    public MailService(DeliveryPlatform platform) {
        this.platform = platform;
    }

    public void send(String to, String subject, String body, boolean html) {
        Format format = Format.TEXT_ONLY;
        if (html) {
            format = Format.HTML;
        }
        Email email = new Email(to, subject, body);
        email.setFormat(format);
        platform.deliver(email);
    }

}
