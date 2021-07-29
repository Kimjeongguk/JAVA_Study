package ch05;

class Person {
	private int weight=10;
	int age;
	protected int height;
	public String name;
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Person() {
		System.out.println("생성자 Person");
	}
	
}

class Student extends Person {
	public Student() {
		System.out.println("생성자 Stuendt");
	}
	public void set() {
		age = 30;
		name = "test";
		height = 180;
		setWeight(90);
	}
}
public class InheritanceEx {
	public static void main(String[] args) {
		Student s = new Student();
		s.set();
		System.out.println(s.getWeight());
	}
}
