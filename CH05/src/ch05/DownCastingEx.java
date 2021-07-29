package ch05;
class Person03{
	String name;
	String id;
	public Person03(String name) {
		this.name = name;
	}
}
class Student03 extends Person03 {
	String grade;
	String department;
	public Student03(String name) {
		super(name);
	}
}
public class DownCastingEx {
	public static void main(String[] args) {
		Person03 p = new Student03("test");
		Student03 s;
		s = (Student03)p;
		s.department="컴공";
	}
}
