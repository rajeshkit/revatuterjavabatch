package jdk8features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo1 {
		// log4j - external dependency for logging framework

	public static void main(String[] args) {
		//Predicate p;//boolean test(T t);
		//Consumer c; //void accept(T t);
		//Function f; //R apply(T t);
		//Supplier s; //T get();
		
		// stream source -> streams are generated source(source- array, collection)
		// intermediate operation -> filter, map, sort
		// terminal operation -> collect,forEach
		IntPredicate p=(i)->{ // filter condition
			if(i%2==0) {
				return true;
			}
			return false;
		};
		IntPredicate p1=(i)->{ // filter condition
			if(i%2!=0) {
				return true;
			}
			return false;
		};
		
		int[] marks={343,56,34,77,23,575};
		
		Predicate<String> p3=(str)->{
			if(str.contains("n")) {
				return true;
			}
			return false;
		};
		
		List<String> list=Arrays.asList("chennai","mumbai","bangalore","pune");
		System.out.println("***************************");
		list.stream().filter(str-> str.contains("n")).sorted().forEach(e->System.out.println(e));
		
		System.out.println("*******************************");
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//Arrays.stream(marks).filter(p).forEach(e->System.out.println(e));
		Arrays.stream(marks).map(t-> t+50).forEach(e->System.out.println(e));
		
		System.out.println("****************");
		Arrays.stream(marks).filter(p1).forEach(e->System.out.println(e));
			
		System.out.println(p.test(35));
	
		
		
		Consumer<Long> c=(t)-> System.out.println(t);// consume
		c.accept(567567L);

	}

}
