package com.yy.cn;

import java.util.InputMismatchException;
import java.util.Scanner;
interface TAX{
	int month=12;
	int ST=5000;
	int ST1=8000;
	int ST2=17000;
	double RETE=0.03;
	double RETE1=0.1;
}
class A implements TAX{
	public static double Tex(double salary,double tuition){
		double a =0;
		double i=salary*12-tuition;
		if(i<=ST*12){
			a=0;
			System.out.println("你今年无需缴纳税费");
		}else if(i>=ST*12 && i<=ST1*12){
			a=i*RETE;
		}else if(i>=ST1*12 && i<=ST2*12){
			a=i*RETE1;
		}
		return a;
		
	}
}
//class NumberException extends Exception{
//	String message;
//	public NumberException(int m){
//		message = "您输入的"+m+"\n 不符合系统规则，请重新输入";
//	}
//	public String warnness(){
//		return message;
//	}
//}
public class Amount {
//	public static void ChNum (int m) throws NumberException{
//		if(c)
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		A a1=new A();
		input:
		while(true){
		try{	
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("请输入你的月工资：");
		double salary = scanner1.nextDouble();
		
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("请输入你的学费：");
		double tuition = scanner2.nextDouble();
		double tex1;
		tex1=A.Tex( salary, tuition);
		Postgradute p1=new Postgradute("张三", 1234567, 15, false, tuition, salary, tex1);
		System.out.println(p1.getName()+"该学生税额是："+p1.getTax());
		}catch(InputMismatchException e){
			System.out.println("您输入的数据错误\n");
			continue input;
		}
		
	}
	}
	
}
