package lab2;
import static lab2.Interfaces.*;

/*Расширяем класс Human классом UniversityStaff - это студенты и преподаватели университета. 
 * У всех студентов и преподавателей есть общие параметры: карманные деньги, средняя оценка за сессию*/
public abstract class UniversityStaff extends Human {
	
	private static final long serialVersionUID = 1L;

	private static String nameUniversity;
	
	private int ID = 0;
	private int money = 0;
	private double averageRatingSession = 0;
	

	public UniversityStaff () {}
	
	//Делаем сеттеры для всех переменных
	public void setID (int ID) {
		
		this.ID = ID;
	}
	
	public void setSurname(String surname) {
		
		super.setSurname(surname);
	}
	
	public void setName(String name) {
		
		super.setName(name);
		
	}
	
	public void setPatronymic(String patronymic) {
		
		super.setPatronymic(patronymic);
		
	}
	
	public void setAge(int age) {
		
		super.setAge(age);
		
	}
	
	public void setSex(String sex) {
		
		super.setSex(sex);
		
	}
	
	public void setMoney(int money) {
		
		if (money < 0) 
			System.out.println("Некорректное значение. Оставлено значение по умолчанию: 0");
		
		else
			this.money = money;
		
	}

	public void setAverageRatingSession(double averageRatingSession) {
		
		if (averageRatingSession < 0 || averageRatingSession > 5)
			System.out.println("Некорректное значение. Оставлено значение по умолчанию: 0");
		
		else 	
			this.averageRatingSession = averageRatingSession;	
	}
	
	public static void setNameUniversity (String nameUniversity) {	
		
		UniversityStaff.nameUniversity = nameUniversity;
	}
	
	
	//Переопределение метода toString:
	public String toString() { 
		
		return "\n  " + ID + "\t" + lineAlignment(getSurname()) + "\t" + lineAlignment(getName()) +  "\t" 
		      + lineAlignment(getPatronymic()) + "\t" + getAge() + "\t" +  getSex() + "\t\t" + money + "\t\t" + averageRatingSession;			
	}
	
	public static String getNameUniversity() {
		
		return nameUniversity;
	}
	
	public int getID() {
		
		return ID;
	}
	
	public int getMoney() {
		
		return money;
	}
	
	public double getAverageRatingSession() {
		
		return averageRatingSession;
	}
	
	
	public abstract void createPair(Object obj);
	
}
