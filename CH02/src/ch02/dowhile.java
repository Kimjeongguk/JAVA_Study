package ch02;

public class dowhile {

	public static void main(String[] args) {
		char _char = 'a';
		
		do {
			System.out.println(_char);
			_char=(char)(_char+1);
		}while(_char<='z' );
	}

}
