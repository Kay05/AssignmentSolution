package com.kuda.test.common.rest;

import com.kuda.common.rest.impl.RestServiceImpl;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class RestServiceImplTest {
    //requires token
    @Test(expected = RuntimeException.class)
    public void testGet() throws Exception {
        //RestServiceImpl rest = new RestServiceImpl("Tskhceccccncjkwed");
        //rest.get("");
        assertEquals(RuntimeException.class, new RestServiceImpl("Tskhceccccncjkwed").get(""));
    }
}