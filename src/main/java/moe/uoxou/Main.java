import moe.uoxou.lexer.Lexer;

void main() {
	System.out.println("Hello, World!");

	String input = "number test := 5 + x @ * (32 - 1) % 47;";
	var tokens = new Lexer(input).lex();
	for (var token : tokens) {
		System.out.println(token);
	}
}
