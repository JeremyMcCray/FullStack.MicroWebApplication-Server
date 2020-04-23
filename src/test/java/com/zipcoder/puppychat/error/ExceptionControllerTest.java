package com.zipcoder.puppychat.error;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.*;

public class ExceptionControllerTest {

    ExceptionController ex = new ExceptionController();

    @Test
    public void handleNotFoundTest() {
        Assert.assertEquals( HttpStatus.NOT_FOUND,ex.handleNotFound().getStatusCode());
    }

    @Test
    public void handleDupeTest() {
        Assert.assertEquals( HttpStatus.CONFLICT,ex.handleDupe().getStatusCode());
    }

    @Test
    public void handleBadAuthTest() {Assert.assertEquals(HttpStatus.UNAUTHORIZED,ex.handleBadAuth().getStatusCode());}
}
