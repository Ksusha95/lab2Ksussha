package lab2;

import java.io.Serializable;

public abstract class Human implements Serializable {	//Класс ЧЕЛОВЕК, а у всех людей параметры только: имя, фамилия, возраст, пол
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String surname;
	private String patronymic;
	private int age = 0;
	private String sex;	
	
	
	//Пустой конструктор
	public Human () {}
	

	//Делаем сеттеры для всех приватных переменных
	public void setSurname(String surname) {
		
		this.surname = surname;
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setPatronymic(String patronymic) {
		
		this.patronymic = patronymic;
		
	}
	
	public void setAge(int age) {
		
		if (age < 0 || age > 160) 
			System.out.println("Некорректный возраст. Оставлено значение по умолчанию: 0");
		else
			this.age = age;
		
	}
	
	public void setSex(String sex) {
		
		this.sex = sex;
		
	}
	
	//Делаем геттеры для приватных переменных (их будем использовать в методе toString)
	public String getName() {
		
		return name;
	}
	
	public String getSurname() {
		
		return surname;
	}
	
	public String getPatronymic() {
		
		return patronymic;
	}
	
	public int getAge() {
		
		return age;
	}
	
	public String getSex() {
		
		return sex;
	}
	
	

}
