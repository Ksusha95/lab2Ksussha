package lab2;

public final class ExcellentStudent extends Student {
	
	private static final long serialVersionUID = 1L;
	
	private CoolLecturer coolLecturerForExcellStudent = null;	//"Крутой" препод, специально подобранный для этого студента-отличника
	
	
	public ExcellentStudent () {}
	
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

	public void setAverageRatingSession(double averageRatingSession) {
					
		super.setAverageRatingSession(averageRatingSession);
	}
	
	public String toString() {
		
		return super.toString();
	}
	
	public void createPair(Object lecturerForStudent) {
		
		this.coolLecturerForExcellStudent = (CoolLecturer)lecturerForStudent;
	}
	
	public CoolLecturer getCoolLecturerForExcellStudent() {
		
		return coolLecturerForExcellStudent;
	}

}
