package homework;
import java.io.*;
import java.util.*;

//不推荐
//enum Type implements Serializable{
//	动作片,喜剧片,爱情片,科幻片;
//}


//电影类型
enum MovieType implements Serializable{    
	//自己补充代码
	ACTION("动作片"),SIENTIFIC("科幻片"),ROMANTIC("爱情片"),COMIDY("喜剧片");
	private String typeName; //中文
	
	MovieType(){
		
	}
	MovieType(String typeName){
		this.typeName=typeName;
	}
	public String getTypeName(){
		return typeName;
	}
}

//电影
class Movie implements Serializable{   
	MovieType mt;
	String movieName;
	//省略构造方法
	Movie(String movieName,MovieType mt){
		this.movieName=movieName;
		this.mt=mt;
	}
}
//电影放映时间段
class MovieSchedule implements Serializable{  
	String theatre;  //放映厅 
	String time;  //放映时间：年月日 、时分
	
	MovieSchedule(String time,String theatre){
		this.time=time;
		this.theatre=theatre;
	}//省略构造方法
	//...
}

//座位
class Seat implements Serializable{  
	int row;
	int column;
	//省略构造方法
	//....
	Seat(int column,int row){
		this.row=row;  //行
		this.column=column;  //列
	}
}
//电影票
class Ticket implements Serializable{
	Movie movie;
	MovieSchedule  ms;
	Seat seat;
	//省略构造方法
	//....
	Ticket(Movie movie,MovieSchedule ms,Seat seat){
		this.movie=movie;
		this.ms=ms;
		this.seat=seat;
	}
	
	public void printTicket(){ //打印票的详细信息 
		System.out.println(movie.movieName);
		System.out.println("类型："+movie.mt.getTypeName());
		System.out.println("放映厅："+ms.theatre);
		System.out.println("时间："+ms.time);
		System.out.println("座位："+seat.column+"排"+seat.row+"座");
		System.out.println("*************************");
	}
}

public class TicketDemo {

	public static void main(String[] args) {
		//--1 构造电影类型枚举对象
		MovieType mt1=MovieType.ACTION; //自动调用枚举的带参数的构造方法，传递“动作片”参数
		
		//System.out.println(mt1.getTypeName());
		
		MovieType mt2=MovieType.SIENTIFIC;
		
		//System.out.println(mt2.getTypeName());
		//--2 构造电影对象
		Movie m1=new Movie("疯狂的石头",mt1);
		Movie m2=new Movie("2012",mt2);
		//--3 构造放映场次对象
		MovieSchedule MS1=new MovieSchedule("2010年7月12日	20时20分","放映厅1");
		MovieSchedule MS2=new MovieSchedule("2010年7月14日	19时40分","放映厅2");
		//--4 构造座位对象
		Seat s1=new Seat(10,12);
		Seat s2=new Seat(10,13);
		Seat s3=new Seat(8,8);
		Seat s4=new Seat(8,9);
		//--5 根据电影、放映场次、座位构造电影票对象
		Ticket t1=new Ticket(m1,MS1,s1);
		Ticket t2=new Ticket(m1,MS1,s2);
		Ticket t3=new Ticket(m2,MS2,s3);
		Ticket t4=new Ticket(m2,MS2,s4);
		
		Ticket [] t=new Ticket[4];
		t[0]=t1;
		t[1]=t2;
		t[2]=t3;
		t[3]=t4;
		//--6 序列化将电影票写入dat二进制文件
		try {
			File file=new File("ticket.dat");
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			
			oos.writeObject(t);
			oos.close();
			fos.close();
			
		//--7 反序列化将dat二进制里的电影票读出来
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
