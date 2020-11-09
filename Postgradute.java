package com.yy.cn;

interface Student{
	public abstract void addFee(double tuition);
	public double getFee();
}
interface Teacher{
	public abstract void addSalary(double salary);
	public double getSalary();
}
public class Postgradute implements Student,Teacher {
	private String name;
	private int number;
	private int age;
	private boolean sex;
	private double tuition;
	private double salary;
	private double tax;
	public Postgradute() {
		super();
	}

	public Postgradute(String name, int number, int age, boolean sex,
			double tuition, double salary, double tax) {
		super();
		this.name = name;
		this.number = number;
		this.age = age;
		this.sex = sex;
		this.tuition = tuition;
		this.salary = salary;
		this.tax = tax;
	}

	public void addSalary(double salary) {
		// TODO Auto-generated method stub
		this.salary=salary;
	}

	public void addFee(double tuition) {
		// TODO Auto-generated method stub
		this.tuition=tuition;
		
	}
	

	public double getSalary() {
		// TODO Auto-generated method stub
		return this.salary;
	}

	public double getFee() {
		// TODO Auto-generated method stub
		return this.tuition;
	}
//	public double tex(double tax,double salary,double tuition){
//		tax=(salary*12-tuition)*0.05;
//		return tax;
//		
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean getSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	public String toString() {
		return "Postgradute [name=" + name + ", number=" + number + ", age="
				+ age + ", sex=" + sex + ", tuition=" + tuition + ", salary="
				+ salary + ", tax=" + tax + "]";
	}
}
