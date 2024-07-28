package com.wipro.app;

import java.lang.reflect.Field;
import java.time.LocalDate;

import com.wipro.model.Gender;
import com.wipro.model.Person;

public class ReflectionDemo {

	public static void main(String[] args) {
		String greeting  = new String("Welcome to java reflection");
		
		Class myClassRef = greeting.getClass();
		
		System.out.println(myClassRef.getName());
		
		Person person = new Person(123456789L,"Smith",Gender.MALE,
				LocalDate.of(2002, 10, 12),"Hyderabad",987898879L );
		
		Class myClass = person.getClass();
		System.out.println(myClass.getName());
		/*
		 * myClass.getFields() returns only public fields
		 */
		Field[] fields = myClass.getDeclaredFields();
		for(Field f: fields) {
			System.out.println(f.getName());
		}

	}

}
