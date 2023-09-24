package com.github.rshtishi;

import com.github.rshtishi.doc.DeliveryPlatform;
import com.github.rshtishi.doc.Email;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MailServiceTest {

    @Mock
    DeliveryPlatform platform;

    @InjectMocks
    MailService emailService;

    @Captor
    ArgumentCaptor<Email> emailCaptor;

    @Test
    public void testSendMailSuccessfully(){
        //execute
        emailService.send("x@email.com","Hi","Wish you the best",false);
        //verify
        verify(platform).deliver(emailCaptor.capture());
        Email emailCaptorValue = emailCaptor.getValue();
        assertEquals("x@email.com",emailCaptorValue.getTo());
        assertEquals("Hi", emailCaptorValue.getSubject());
        assertEquals("Wish you the best", emailCaptorValue.getBody());
    }

}