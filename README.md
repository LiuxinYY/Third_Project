# Third_Project
# 接口程序实验
# 计G201 刘馨 2020322069 
# 一、实验目的
1. 掌握Java中抽象类和抽象方法的定义； 
2. 掌握Java中接口的定义，熟练掌握接口的定义形式以及接口的实现方法
3. 了解异常的使用方法，并在程序中根据输入情况做异常处理

# 二、实验要求
1. 设计两个管理接口：学生管理接口和教师管理接口。学生接口必须包括缴纳学费、查学费的方法；教师接口包括发放薪水和查询薪水的方法。
2. 设计博士研究生类，实现上述的两个接口，该博士研究生应具有姓名、性别、年龄、每学期学费、每月薪水等属性。（其他属性及方法，可自行发挥）
3. 编写测试类，并实例化至少两名博士研究生，统计他们的年收入和学费。根据两者之差，算出每名博士研究生的年应纳税金额（国家最新工资纳税标准，请自行检索）。
4. 在 博士研究生类中实现各个接口定义的抽象方法;
5. 对年学费和年收入进行统计，用收入减去学费，求得纳税额；
6. 国家最新纳税标准（系数），属于某一时期的特定固定值，与实例化对象没有关系，考虑如何用static  final修饰定义。
7. 实例化研究生类时，可采用运行时通过main方法的参数args一次性赋值，也可采用Scanner类实现运行时交互式输入。
8. 根据输入情况，要在程序中做异常处理。
# 三、实验过程
1. 创建Postgradute类
    - 定义学生Student接口和教师Teacher两个接口，学生接口必须有缴纳学费addFee抽象方法、查学费getFee两个方法；教师接口包括发放薪水addSalary抽象方法和查询薪水addSalary方法。
    - 设置主类Postgradute使用implements实现Student,Teacher两个接口
    - 在类中定义 name,  number, age, sex,tuition，salary，tax七个变量,分别表示姓名、学号、年龄、性别、年学费、每月学费、纳税额。
    - 使用super创建有参构造方法和无参构造方法，使用使用Object根类的toString（）方法打印人员基本信息。
    - 实现重写接口中定义的抽象方法和非抽象方法，给出方法体。（获取缴纳的学费和每月发放的薪水）
2. 创建Amount测试类
    - 定义TAX接口，接口中设置月份、年输入、以及纳税率的具体数值
    - 定义类A实现TAX接口，类中定义静态方法Tax，判断纳税的数额。
    - 在测试主类Amount中使用Scanner对象使用System.in表示输入设备，调用nextdouble()方法读取double类型的数
    - 定义初始化tax1,tax1的值为对学费和薪水计算得到的纳税额
    - 初始化研究生Postgradute对象，并将输入的数据以及计算得到的数据传入对象 
    - 打印输出纳税额
3. 添加内容
    - 对输入内容进行数据类型判断（若输入错误，则重新输入）
# 四、核心代码
1. 接口的声明
```
//定义接口
interface Student{
//	定义抽象方法，缴纳学费
	public abstract void addFee(double tuition);
//	定义非抽象方法，获取学费
	public double getFee();
}
```
2. 接口的实现
```
//实现接口
public class Postgradute implements Student,Teacher {
	private String name;
	private int number;
	private int age;
	private boolean sex;
	private double tuition;
	private double salary;
	private double tax;
```
3. 重写接口中的方法，给出方法体
```
//	重写接口中的方法，给出方法体
	public void addSalary(double salary) {
		// TODO Auto-generated method stub
		this.salary=salary;
	}

	public double getSalary() {
		// TODO Auto-generated method stub
		return this.salary;
	}
```
4. 用static定义方法
```
interface TAX{
	int month=12;
	int ST=5000;
	int ST1=8000;
	int ST2=17000;
	double RETE=0.03;
	double RETE1=0.1;
}
//定义静态方法
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
```
5. 采用Scanner类实现运行时交互式输入
```
//		输入数据
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("请输入你的月工资：");
		double salary = scanner1.nextDouble();
		
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("请输入你的学费：");
		double tuition = scanner2.nextDouble();
```
6. 调用静态方法，并初始化对象
```
		double tex1;
		tex1=A.Tex( salary, tuition);
		Postgradute p1=new Postgradute("张三", 1234567, 15, false, tuition, salary, tex1);
```
6. 异常判断
```
		}catch(InputMismatchException e){
			System.out.println("您输入的数据错误\n");
			continue input;
		}
```
# 五、实验结果
1. 当年收入减去学费小于收税金额时，输出结果

![RUNOOB 图标](http://p.qlogo.cn/qqmail_head/7YEOYibLSdBqZVD4CyGuGu0fhvWt8ibzgj1bHMWR2jeQic86GGB0xcDwRibXxASyVPzgNpY4ic8duJ4A/0)

2. 当年收入减去学费大于收税金额时，输出结果

![RUNOOB 图标](https://p.qlogo.cn/qqmail_head/ajNVdqHZLLCjXzl2bwPUPHEQOOzARqLRmZFqzPgyAkyQs5QCQsC5SqjEtPibT1dfvqCKSx4ibslMM/0)

3.当输入数据类型错误时，输出

![RUNOOB 图标](https://p.qlogo.cn/qqmail_head/ajNVdqHZLLCjXzl2bwPUPHEQOOzARqLRmZFqzPgyAkyZxOciaoONJvdRH9vJvqncAZTJlCrjbqZI/0)


# 六、实验感想
通过本次实验所写的程序代码，通过动手编程实现，观察输出结果，学会Java中抽象类和抽象方法的定义， 了解Java中接口的定义，熟练掌握接口的定义形式以及接口的实现方法了解异常的使用方法，并在程序中根据输入情况做异常处理。
