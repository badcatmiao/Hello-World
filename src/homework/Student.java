package homework;

public class Student { //学生类
    String name;
    String sex;
    Subject[] subjects;
    //成员内部类：课程类
    class Subject{
        String subjectName;
        SubjectType st;
        int atten;
        int assign;
        int lab;
        int finalExam;
    }
    static class SubjectType{
        String type;
        double attenRatio;
        static final double assignRatio=0.1;
        static final double labRatio=0.1;
        double finalRatio;
        void setRatio( ){ 
        	if(this.type.equals("考查")){
				this.attenRatio=0.1;
				this.finalRatio=0.7;
			}
        	else{
				this.attenRatio=0.2;
				this.finalRatio=0.6;
			}
        }
        SubjectType(String st){
			this.type=st;
		}
    }
    //打印方法
    void printInfo(){
        class calcScore{ //局部内部类
            //用于计算总分
            int calcTotal(Subject sb){
            	double total=0;
            	total = (sb.atten*sb.st.attenRatio+sb.assign*sb.st.assignRatio+sb.lab*sb.st.labRatio+sb.finalExam*sb.st.finalRatio);
            	return (int) total;
				    }	
        }
        System.out.println("姓名："+this.name+"    "+"性别："+this.sex);
		System.out.println("课程\t"+"性质\t"+"出勤\t"+"作业\t"+"实验\t"+"期末\t"+"总分\t");
		System.out.println("===================================================");
		for(int i=0;i<this.subjects.length;i++){
			System.out.print(this.subjects[i].subjectName+"\t"+this.subjects[i].st.type+"\t"+this.subjects[i].atten+"\t");
			System.out.print(this.subjects[i].assign+"\t"+this.subjects[i].lab+"\t"+this.subjects[i].finalExam+"\t");
			calcScore ca=new calcScore();
			System.out.println(ca.calcTotal(this.subjects[i]));
		}
    }
    public static void main(String[] args) {  
    	Student.SubjectType st1=new Student.SubjectType("考查");
		st1.setRatio();
		Student.SubjectType st2=new Student.SubjectType("考试");
		st2.setRatio();
		
		Student stu1=new Student();
		stu1.name="李红";
		stu1.sex="女";
		
		stu1.subjects=new Subject[3];
		
		Student.Subject stu1_1=stu1.new Subject();
		stu1_1.subjectName="Java";
		stu1_1.st=st1;
		stu1_1.atten=90;
		stu1_1.assign=85;
		stu1_1.lab=75;
		stu1_1.finalExam=80;
		
		Student.Subject stu1_2=stu1.new Subject();
		stu1_2.subjectName="SQL";
		stu1_2.st=st2;
		stu1_2.atten=80;
		stu1_2.assign=90;
		stu1_2.lab=82;
		stu1_2.finalExam=75;
		
		Student.Subject stu1_3=stu1.new Subject();
		stu1_3.subjectName="J2EE";
		stu1_3.st=st1;
		stu1_3.atten=78;
		stu1_3.assign=70;
		stu1_3.lab=65;
		stu1_3.finalExam=70;
		
		stu1.subjects[0]=stu1_1;
		stu1.subjects[1]=stu1_2;
		stu1.subjects[2]=stu1_3;
		stu1.printInfo();
		
		System.out.println("\n***************************************************\n");
		
		Student stu2=new Student();
		stu2.name="王晓明";
		stu2.sex="男";
		
		stu2.subjects=new Subject[3];
		
		Student.Subject stu2_1=stu2.new Subject();
		stu2_1.subjectName="Java";
		stu2_1.st=st1;
		stu2_1.atten=86;
		stu2_1.assign=67;
		stu2_1.lab=71;
		stu2_1.finalExam=70;
		
		Student.Subject stu2_2=stu1.new Subject();
		stu2_2.subjectName="SQL";
		stu2_2.st=st2;
		stu2_2.atten=77;
		stu2_2.assign=70;
		stu2_2.lab=85;
		stu2_2.finalExam=66;
		
		Student.Subject stu2_3=stu1.new Subject();
		stu2_3.subjectName="J2EE";
		stu2_3.st=st1;
		stu2_3.atten=88;
		stu2_3.assign=74;
		stu2_3.lab=68;
		stu2_3.finalExam=80;
		
		stu2.subjects[0]=stu2_1;
		stu2.subjects[1]=stu2_2;
		stu2.subjects[2]=stu2_3;
		stu2.printInfo();
		
    }
}

