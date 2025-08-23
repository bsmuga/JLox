package com.interpreter.lox;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.interpreter.lox.TokenType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScannerTest {

    @Test
    @DisplayName("Test scanning of single-character tokens")
    void testScanSingleCharacterTokens() {
        String source = "(){},.-+*;";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        assertEquals(11, tokens.size());
        assertEquals(LEFT_PAREN, tokens.get(0).getType());
        assertEquals(RIGHT_PAREN, tokens.get(1).getType());
        assertEquals(LEFT_BRACE, tokens.get(2).getType());
        assertEquals(RIGHT_BRACE, tokens.get(3).getType());
        assertEquals(COMMA, tokens.get(4).getType());
        assertEquals(DOT, tokens.get(5).getType());
        assertEquals(MINUS, tokens.get(6).getType());
        assertEquals(PLUS, tokens.get(7).getType());
        assertEquals(STAR, tokens.get(8).getType());
        assertEquals(SEMICOLON, tokens.get(9).getType());
        assertEquals(EOF, tokens.get(10).getType());
    }

    @Test
    @DisplayName("Test scanning of one or two character tokens")
    void testScanOneOrTwoCharacterTokens() {
        String source = "! != = == < <= > >=";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        assertEquals(9, tokens.size());
        assertEquals(BANG, tokens.get(0).getType());
        assertEquals(BANG_EQUAL, tokens.get(1).getType());
        assertEquals(EQUAL, tokens.get(2).getType());
        assertEquals(EQUAL_EQUAL, tokens.get(3).getType());
        assertEquals(LESS, tokens.get(4).getType());
        assertEquals(LESS_EQUAL, tokens.get(5).getType());
        assertEquals(GREATER, tokens.get(6).getType());
        assertEquals(GREATER_EQUAL, tokens.get(7).getType());
        assertEquals(EOF, tokens.get(8).getType());
    }

    @Test
    @DisplayName("Test scanning of string literals")
    void testScanStringLiteral() {
        String source = "\"hello world\"";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        assertEquals(2, tokens.size());
        assertEquals(STRING, tokens.get(0).getType());
        assertEquals("hello world", tokens.get(0).getLiteral());
        assertEquals(EOF, tokens.get(1).getType());
    }

    @Test
    @DisplayName("Test scanning of number literals")
    void testScanNumberLiteral() {
        String source = "123 45.67";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        assertEquals(3, tokens.size());
        assertEquals(NUMBER, tokens.get(0).getType());
        assertEquals(123.0, tokens.get(0).getLiteral());
        assertEquals(NUMBER, tokens.get(1).getType());
        assertEquals(45.67, tokens.get(1).getLiteral());
        assertEquals(EOF, tokens.get(2).getType());
    }

    @Test
    @DisplayName("Test scanning of identifiers and keywords")
    void testScanIdentifiersAndKeywords() {
        String source = "var myVar = 10; if (myVar > 5) { print myVar; }";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        assertEquals(17, tokens.size());
        assertEquals(VAR, tokens.get(0).getType());
        assertEquals(IDENTIFIER, tokens.get(1).getType());
        assertEquals(EQUAL, tokens.get(2).getType());
        assertEquals(NUMBER, tokens.get(3).getType());
        assertEquals(SEMICOLON, tokens.get(4).getType());
        assertEquals(IF, tokens.get(5).getType());
        assertEquals(LEFT_PAREN, tokens.get(6).getType());
        assertEquals(IDENTIFIER, tokens.get(7).getType());
        assertEquals(GREATER, tokens.get(8).getType());
        assertEquals(NUMBER, tokens.get(9).getType());
        assertEquals(RIGHT_PAREN, tokens.get(10).getType());
        assertEquals(LEFT_BRACE, tokens.get(11).getType());
        assertEquals(PRINT, tokens.get(12).getType());
        assertEquals(IDENTIFIER, tokens.get(13).getType());
        assertEquals(SEMICOLON, tokens.get(14).getType());
        assertEquals(RIGHT_BRACE, tokens.get(15).getType());
        assertEquals(EOF, tokens.get(16).getType());
    }

    @Test
    @DisplayName("Test scanning with comments")
    void testScanWithComments() {
        String source = "// this is a comment\nvar x = 1; // another comment";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        assertEquals(6, tokens.size());
        assertEquals(VAR, tokens.get(0).getType());
        assertEquals(IDENTIFIER, tokens.get(1).getType());
        assertEquals(EQUAL, tokens.get(2).getType());
        assertEquals(NUMBER, tokens.get(3).getType());
        assertEquals(SEMICOLON, tokens.get(4).getType());
        assertEquals(EOF, tokens.get(5).getType());
    }
}