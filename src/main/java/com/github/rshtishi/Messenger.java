package com.github.rshtishi;

import com.github.rshtishi.doc.Client;
import com.github.rshtishi.doc.MailServer;
import com.github.rshtishi.doc.Template;
import com.github.rshtishi.doc.TemplateEngine;

/*
The Messenger class takes care of transforming and
passing messages rather than doing any real work.
*/
public class Messenger {

    //mailServer, a collaborator of our class, is expected to perform the real work
    private final MailServer mailServer;
    private final TemplateEngine templateEngine;

    //All collaborators injected using constructor.
    public Messenger(MailServer mailServer, TemplateEngine templateEngine) {
        this.mailServer = mailServer;
        this.templateEngine = templateEngine;
    }

    /*
        This method returns void, and does not change the state of the Messenger object, which means
        there is no way we can test it using the state-testing approach.
     */
    public void sendMessage(Client client, Template template) {
        String msgContent = templateEngine.prepareMessage(client, template);
        mailServer.send(client.getEmail(), msgContent);
    }
}
