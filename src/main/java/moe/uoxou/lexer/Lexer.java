package moe.uoxou.lexer;

import moe.uoxou.Token;
import moe.uoxou.TokenType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer implements ILexer {
	private final String input;

	public Lexer(String input) {
		this.input = input;
	}

	private static final Pattern TOKEN_PATTERNS = Pattern.compile(
			"(?<numberKeyword>\\bnumber\\b|#⃣)"
					+ "|(?<stringKeyword>\\bstring\\b|\uD83D\uDD24)"
					+ "|(?<booleanKeyword>\\bboolean\\b|❗)"
					+ "|(?<identifier>[A-Za-z_][A-Za-z0-9_]*)"
					+ "|(?<number>[0-9]+)"
					+ "|(?<colonEquals>:=)"
					+ "|(?<plus>\\+)"
					+ "|(?<minus>[-−])"
					+ "|(?<multiply>[*×∙])"
					+ "|(?<divide>[/÷])"
					+ "|(?<modulo>%)"
					+ "|(?<lparen>\\()"
					+ "|(?<rparen>\\))"
					+ "|(?<semicolon>;)"
					+ "|(?<whitespace>[ \\t\\r\\n]+)"
					+ "|(?<unknown>.)"
	);

	public List<Token> lex() {
		List<Token> tokens = new ArrayList<>();
		Matcher matcher = TOKEN_PATTERNS.matcher(input);
		while (matcher.find()) {
			if (matcher.group("whitespace") != null) {
				continue;
			}

			if (matcher.group("identifier") != null) {
				tokens.add(new Token(TokenType.IDENTIFIER, matcher.group("identifier")));
			} else if (matcher.group("number") != null) {
				tokens.add(new Token(TokenType.NUMBER, matcher.group("number")));
			} else if (matcher.group("colonEquals") != null) {
				tokens.add(new Token(TokenType.COLON_EQUALS, matcher.group("colonEquals")));
			} else if (matcher.group("plus") != null) {
				tokens.add(new Token(TokenType.PLUS, matcher.group("plus")));
			} else if (matcher.group("minus") != null) {
				tokens.add(new Token(TokenType.MINUS, matcher.group("minus")));
			} else if (matcher.group("multiply") != null) {
				tokens.add(new Token(TokenType.MULTIPLY, matcher.group("multiply")));
			} else if (matcher.group("divide") != null) {
				tokens.add(new Token(TokenType.DIVIDE, matcher.group("divide")));
			} else if (matcher.group("modulo") != null) {
				tokens.add(new Token(TokenType.MODULO, matcher.group("modulo")));
			} else if (matcher.group("lparen") != null) {
				tokens.add(new Token(TokenType.LPAREN, matcher.group("lparen")));
			} else if (matcher.group("rparen") != null) {
				tokens.add(new Token(TokenType.RPAREN, matcher.group("rparen")));
			} else if (matcher.group("semicolon") != null) {
				tokens.add(new Token(TokenType.SEMICOLON, matcher.group("semicolon")));
			} else if (matcher.group("numberKeyword") != null) {
				tokens.add(new Token(TokenType.NUMBER_KEYWORD, matcher.group("numberKeyword")));
			} else if (matcher.group("stringKeyword") != null) {
				tokens.add(new Token(TokenType.STRING_KEYWORD, matcher.group("stringKeyword")));
			} else if (matcher.group("booleanKeyword") != null) {
				tokens.add(new Token(TokenType.BOOLEAN_KEYWORD, matcher.group("booleanKeyword")));
			} else {
				tokens.add(new Token(TokenType.UNKNOWN, matcher.group()));
			}
		}
		return tokens;
	}
}
