package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//定义小轿车类
class Car implements Comparable<Car>{
    String carCode; //车辆代号
    String brand; //品牌
    String mode;  //款式
    String color; //颜色
    String date;  //购买日期
    int price;  //价格
    Car(){
		
	}
    Car(String carCode,String brand,String mode,String color,int price){
		this.carCode=carCode;
		this.brand=brand;
		this.mode=mode;
		this.color=color;
		this.price=price;
	}
  //写构造方法
    public int compareTo(Car c){ //比较价格的方法
      return c.price-this.price;
    }
    public void printCarInfo(){ //打印方法
	  System.out.println(carCode+"\t"+brand+"\t"+mode+"\t"+color+"\t"+price);
    }
    public void printCarInfo(int i) {
		System.out.println(carCode+"\t"+brand+"\t"+mode+"\t"+color+"\t"+price+"\t"+date);
	}
}
class CarDealer{ //车行
    String dealerName; //车行名称
    ArrayList<Car> cars;
    CarDealer(String dealerName,ArrayList<Car>cars){
		this.dealerName=dealerName;
		this.cars=cars;
		
    //构造方法
  }
    public void printCaeDealer() {
    	System.out.println(dealerName+"热销车辆");
    	System.out.println("车号\t品牌\t款型\t颜色\t价格");
    	System.out.println("========================================");
    }
}
class Customer{ //顾客
    String name;
    HashMap<String,Car> cars; //String是购买日期，Car是该顾客购买的车
	String date;
    Customer(String name,HashMap<String,Car>cars){
		this.name=name;
		this.cars=cars;
		this.date=date;
	}
    //构造方法
    public void printCustomer() {
    	System.out.println("车号\t品牌\t款型\t颜色\t价格\t购买日期");
    	System.out.println("==================================================");
    }
}


public  class GenericsDemo {

	public static void main(String[] args) {
		Car car1=new Car("CS4634","丰田","皇冠","灰色",210000);
		Car car2=new Car("CS1678","丰田","佳美","白色",200000);
		Car car3=new Car("CS7789","丰田","科罗拉","蓝色",180000);
		//1-实例化三个Car对象
		ArrayList <Car> list1=new ArrayList <Car>();
        //2-实例化一个ArrayList泛型集合对象
		list1.add(car1);
		list1.add(car2);
		list1.add(car3);
		Collections.sort(list1);
        //3-把以上三部车加入到这个ArrayList泛型集合里
		CarDealer cardealer1=new CarDealer("广汽丰田车行",list1);
        //4-实例化一个CarDealer对象
		cardealer1.printCaeDealer();
		for(Car car:list1){
			car.printCarInfo();
		}
        //5-输出该CarDealer车行所热销的车
		Car car4=new Car("CS9234","本田","雅阁","黑色",220000);
		Car car5=new Car("CS2344","本田","飞度","红色",170000);
		Car car6=new Car("CS6577","本田","思域","银色",150000);
		ArrayList <Car> list2=new ArrayList <Car>();
		list2.add(car4);
		list2.add(car5);
		list2.add(car6);
		Collections.sort(list2);
		CarDealer cardealer2=new CarDealer("广汽本田车行",list2);
		cardealer2.printCaeDealer();
		for(Car car:list2){
			car.printCarInfo();
		}

		
		Car car7=new Car("CS7689","别克","君威","银色",250000);
		Car car8=new Car("CS4356","别克","凯越","黑色",240000);
		Car car9=new Car("CS8122","别克","阅朗","红色",230000);
		ArrayList <Car> list3=new ArrayList <Car>();
		list3.add(car7);
		list3.add(car8);
		list3.add(car9);
		Collections.sort(list3);
		CarDealer cardealer3=new CarDealer("上汽别克车行",list3);
		cardealer3.printCaeDealer();
		for(Car car:list3){
			car.printCarInfo();
		}
		System.out.println("#########################################");
		System.out.println("\n");
        //6-步骤1-5一共重复三次，分别输出三个车行所热销的车
		HashMap<String,Car> h1=new HashMap<String,Car>();
        //7-实例化一个HashMap<String,Car>集合对象
		h1.put("key1",car3);
		h1.put("key2", car6);
		car3.date="2013-01-04";
		car6.date="2020-02-22";
		Customer c1=new Customer("李伟文",h1);
        //8-从上面的车行里挑两部车放进该集合里
		System.out.println("第一个顾客："+c1.name+"\t所买车：");
		c1.printCustomer();
		Iterator it1=h1.keySet().iterator();
		while(it1.hasNext()){ 
			String key=(String)it1.next();
			Car Value=h1.get(key);
			Value.printCarInfo(1);
		}
		
        //9-输出该顾客购买日期和车
		HashMap<String,Car> h2=new HashMap<String,Car>();
		h2.put("key1",car4);
		h2.put("key2", car9);
		car4.date="2013-05-20";
		car9.date="2018-08-08";
		Customer c2=new Customer("吴浩强",h2);
		HashMap<String,Car> h3=new HashMap<String,Car>();
		h3.put("key1",car5);
		h3.put("key2", car7);
		car5.date="2011-11-11";
		car7.date="2017-07-07";
		Customer c3=new Customer("杨颜巍",h3);
        //10-步骤7-9一共重复两次，分别输出两个顾客所购买的车的信息
		System.out.println("**************************************************");
		
		System.out.println("第二个顾客："+c2.name+"\t所买车：");
		c2.printCustomer();
		Iterator it2=h2.keySet().iterator();
		while(it2.hasNext()){ 
			String key=(String)it2.next();
			Car Value=h2.get(key);
			Value.printCarInfo(1);
		}
        System.out.println("**************************************************");
		
		System.out.println("第三个顾客："+c3.name+"\t所买车：");
		c3.printCustomer();
		for(Map.Entry<String,Car> entry :h3.entrySet()) {
			entry.getValue().printCarInfo(1);
		}

	}

}

