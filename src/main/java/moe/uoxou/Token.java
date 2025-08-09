package moe.uoxou;

import java.text.MessageFormat;

public class Token {
	private final TokenType type;
	private final String value;

	public Token(TokenType type, String value) {
		this.type = type;
		this.value = value;
	}

	public TokenType getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		MessageFormat template = new MessageFormat("{0}┊{1}");
		return template.format(new Object[]{ String.format("%-12s", this.getType().toString()), this.getValue() });
	}
}
