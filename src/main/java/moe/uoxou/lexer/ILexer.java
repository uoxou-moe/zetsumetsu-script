package moe.uoxou.lexer;

import moe.uoxou.Token;

import java.util.List;

public interface ILexer {
	/**
	 * トークンを解析するメソッド
	 *
	 * @return 解析されたトークンのリスト
	 */
	List<Token> lex();
}
