package homework;

enum BookType{ 
	Science("��ѧ"),Medicine("ҽҩ"),Literature("��ѧ"),Foodcooking("��ʳ"),Magazine("��־");
	String name;
	 BookType(String name){
		this.name=name;
    } //ͼ������ö��

}
enum Press{ 
	�廪��ѧ������,������ѧ������,���ӹ�ҵ������,��е��ҵ������,��־�ڿ�������;
	} //����������ö��
enum Sex{ 
	��,Ů;
} //�Ա�ö�� 
class Book{  //ͼ����
    String bookName;
    Press press;
    BookType bookType;
    int BorrowType;
    void printBookInfo(){ 
    	
    	switch(BorrowType) {
		case 0:
			System.out.println(bookName+"\t\t"+press+"\t"+"�������\t\t"+bookType.name+"\t\t"+bookType);
			break;
		case 1:
			System.out.println(bookName+"\t\t"+press+"\t"+"�������\t\t"+bookType.name+"\t\t"+bookType);
			break;
    	}
    }//��ӡͼ����Ϣ
}
class Reader{  //������
    String readerName;
    Sex sex;
    Book[] books;
    void printBorrowInfo(){ 
    	System.out.println("����������"+readerName+"\n"+"�Ա�"+sex+"\n"+"�ö��ߵĽ�����Ϣ���£�");
		System.out.println("ͼ������\t\t������\t\t����\t\t���\t\t��������");
		System.out.println("==============================================================================");  //��ӡ�ö��ߵĽ�����Ϣ
    }
}
public class LibraryDemo {
    public static void main (String[] args) { 
    	Book book1=new Book();
		book1.bookName="���ݿ�ԭ��";
		book1.bookType=BookType.Science;
		book1.press=Press.�廪��ѧ������;
		book1.BorrowType=1;
		
		Book book2=new Book();
		book2.bookName="ҽѧ������";
		book2.bookType=BookType.Medicine;
		book2.press=Press.������ѧ������;
		book2.BorrowType=1;
		
		Book book3=new Book();
		book3.bookName="ƽ��������";
		book3.bookType=BookType.Literature;
		book3.press=Press.���ӹ�ҵ������;
		book3.BorrowType=1;
		
		Book book4=new Book();
		book4.bookName="��ʳ�뽡��";
		book4.bookType=BookType.Foodcooking;
		book4.press=Press.��е��ҵ������;
		book4.BorrowType=1;
		
		Book book5=new Book();
		book5.bookName="���������";
		book5.bookType=BookType.Science;
		book5.press=Press.������ѧ������;
		book5.BorrowType=1;
		
		Book book6=new Book();
		book6.bookName="�������ѧ";
		book6.bookType=BookType.Magazine;
		book6.press=Press.��־�ڿ�������;
		book6.BorrowType=0;
		
		Reader reader1=new Reader();
		reader1.readerName="���";
		reader1.sex=Sex.Ů;
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
		reader2.readerName="Ф��";
		reader2.sex=Sex.��;
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
