package com.interpreter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class LoxTest {

    @Test
    @DisplayName("Placeholder test - should pass")
    public void testPlaceholder() {
        assertTrue(true, "This test should always pass");
    }

    @Test
    @DisplayName("Basic arithmetic test")
    public void testBasicArithmetic() {
        assertEquals(4, 2 + 2);
        assertEquals(10, 5 * 2);
        assertEquals(3, 9 / 3);
        assertEquals(1, 5 - 4);
    }

    @Test
    @DisplayName("String operations test")
    public void testStringOperations() {
        String hello = "Hello";
        String world = "World";
        assertEquals("HelloWorld", hello + world);
        assertEquals(5, hello.length());
    }
}