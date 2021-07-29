package ch05;
class Person04{
}
class Student04 extends Person04{
}
class Researcher extends Person04 {
}
class Professor extends Researcher{
}
public class InstanceOfEx {
	static void printType(Person04 p) {
		if( p instanceof Person04) {
			System.out.println("Person입니다.");
		}
		if( p instanceof Student04) {
			System.out.println("Student입니다.");
		}
		if( p instanceof Researcher) {
			System.out.println("Researcher입니다.");
		}
		if( p instanceof Professor) {
			System.out.println("Professor입니다.");
		}
	}
	public static void main(String[] args) {
		printType(new Person04());
	}
}
