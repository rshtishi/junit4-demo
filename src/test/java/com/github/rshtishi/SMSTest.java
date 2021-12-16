package com.github.rshtishi;

import com.github.rshtishi.SMS;
import com.github.rshtishi.doc.Utils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Utils.class)
public class SMSTest {

    public static final String MSG = "Are you ok?";

    @Ignore
    @Test
    public void testFormatSMS(){
        SMS sms = new SMS();
        mockStatic(Utils.class);
        when(Utils.format(MSG)).thenReturn(MSG.toUpperCase());
        String result = sms.format(MSG);
        assertEquals(MSG.toUpperCase(),result);
    }

}