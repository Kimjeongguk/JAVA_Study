package ch05;
class Person02{
	String name;
	String id;
	public Person02(String name) {
		this.name = name;
	}
}
class Student02 extends Person02 {
	String grade;
	String department;
	public Student02(String name) {
		super(name);
	}
}
public class UpcastingEx {
	public static void main(String[] args) {
		Person02 p ;
		Student02 s = new Student02("test");
		p = s;
		System.out.println(p.name);
	}
}
