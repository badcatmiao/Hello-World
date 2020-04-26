package homework;

enum BookType{ 
	Science("科学"),Medicine("医药"),Literature("文学"),Foodcooking("饮食"),Magazine("杂志");
	String name;
	 BookType(String name){
		this.name=name;
    } //图书类型枚举

}
enum Press{ 
	清华大学出版社,北京大学出版社,电子工业出版社,机械工业出版社,杂志期刊主办商;
	} //出版社类型枚举
enum Sex{ 
	男,女;
} //性别枚举 
class Book{  //图书类
    String bookName;
    Press press;
    BookType bookType;
    int BorrowType;
    void printBookInfo(){ 
    	
    	switch(BorrowType) {
		case 0:
			System.out.println(bookName+"\t\t"+press+"\t"+"不能租借\t\t"+bookType.name+"\t\t"+bookType);
			break;
		case 1:
			System.out.println(bookName+"\t\t"+press+"\t"+"办理借阅\t\t"+bookType.name+"\t\t"+bookType);
			break;
    	}
    }//打印图书信息
}
class Reader{  //读者类
    String readerName;
    Sex sex;
    Book[] books;
    void printBorrowInfo(){ 
    	System.out.println("读者姓名："+readerName+"\n"+"性别："+sex+"\n"+"该读者的借阅信息如下：");
		System.out.println("图书名称\t\t出版社\t\t借阅\t\t编号\t\t类型描述");
		System.out.println("==============================================================================");  //打印该读者的借阅信息
    }
}
public class LibraryDemo {
    public static void main (String[] args) { 
    	Book book1=new Book();
		book1.bookName="数据库原理";
		book1.bookType=BookType.Science;
		book1.press=Press.清华大学出版社;
		book1.BorrowType=1;
		
		Book book2=new Book();
		book2.bookName="医学与美容";
		book2.bookType=BookType.Medicine;
		book2.press=Press.北京大学出版社;
		book2.BorrowType=1;
		
		Book book3=new Book();
		book3.bookName="平凡的世界";
		book3.bookType=BookType.Literature;
		book3.press=Press.电子工业出版社;
		book3.BorrowType=1;
		
		Book book4=new Book();
		book4.bookName="饮食与健康";
		book4.bookType=BookType.Foodcooking;
		book4.press=Press.机械工业出版社;
		book4.BorrowType=1;
		
		Book book5=new Book();
		book5.bookName="计算机基础";
		book5.bookType=BookType.Science;
		book5.press=Press.北京大学出版社;
		book5.BorrowType=1;
		
		Book book6=new Book();
		book6.bookName="计算机科学";
		book6.bookType=BookType.Magazine;
		book6.press=Press.杂志期刊主办商;
		book6.BorrowType=0;
		
		Reader reader1=new Reader();
		reader1.readerName="李红";
		reader1.sex=Sex.女;
		reader1.books=new Book[3];
		reader1.books[0]=book1;
		reader1.books[1]=book2;
		reader1.books[2]=book3;
		
		reader1.printBorrowInfo();
		reader1.books[0].printBookInfo();
		reader1.books[1].printBookInfo();
		reader1.books[2].printBookInfo();
		
		System.out.println();
		System.out.println("******************************************************************************");
		System.out.println();
		
		Reader reader2=new Reader();
		reader2.readerName="肖明";
		reader2.sex=Sex.男;
		reader2.books=new Book[3];
		reader2.books[0]=book4;
		reader2.books[1]=book5;
		reader2.books[2]=book6;
		
		reader2.printBorrowInfo();
		reader2.books[0].printBookInfo();
		reader2.books[1].printBookInfo();
		reader2.books[2].printBookInfo();
    }
}
