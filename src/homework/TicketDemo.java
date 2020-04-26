package homework;
import java.io.*;
import java.util.*;

//���Ƽ�
//enum Type implements Serializable{
//	����Ƭ,ϲ��Ƭ,����Ƭ,�ƻ�Ƭ;
//}


//��Ӱ����
enum MovieType implements Serializable{    
	//�Լ��������
	ACTION("����Ƭ"),SIENTIFIC("�ƻ�Ƭ"),ROMANTIC("����Ƭ"),COMIDY("ϲ��Ƭ");
	private String typeName; //����
	
	MovieType(){
		
	}
	MovieType(String typeName){
		this.typeName=typeName;
	}
	public String getTypeName(){
		return typeName;
	}
}

//��Ӱ
class Movie implements Serializable{   
	MovieType mt;
	String movieName;
	//ʡ�Թ��췽��
	Movie(String movieName,MovieType mt){
		this.movieName=movieName;
		this.mt=mt;
	}
}
//��Ӱ��ӳʱ���
class MovieSchedule implements Serializable{  
	String theatre;  //��ӳ�� 
	String time;  //��ӳʱ�䣺������ ��ʱ��
	
	MovieSchedule(String time,String theatre){
		this.time=time;
		this.theatre=theatre;
	}//ʡ�Թ��췽��
	//...
}

//��λ
class Seat implements Serializable{  
	int row;
	int column;
	//ʡ�Թ��췽��
	//....
	Seat(int column,int row){
		this.row=row;  //��
		this.column=column;  //��
	}
}
//��ӰƱ
class Ticket implements Serializable{
	Movie movie;
	MovieSchedule  ms;
	Seat seat;
	//ʡ�Թ��췽��
	//....
	Ticket(Movie movie,MovieSchedule ms,Seat seat){
		this.movie=movie;
		this.ms=ms;
		this.seat=seat;
	}
	
	public void printTicket(){ //��ӡƱ����ϸ��Ϣ 
		System.out.println(movie.movieName);
		System.out.println("���ͣ�"+movie.mt.getTypeName());
		System.out.println("��ӳ����"+ms.theatre);
		System.out.println("ʱ�䣺"+ms.time);
		System.out.println("��λ��"+seat.column+"��"+seat.row+"��");
		System.out.println("*************************");
	}
}

public class TicketDemo {

	public static void main(String[] args) {
		//--1 �����Ӱ����ö�ٶ���
		MovieType mt1=MovieType.ACTION; //�Զ�����ö�ٵĴ������Ĺ��췽�������ݡ�����Ƭ������
		
		//System.out.println(mt1.getTypeName());
		
		MovieType mt2=MovieType.SIENTIFIC;
		
		//System.out.println(mt2.getTypeName());
		//--2 �����Ӱ����
		Movie m1=new Movie("����ʯͷ",mt1);
		Movie m2=new Movie("2012",mt2);
		//--3 �����ӳ���ζ���
		MovieSchedule MS1=new MovieSchedule("2010��7��12��	20ʱ20��","��ӳ��1");
		MovieSchedule MS2=new MovieSchedule("2010��7��14��	19ʱ40��","��ӳ��2");
		//--4 ������λ����
		Seat s1=new Seat(10,12);
		Seat s2=new Seat(10,13);
		Seat s3=new Seat(8,8);
		Seat s4=new Seat(8,9);
		//--5 ���ݵ�Ӱ����ӳ���Ρ���λ�����ӰƱ����
		Ticket t1=new Ticket(m1,MS1,s1);
		Ticket t2=new Ticket(m1,MS1,s2);
		Ticket t3=new Ticket(m2,MS2,s3);
		Ticket t4=new Ticket(m2,MS2,s4);
		
		Ticket [] t=new Ticket[4];
		t[0]=t1;
		t[1]=t2;
		t[2]=t3;
		t[3]=t4;
		//--6 ���л�����ӰƱд��dat�������ļ�
		try {
			File file=new File("ticket.dat");
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			
			oos.writeObject(t);
			oos.close();
			fos.close();
			
		//--7 �����л���dat��������ĵ�ӰƱ������
			FileInputStream fis =new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Ticket [] tt=(Ticket[])ois.readObject();
			for(Ticket T:tt) {
				T.printTicket();
			}
			ois.close();
			fis.close();
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
