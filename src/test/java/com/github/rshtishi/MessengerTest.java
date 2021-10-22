package com.github.rshtishi;

import com.github.rshtishi.doc.Client;
import com.github.rshtishi.doc.MailServer;
import com.github.rshtishi.doc.Template;
import com.github.rshtishi.doc.TemplateEngine;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/*
We need to:
- fully control the context of the working of the SUT
- eavesdrop on communication between the SUT and DOCs

Test Doubles types:
- dummy object(used only as an input parameter to another method)
- stub(takes care of the indirect inputs of a class)
- test spy(also take in indirect outputs)
 */
public class MessengerTest {

    private static final String CLIENT_EMAIL = "rando@email.com";
    private static final String MSG_CONTENT = "Dear Rando! You are promoted.";

    //verify that the send() method of mailServer was
    //invoked with given email and message content
    @Test
    public void shouldSendEmail() {
        Template template = mock(Template.class); //dummy
        Client client = mock(Client.class); //stub
        MailServer mailServer = mock(MailServer.class); //test spy
        TemplateEngine templateEngine = mock(TemplateEngine.class); // stub
        Messenger sut = new Messenger(mailServer, templateEngine);
        when(client.getEmail()).thenReturn(CLIENT_EMAIL);
        when(templateEngine.prepareMessage(client, template)).thenReturn(MSG_CONTENT);
        sut.sendMessage(client, template);
        verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);
    }


}