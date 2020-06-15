package lab2;

public class Student extends UniversityStaff {
	
	private static final long serialVersionUID = 1L;
	
	private Lecturer lecturerForStudent = null;	//Препод, специально подобранный для этого студента
	
	//Конструктор для объектов Student
	public Student () {}
	
	//Делаем сеттеры для всех переменных
	
	public void setID(int ID) {
		
		super.setID(ID);
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
				
		super.setMoney(money);
	}

	public void setAverageRatingSession(int averageRatingSession) {
				
		super.setAverageRatingSession(averageRatingSession);
	}
	
	//Перегруженная функция toString
	public String toString() {
		
		return super.toString();
	}
	
	//Метод createPair, создающий пару студень - препод
	public void createPair(Object lecturerForStudent) {
		
		this.lecturerForStudent = (Lecturer)lecturerForStudent;
	}
	
	public Lecturer getLecturerForStudent() {
		
		return lecturerForStudent;
	}

}
