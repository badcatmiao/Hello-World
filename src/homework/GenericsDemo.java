package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//����С�γ���
class Car implements Comparable<Car>{
    String carCode; //��������
    String brand; //Ʒ��
    String mode;  //��ʽ
    String color; //��ɫ
    String date;  //��������
    int price;  //�۸�
    Car(){
		
	}
    Car(String carCode,String brand,String mode,String color,int price){
		this.carCode=carCode;
		this.brand=brand;
		this.mode=mode;
		this.color=color;
		this.price=price;
	}
  //д���췽��
    public int compareTo(Car c){ //�Ƚϼ۸�ķ���
      return c.price-this.price;
    }
    public void printCarInfo(){ //��ӡ����
	  System.out.println(carCode+"\t"+brand+"\t"+mode+"\t"+color+"\t"+price);
    }
    public void printCarInfo(int i) {
		System.out.println(carCode+"\t"+brand+"\t"+mode+"\t"+color+"\t"+price+"\t"+date);
	}
}
class CarDealer{ //����
    String dealerName; //��������
    ArrayList<Car> cars;
    CarDealer(String dealerName,ArrayList<Car>cars){
		this.dealerName=dealerName;
		this.cars=cars;
		
    //���췽��
  }
    public void printCaeDealer() {
    	System.out.println(dealerName+"��������");
    	System.out.println("����\tƷ��\t����\t��ɫ\t�۸�");
    	System.out.println("========================================");
    }
}
class Customer{ //�˿�
    String name;
    HashMap<String,Car> cars; //String�ǹ������ڣ�Car�Ǹù˿͹���ĳ�
	String date;
    Customer(String name,HashMap<String,Car>cars){
		this.name=name;
		this.cars=cars;
		this.date=date;
	}
    //���췽��
    public void printCustomer() {
    	System.out.println("����\tƷ��\t����\t��ɫ\t�۸�\t��������");
    	System.out.println("==================================================");
    }
}


public  class GenericsDemo {

	public static void main(String[] args) {
		Car car1=new Car("CS4634","����","�ʹ�","��ɫ",210000);
		Car car2=new Car("CS1678","����","����","��ɫ",200000);
		Car car3=new Car("CS7789","����","������","��ɫ",180000);
		//1-ʵ��������Car����
		ArrayList <Car> list1=new ArrayList <Car>();
        //2-ʵ����һ��ArrayList���ͼ��϶���
		list1.add(car1);
		list1.add(car2);
		list1.add(car3);
		Collections.sort(list1);
        //3-���������������뵽���ArrayList���ͼ�����
		CarDealer cardealer1=new CarDealer("�������ﳵ��",list1);
        //4-ʵ����һ��CarDealer����
		cardealer1.printCaeDealer();
		for(Car car:list1){
			car.printCarInfo();
		}
        //5-�����CarDealer�����������ĳ�
		Car car4=new Car("CS9234","����","�Ÿ�","��ɫ",220000);
		Car car5=new Car("CS2344","����","�ɶ�","��ɫ",170000);
		Car car6=new Car("CS6577","����","˼��","��ɫ",150000);
		ArrayList <Car> list2=new ArrayList <Car>();
		list2.add(car4);
		list2.add(car5);
		list2.add(car6);
		Collections.sort(list2);
		CarDealer cardealer2=new CarDealer("�������ﳵ��",list2);
		cardealer2.printCaeDealer();
		for(Car car:list2){
			car.printCarInfo();
		}

		
		Car car7=new Car("CS7689","���","����","��ɫ",250000);
		Car car8=new Car("CS4356","���","��Խ","��ɫ",240000);
		Car car9=new Car("CS8122","���","����","��ɫ",230000);
		ArrayList <Car> list3=new ArrayList <Car>();
		list3.add(car7);
		list3.add(car8);
		list3.add(car9);
		Collections.sort(list3);
		CarDealer cardealer3=new CarDealer("������˳���",list3);
		cardealer3.printCaeDealer();
		for(Car car:list3){
			car.printCarInfo();
		}
		System.out.println("#########################################");
		System.out.println("\n");
        //6-����1-5һ���ظ����Σ��ֱ�������������������ĳ�
		HashMap<String,Car> h1=new HashMap<String,Car>();
        //7-ʵ����һ��HashMap<String,Car>���϶���
		h1.put("key1",car3);
		h1.put("key2", car6);
		car3.date="2013-01-04";
		car6.date="2020-02-22";
		Customer c1=new Customer("��ΰ��",h1);
        //8-������ĳ��������������Ž��ü�����
		System.out.println("��һ���˿ͣ�"+c1.name+"\t���򳵣�");
		c1.printCustomer();
		Iterator it1=h1.keySet().iterator();
		while(it1.hasNext()){ 
			String key=(String)it1.next();
			Car Value=h1.get(key);
			Value.printCarInfo(1);
		}
		
        //9-����ù˿͹������ںͳ�
		HashMap<String,Car> h2=new HashMap<String,Car>();
		h2.put("key1",car4);
		h2.put("key2", car9);
		car4.date="2013-05-20";
		car9.date="2018-08-08";
		Customer c2=new Customer("���ǿ",h2);
		HashMap<String,Car> h3=new HashMap<String,Car>();
		h3.put("key1",car5);
		h3.put("key2", car7);
		car5.date="2011-11-11";
		car7.date="2017-07-07";
		Customer c3=new Customer("����Ρ",h3);
        //10-����7-9һ���ظ����Σ��ֱ���������˿�������ĳ�����Ϣ
		System.out.println("**************************************************");
		
		System.out.println("�ڶ����˿ͣ�"+c2.name+"\t���򳵣�");
		c2.printCustomer();
		Iterator it2=h2.keySet().iterator();
		while(it2.hasNext()){ 
			String key=(String)it2.next();
			Car Value=h2.get(key);
			Value.printCarInfo(1);
		}
        System.out.println("**************************************************");
		
		System.out.println("�������˿ͣ�"+c3.name+"\t���򳵣�");
		c3.printCustomer();
		for(Map.Entry<String,Car> entry :h3.entrySet()) {
			entry.getValue().printCarInfo(1);
		}

	}

}

