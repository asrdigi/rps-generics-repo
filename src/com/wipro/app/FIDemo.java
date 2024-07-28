package com.wipro.app;

import java.time.LocalDate;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

import com.wipro.model.Gender;
import com.wipro.model.Person;

/**
 * String method(String fname, String lname) : returns “fname name”

Double method(int lbound, int ubound) : returns of average of the
digits between lower bound and upper bound,  inclusive of both

Boolean method(String userId,String password): 
		Returns true if userId and password are different else return false

void method(Person person): display person adharcard, name and birthdate in 
dd-mm-yyyy format and address.

 */
public class FIDemo {

	public static void main(String[] args) {
		BiFunction<String,String,String> bi = (fname,lname)-> fname+" "+lname;
		System.out.println(bi.apply("Rohit", "Sharma"));
		
		BiFunction<Integer,Integer,Double> bi1 = (l,u)->{
			int sum=0;
			for(int i=l;i<=u;i++) {
				sum += i;
			}
			return (double)sum/(u-l+1);
		};

		System.out.println(bi1.apply(10, 20));
		
		BiPredicate<String,String> bip = (userid,pwd)-> !userid.equals(pwd);
		System.out.println(bip.test("admin", "admin"));
		System.out.println(bip.test("admin", "admin@123"));
		
		
		Consumer<Person> cons = p -> System.out.println(p.getAdharCard()+","+ p.getName()
		
				+ ","+ p.getBirthdate()+","+p.getAddress());
		
		cons.accept(new Person(123456789L,"Smith",Gender.MALE,
				LocalDate.of(2002, 10, 12),"Hyderabad",987898879L ));
		
		
		// A method that receives Person object and returns Gender
		Function<Person,Gender> fn = p -> p.getGender();
		System.out.println(fn.apply(new Person(123456789L,"Smith",Gender.MALE,
				LocalDate.of(2002, 10, 12),"Hyderabad",987898879L )));
		
		
		/* Function<T,R> 
		 * Function<Integer,Long> lng= { };
		 * 
		 * IntFunction<R>
		 * IntFunctio<Long> lng = {};
		 */
		//returns factorial of given number
		IntFunction<Long> lng = n ->{
			Long fact=1L;
			while(n>0) {
				fact *= n--;
			}
			return fact;
		};
		
		System.out.println("Factorial of 5: "+ lng.apply(5));
		
		// a method that returns sum of 2 integers
		
		BiFunction<Integer,Integer,Integer> sm = (a,b)->a+b;
		System.out.println(sm.apply(5, 6));
		
		BinaryOperator<Integer> bop = (x,y)->x+y;
		System.out.println(bop.apply(5, 6));
		
		// n=n+5
		UnaryOperator<Integer> uop = n->n+5;
		System.out.println(uop.apply(5));
		
		//Method Reference
		System.out.println("Displaying all the details of a Person..");
		Consumer<Person> cons1 = p -> System.out.println(p);

		cons1.accept(new Person(123456789L,"Smith",Gender.MALE,
		LocalDate.of(2002, 10, 12),"Hyderabad",987898879L ));
		/*
		 * replacing 
		 * 	p -> System.out.println(p);
		 * with
		 *  System.out::println;
		 */
		Consumer<Person> cons2 = System.out::println;
		
		cons2.accept(new Person(123456789L,"Smith",Gender.MALE,
		LocalDate.of(2002, 10, 12),"Hyderabad",987898879L ));
		
	}

}
