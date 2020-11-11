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
6. 添加内容
    - 对输入内容进行数据类型判断（若输入错误，则重新输入）
# 四、核心代码
1. 有参和无参构造方法
```
	//有参构造方法
	public People(int number, String name, Boolean sex, int age) {
		super();
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
//	无参构造方法
	public People() {
		super();
	}
```
2. Object根类的toString（）方法
```
//	Object根类的toString（）方法,判断Boolean类型的男女性别
	public String toString() {
		if(sex==true){
		return "People [编号" + number + ", 名字" + name + ", 性别" + "女"
				+ ", 年龄" + age + "]";
		}else
			return "[编号" + number + ", 名字" + name + ", 性别" + "男"
					+ ", 年龄" + age + "]";
	}
```
3. 使用super调用父类中的构造方法
```
//	使用super调用父类中的构造方法
	public Student(int number, String name, Boolean sex, int age) {
		super(number, name, sex, age);
	}
```
4. 实现一门课程只由一门老师教授
```
//实现一门课程只由一门老师教授
	@Override
	public String toString() {
		if(tea.getName()==c.getTeacher()){
			return "学生："+super.toString()+"\n所选课程" +c+"\n教师信息"+tea;
		}else
			return "学生："+super.toString()+"\n所选课程" +c;		
	}
	public String show(){
		return "学生："+super.toString();
		 
	}
```
5. 实例化对象
```
//		实例化对象（有参）
		Student s1=new Student(1,"杨洋",false,13);
		Course c1=new Course(5555, "Java", "教室306", "张老师", "15:00");
//		实例化对象 （无参）
		Course c2=new Course();
		Teacher t1=new Teacher(33, "张老师", false, 30);
```
6. 设置和获取对象成员值
```
public int getCnumber() {
		return cnumber;
	}
	public void setCnumber(int cnumber) {
		this.cnumber = cnumber;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
```
6. 变量赋值
```
//		为变量赋值
//		s1.setCourse(c2);
		s1.setCourse(c1);
		t1.setCourse(c1);
		s1.setTea(t1);
```
7. 调用方法
```
//		判断学生是否选课
		if(s1.getC().getCnumber()==0){
			System.out.println(s1.show()+"\n该学生已经退课");
		}else
			System.out.println(s1.toString());
```
# 五、实验结果
1. 学生选课成功，并且课程中老师信息与所给老师信息相等时（一门课程只由一门老师教授），输出结果

![RUNOOB 图标](https://p.qlogo.cn/qqmail_head/ajNVdqHZLLCjXzl2bwPUPHEQOOzARqLRmZFqzPgyAkzdweOBibC68M8Sof8atNPjFjb2wpZzEibR0/0)

2. 学生选课成功，并且课程中老师信息与所给老师信息不相等时（一门课程只由一门老师教授），输出结果

![RUNOOB 图标](https://p.qlogo.cn/qqmail_head/ajNVdqHZLLCjXzl2bwPUPHEQOOzARqLRmZFqzPgyAkxxj7ugl4HFaGiaYWicV4yplW9ky95b9BPns/0)

3. 学生退课成功时，输出结果，只输出学生信息

![RUNOOB 图标](https://p.qlogo.cn/qqmail_head/ajNVdqHZLLCjXzl2bwPUPHEQOOzARqLRmZFqzPgyAkxkiaN2uoskv5iavEaia1oQicokVAG3ET75cOM/0)


# 六、实验感想
通过本次实验所写的程序代码，通过动手编程实现，观察输出结果，了解系统中的实体及其关系，学会定义类中的属性以及方法，掌握面向对象的类设计方法（属性、方法）。 学会使用类的继承用法，通过构造方法实例化对象，学会使用super()，用于实例化子类，调用父类中的构造方法，学会使用Object根类的toString（）方法,应用在相关对象的信息输出中。
