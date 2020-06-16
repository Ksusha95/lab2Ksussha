package lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import static lab2.Demonstration.*;

public class Interfaces {
	
	static Scanner in = new Scanner(System.in);
	
	//Оформление программы:
	public static final String line1 = "--".repeat(60);
	public static final String line2 = "__".repeat(60);
	public static final String headerDataBaseString = line2 + "\n  ID \tSurname\t\tName\t\tPatronymic\tAge\t Sex\t\tMoney\t\tRating\n" + line2 + "\n";
	
	public static String lineAlignment(String string) {
		
		int lengthStr = string.length();
		
		if(string.length() < 15)
			return string + " ".repeat(15 - lengthStr);
		else return string;
		
	}

	public static void clearConsoleForPrintData (int numberOfLineBreaks) {
		
		for (int i = 0; i < numberOfLineBreaks; i++) 
			System.out.print("\n");
	}
	
	public static void clearConsole() {
		
		for (int i = 0; i <55; i++) 
			System.out.println("\n");
	}
	
	
	//Списки меню
 	public static final String startPageString = line1 + "\nВыберите действие: \n" + line1
							   + "\n   [1] Показать содержимое файла lecturers "
							   + "\n   [2] Показать содержимое файла students "
							   + "\n   [3] Распределить данные по массивам данных"
							   + "\n   [4] Перейти к выбору массива данных"
							   + "\n   "
							   + "\n   [0] Выход из программы \n" + line1
							   + "\n Ваш ввод: ";
 	
	public static final String databaseFileSelectionString = line1 + "\nВыберите массив для работы: \n" + line1
								       + "\n   [1] lecturerDataBase ---------- Преподаватели "
								       + "\n   [2] studentDataBase ----------- Студенты "
								       + "\n   [3] coolLecturerDataBase ------ \"Крутые\" преподаватели"
								       + "\n   [4] excellentStudentDataBase -- Студенты-отличники"
								       + "\n   "
							               + "\n   [8] Назад"
								       + "\n   [0] Выход из программы \n" + line1 
								       + "\n Ваш ввод: ";

	public static final String actionWithDatabaseFile = line1 + "\nВыберите действие: \n" + line1
			                                          + "\n   [1] Вывести содержимое массива на экран "
	                                                          + "\n   [2] Добавить запись "
								  + "\n   [3] Удалить запись"
								  + "\n   [4] Применить CreatePair"
								  + "\n   [5] Записать содержимое массива в файл"
								  + "\n   "
								  + "\n   [8] Назад"
							          + "\n   [0] Выход из программы \n" + line1
								  + "\n Ваш ввод: ";

	
	//Добавление данных в существующие БД
	public static Lecturer addLecturerData(ArrayList<Lecturer> lecturerDataBase) throws InterruptedException, InputMismatchException, IOException {
		
		Lecturer lecturer = new Lecturer();
		
		try {
		
			System.out.print ("\nДобавление данных в lecturerDataBase: \n Вводите данные так: ФАМИЛИЯ ИМЯ ОТЧЕСТВО ВОЗРАСТ ПОЛ КАРМАННЫЕ_ДЕНЬГИ СРЕДНЯЯ_ОЦЕНКА_ЗА_СЕССИЮ(формат x,y)\n "
			 				+ "\n Ваш ввод: \n");
		
			lecturer.setSurname(in.next());
			lecturer.setName(in.next());
			lecturer.setPatronymic(in.next());
			lecturer.setAge(in.nextInt());
			lecturer.setSex(in.next());
			lecturer.setMoney(in.nextInt());
			lecturer.setAverageRatingSession(in.nextDouble());
		
			lecturerDataBase.add(lecturer);
			lecturer.setID(lecturerDataBase.indexOf(lecturer) + 1);
		
			System.out.print ("\nДобавление данных успешно завершено.\n\n");
			Thread.sleep(2000);
			clearConsole();
		}
		
		catch (InputMismatchException ex) {
			
			in.next();
			System.out.print ("\n !!! Неверный ввод.\n");
			Thread.sleep(2000);
			callActionWithLecturerDataBase();
		}

		return lecturer;
	} 
	
	public static CoolLecturer addCoolLecturerData(ArrayList<CoolLecturer> coolLecturerDataBase) throws InputMismatchException, InterruptedException, IOException {
		
		CoolLecturer coolLecturer = new CoolLecturer();
		
		try {
		
			System.out.print ("\n Вводите данные так: ФАМИЛИЯ ИМЯ ОТЧЕСТВО ВОЗРАСТ ПОЛ КАРМАННЫЕ_ДЕНЬГИ СРЕДНЯЯ_ОЦЕНКА_ЗА_СЕССИЮ(формат x,y)\n "
			 				+ "\n Ваш ввод: \n");
		
			coolLecturer.setSurname(in.next());
			coolLecturer.setName(in.next());
			coolLecturer.setPatronymic(in.next());
			coolLecturer.setAge(in.nextInt());
			coolLecturer.setSex(in.next());
			coolLecturer.setMoney(in.nextInt());
			coolLecturer.setAverageRatingSession(in.nextDouble());
		
			coolLecturerDataBase.add(coolLecturer);
			coolLecturer.setID(coolLecturerDataBase.indexOf(coolLecturer) + 1);
		
			System.out.print ("\nДобавление данных успешно завершено.");
			Thread.sleep(2000);
			clearConsole();
		}
		
		catch (InputMismatchException ex) {
			
			in.next();
			System.out.print ("\n !!! Неверный ввод.\n");
			Thread.sleep(2000);
			callActionWithCoolLecturerDataBase();
		}

		return coolLecturer;
	} 

	public static Student addStudentData(ArrayList<Student> studentDataBase) throws InputMismatchException, InterruptedException, IOException {
		
		Student student = new Student();
		
		try { 
			
			System.out.print ("\n Вводите данные так: ФАМИЛИЯ ИМЯ ОТЧЕСТВО ВОЗРАСТ ПОЛ КАРМАННЫЕ_ДЕНЬГИ СРЕДНЯЯ_ОЦЕНКА_ЗА_СЕССИЮ(формат x,y)\n "
			 				+ "\n Ваш ввод: \n");
		
			student.setSurname(in.next());
			student.setName(in.next());
			student.setPatronymic(in.next());
			student.setAge(in.nextInt());
			student.setSex(in.next());
			student.setMoney(in.nextInt());
			student.setAverageRatingSession(in.nextDouble());
		
			studentDataBase.add(student);
			student.setID(studentDataBase.indexOf(student) + 1);
		
			System.out.print ("\nДобавление данных успешно завершено.\n\n");
			Thread.sleep(2000);
			clearConsole();
		}
		
		catch (InputMismatchException ex) {
			
			in.next();
			System.out.print ("\n !!! Неверный ввод.\n");
			Thread.sleep(2000);
			callActionWithStudentDataBase();
		}

		return student;
	} 
	
	public static ExcellentStudent addExcellentStudentData(ArrayList<ExcellentStudent> excellentStudentDataBase) throws InputMismatchException, InterruptedException, IOException {
		
		ExcellentStudent excellentStudent = new ExcellentStudent();

		try { 
			
			System.out.print ("\n Вводите данные так: ФАМИЛИЯ ИМЯ ОТЧЕСТВО ВОЗРАСТ ПОЛ КАРМАННЫЕ_ДЕНЬГИ СРЕДНЯЯ_ОЦЕНКА_ЗА_СЕССИЮ(формат x,y)\n "
			 				+ "\n Ваш ввод: \n");

			excellentStudent.setSurname(in.next());
			excellentStudent.setName(in.next());
			excellentStudent.setPatronymic(in.next());
			excellentStudent.setAge(in.nextInt());
			excellentStudent.setSex(in.next());
			excellentStudent.setMoney(in.nextInt());
			excellentStudent.setAverageRatingSession(in.nextDouble());
		
			excellentStudentDataBase.add(excellentStudent);
			excellentStudent.setID(excellentStudentDataBase.indexOf(excellentStudent) + 1);
		
			System.out.print ("\nДобавление данных успешно завершено.");
			Thread.sleep(2000);
			clearConsole();
			
		}
		
		catch (InputMismatchException ex) {
			
			in.next();
			System.out.print ("\n !!! Неверный ввод.\n");
			Thread.sleep(2000);
			callActionWithExcellentStudentDataBase();
		}

		return excellentStudent;
	} 
	
	
	//Удаление данных в существующей БД
	public static void removeLecturerData(ArrayList<Lecturer> lecturerDataBase) throws InterruptedException, IOException {
		
		try {
			
			int id = 0;
		
			System.out.print("\nВведите ID записи, которую хотите удалить: ");
			id = in.nextInt();
		
			if (id <= 0 || id > lecturerDataBase.size()) {
				
				System.out.println("\n\n !!! Неверный ввод\n");
				Thread.sleep(2000);
				clearConsole();
			}
		
			else {
			
				lecturerDataBase.remove(id-1);
			
				for (int i = 0; i < lecturerDataBase.size(); i++)
					lecturerDataBase.get(i).setID(i + 1);
				
				System.out.print ("\nУдаление записи успешно завершено.");
				Thread.sleep(2000);
				clearConsole();
			}
		}
		
		catch (InputMismatchException ex) {
			
			in.next();
			System.out.print ("\n !!! Неверный ввод.\n");
			Thread.sleep(2000);
			callActionWithLecturerDataBase();
		}
	}
	
	public static void removeStudentData(ArrayList<Student> studentDataBase) throws InterruptedException, IOException {
		
		try { 
			
			int id = 0;
		
			System.out.print("\nВведите ID записи, которую хотите удалить: ");
			id = in.nextInt();
		
			if (id <= 0 || id > studentDataBase.size()) { 
				
				System.out.println("\n\n !!! Неверный ввод\n");
				Thread.sleep(2000);
				clearConsole();
			}
		
			else {
				
				studentDataBase.remove(id-1);
				
				for (int i = 0; i < studentDataBase.size(); i++)
					studentDataBase.get(i).setID(i + 1);
		
				System.out.print ("\nУдаление записи успешно завершено.");
				Thread.sleep(2000);
				clearConsole();
			}
		}
		
		catch (InputMismatchException ex) {
			
			in.next();
			System.out.print ("\n !!! Неверный ввод.\n");
			Thread.sleep(2000);
			callActionWithStudentDataBase();
		}
	}
	
	public static void removeCoolLecturerData(ArrayList<CoolLecturer> coolLecturerDataBase) throws InterruptedException, IOException {
		
		try {
			
			int id = 0;
		
			System.out.print("\nВведите ID записи, которую хотите удалить: ");
			id = in.nextInt();
		
			if (id <= 0 || id > coolLecturerDataBase.size()) {
				
				System.out.println("\n\n !!! Неверный ввод\n");
				Thread.sleep(2000);
				clearConsole();
			}
		
			else {
			
				coolLecturerDataBase.remove(id-1);
		
				for (int i = 0; i < coolLecturerDataBase.size(); i++)
					coolLecturerDataBase.get(i).setID(i + 1);
			
				System.out.print ("\nУдаление записи успешно завершено.");
				Thread.sleep(2000);
				clearConsole();
			}
		}
		
		catch (InputMismatchException ex) {
			
			in.next();
			System.out.print ("\n !!! Неверный ввод.\n");
			Thread.sleep(2000);
			callActionWithCoolLecturerDataBase();
		}
	}
	
	public static void removeExcellentStudentData(ArrayList<ExcellentStudent> excellentStudentDataBase) throws InterruptedException, IOException {
		
		try { 
			
			int id = 0;
		
			System.out.print("\nВведите ID записи, которую хотите удалить: ");
			id = in.nextInt();
		
			if (id <= 0 || id > excellentStudentDataBase.size()) {
				
				System.out.println("\n\n !!! Неверный ввод\n");
				Thread.sleep(2000);
				clearConsole();
			}
		
			else {
			
				excellentStudentDataBase.remove(id-1);
			
				for (int i = 0; i < excellentStudentDataBase.size(); i++)
					excellentStudentDataBase.get(i).setID(i + 1);
		
				System.out.print ("\nУдаление записи успешно завершено.");
				Thread.sleep(2000);
				clearConsole();
			}
		}
		
		catch (InputMismatchException ex) {
			
			in.next();
			System.out.print ("\n !!! Неверный ввод.\n");
			Thread.sleep(2000);
			callActionWithExcellentStudentDataBase();
		}
	}
	
	
	//Распределение по базам данных
	public static ArrayList<Lecturer> getToLecturerDataBase (ArrayList<Lecturer> lecturers){
		
		ArrayList<Lecturer> lecturersDataBase = new ArrayList<>();
		
		for (int i = 0; i < lecturers.size(); i++) {
			
			if (lecturers.get(i).getAverageRatingSession() < 5.0) {
				
				Lecturer lecturer = new Lecturer();
				
				lecturer.setSurname(lecturers.get(i).getSurname());
				lecturer.setName(lecturers.get(i).getName());
				lecturer.setPatronymic(lecturers.get(i).getPatronymic());
				lecturer.setAge(lecturers.get(i).getAge());
				lecturer.setSex(lecturers.get(i).getSex());
				lecturer.setMoney(lecturers.get(i).getMoney());
				lecturer.setAverageRatingSession(lecturers.get(i).getAverageRatingSession());
				
				lecturersDataBase.add(lecturer);
				lecturer.setID(lecturersDataBase.indexOf(lecturer) + 1);
			}
			
		}
		return lecturersDataBase;
	}
		
	public static ArrayList<Student> getToStudentDataBase (ArrayList<Student> students){ 
		
		ArrayList<Student> studentsDataBase = new ArrayList<>();
			
			for (int i = 0; i < students.size(); i++) {
				
				if (students.get(i).getAverageRatingSession() < 5.0) {
					
					Student student = new Student();
					
					student.setSurname(students.get(i).getSurname());
					student.setName(students.get(i).getName());
					student.setPatronymic(students.get(i).getPatronymic());
					student.setAge(students.get(i).getAge());
					student.setSex(students.get(i).getSex());
					student.setMoney(students.get(i).getMoney());
					student.setAverageRatingSession(students.get(i).getAverageRatingSession());
					
					studentsDataBase.add(student);
					student.setID(studentsDataBase.indexOf(student) + 1);
				}
				
			}
			return studentsDataBase;
			
		}
	
	public static ArrayList<CoolLecturer> getToCoolLecturerDataBase (ArrayList<Lecturer> lecturers){
		
		ArrayList<CoolLecturer> coolLecturersDataBase = new ArrayList<>();
		
		for (int i = 0; i < lecturers.size(); i++) {
			
			if (lecturers.get(i).getAverageRatingSession() == 5.0) {
				
				CoolLecturer coolLecturer = new CoolLecturer();
				
				coolLecturer.setSurname(lecturers.get(i).getSurname());
				coolLecturer.setName(lecturers.get(i).getName());
				coolLecturer.setPatronymic(lecturers.get(i).getPatronymic());
				coolLecturer.setAge(lecturers.get(i).getAge());
				coolLecturer.setSex(lecturers.get(i).getSex());
				coolLecturer.setMoney(lecturers.get(i).getMoney());
				coolLecturer.setAverageRatingSession(lecturers.get(i).getAverageRatingSession());
				
				coolLecturersDataBase.add(coolLecturer);
				coolLecturer.setID(coolLecturersDataBase.indexOf(coolLecturer) + 1);
			}
			
		}
		return coolLecturersDataBase;
	}
		
	public static ArrayList<ExcellentStudent> getToExcellentStudentDataBase (ArrayList<Student> students){
			
		ArrayList<ExcellentStudent> excellentStudentsDataBase = new ArrayList<>();
			
			for (int i = 0; i < students.size(); i++) {
				
				if (students.get(i).getAverageRatingSession() == 5.0) {
					
					ExcellentStudent excellentStudent = new ExcellentStudent();
					
					excellentStudent.setSurname(students.get(i).getSurname());
					excellentStudent.setName(students.get(i).getName());
					excellentStudent.setPatronymic(students.get(i).getPatronymic());
					excellentStudent.setAge(students.get(i).getAge());
					excellentStudent.setSex(students.get(i).getSex());
					excellentStudent.setMoney(students.get(i).getMoney());
					excellentStudent.setAverageRatingSession(students.get(i).getAverageRatingSession());
					
					excellentStudentsDataBase.add(excellentStudent);
					excellentStudent.setID(excellentStudentsDataBase.indexOf(excellentStudent) + 1);
				}
				
			}
			return excellentStudentsDataBase;
			
		}
		
	
	//Функция CreatePair
	public static void createPairForLecturers (ArrayList<Lecturer> lecturerDataBase, ArrayList<Student> studentDataBase) {
		
		//Если преподов столько же, сколько и студентов, или преподов меньше, чем студентов:
		if (lecturerDataBase.size() <= studentDataBase.size()) {
			
			for (int i = 0 ; i < lecturerDataBase.size(); i++) {
				
				lecturerDataBase.get(i).createPair(studentDataBase.get(i));
				
				System.out.println("\n" + line1 + "\nДля преподавателя: \n" + lecturerDataBase.get(i).toString()
						+ "\n\nПодобран студент: \n" + lecturerDataBase.get(i).getStudentForLecturer().toString() + "\n" + line1);	
			}
		}
		
		//Если преподов больше, чем студентов:
		if (lecturerDataBase.size() > studentDataBase.size()) {
			
			int i;
			
			for (i = 0 ; i < studentDataBase.size(); i++) {
				
				lecturerDataBase.get(i).createPair(studentDataBase.get(i));
				
				System.out.println("\n" + line1 + "\nДля преподавателя: \n" + lecturerDataBase.get(i).toString()
						+ "\n\nПодобран студент: \n" + lecturerDataBase.get(i).getStudentForLecturer().toString() + "\n" + line1);
			}
			
			System.out.println("\n" + line1 + "\nДля преподавателей: ");
			
			for (; i < lecturerDataBase.size(); i++)
				System.out.println(lecturerDataBase.get(i).toString()); 
			
			System.out.println("\nНе нашлось свободных студентов\n" + line1); 	
		}
	}
	
	public static void createPairForStudents (ArrayList<Lecturer> lecturerDataBase, ArrayList<Student> studentDataBase) {
		
		//Если студентов столько же, сколько и преподов, или меньше:
		if (lecturerDataBase.size() >= studentDataBase.size()) {
			
			for (int i = 0 ; i < studentDataBase.size(); i++) {
				
				studentDataBase.get(i).createPair(lecturerDataBase.get(i));
				
				System.out.println("\n" + line1 + "\nДля студента: \n" + studentDataBase.get(i).toString()
						+ "\n\nПодобран преподаватель: \n" + studentDataBase.get(i).getLecturerForStudent().toString() + "\n" + line1);	
			}
		}
		
		//Если студентов больше, чем преподов:
		if (lecturerDataBase.size() < studentDataBase.size()) {
			
			int i;
			
			for (i = 0 ; i < lecturerDataBase.size(); i++) {
				
				studentDataBase.get(i).createPair(lecturerDataBase.get(i));
				
				System.out.println("\n" + line1 + "\nДля студента: \n" + studentDataBase.get(i).toString()
						+ "\n\nПодобран преподаватель: \n" + studentDataBase.get(i).getLecturerForStudent().toString() + "\n" + line1);
			}
			
			System.out.println("\n" + line1 + "\nДля студентов: ");
			
			for (; i < studentDataBase.size(); i++)
				System.out.println(studentDataBase.get(i).toString()); 
			
			System.out.println("\nНе нашлось свободных преподавателей\n" + line1); 
		}
	}

	public static void createPairForCoolLecturers (ArrayList<CoolLecturer> coolLecturerDataBase, ArrayList<ExcellentStudent> excellentStudentDataBase) {
		
		//Если крутых преподов столько же, сколько и студентов-отличников, или крутых преподов меньше, чем студентов-отличников:
		if (coolLecturerDataBase.size() <= excellentStudentDataBase.size()) {
			
			for (int i = 0 ; i < coolLecturerDataBase.size(); i++) {
				
				coolLecturerDataBase.get(i).createPair(excellentStudentDataBase.get(i));
				
				System.out.println("\n" + line1 + "\nДля \"крутого\" преподавателя: \n" + coolLecturerDataBase.get(i).toString()
						+ "\n\nПодобран студент-отличник: \n" + coolLecturerDataBase.get(i).getExcellStudForCoolLectur().toString() + "\n" + line1);	
			}
		}
		
		//Если преподов больше, чем студентов:
		if (coolLecturerDataBase.size() > excellentStudentDataBase.size()) {
			
			int i;
			
			for (i = 0 ; i < excellentStudentDataBase.size(); i++) {
				
				coolLecturerDataBase.get(i).createPair(excellentStudentDataBase.get(i));
				
				System.out.println("\n" + line1 + "\nДля \"крутого\" преподавателя: \n" + coolLecturerDataBase.get(i).toString()
						+ "\n\nПодобран студент-отличник: \n" + coolLecturerDataBase.get(i).getExcellStudForCoolLectur().toString() + "\n" + line1);
			}
			
			System.out.println("\n" + line1 + "\nДля \"крутых\" преподавателей: ");
			
			for (; i < coolLecturerDataBase.size(); i++)
				System.out.println(coolLecturerDataBase.get(i).toString()); 
			
			System.out.println("\nНе нашлось свободных студентов-отличников\n" + line1); 
		}
	}

	public static void createPairForExcellentStudents (ArrayList<CoolLecturer> coolLecturerDataBase, ArrayList<ExcellentStudent> excellentStudentDataBase) {
		
		//Если студентов столько же, сколько и преподов, или меньше:
		if (coolLecturerDataBase.size() >= excellentStudentDataBase.size()) {
			
			for (int i = 0 ; i < excellentStudentDataBase.size(); i++) {
				
				excellentStudentDataBase.get(i).createPair(coolLecturerDataBase.get(i));
				
				System.out.println("\n" + line1 + "\nДля студента-отличника: \n" + excellentStudentDataBase.get(i).toString()
						+ "\n\nПодобран \"крутой\" преподаватель: \n" + excellentStudentDataBase.get(i).getCoolLecturerForExcellStudent().toString() + "\n" + line1);	
			}
		}
		
		//Если студентов больше, чем преподов:
		if (coolLecturerDataBase.size() < excellentStudentDataBase.size()) {
			
			int i;
			
			for (i = 0 ; i < coolLecturerDataBase.size(); i++) {
				
				excellentStudentDataBase.get(i).createPair(coolLecturerDataBase.get(i));
				
				System.out.println("\n" + line1 + "\nДля студента-отличника: \n" + excellentStudentDataBase.get(i).toString()
						+ "\n\nПодобран \"крутой\" преподаватель: \n" + excellentStudentDataBase.get(i).getCoolLecturerForExcellStudent().toString() + "\n" + line1);
			}
			
			System.out.println("\n" + line1 + "\nДля студентов-отличников: ");
			
			for (; i < excellentStudentDataBase.size(); i++)
				System.out.println(excellentStudentDataBase.get(i).toString()); 
			
			System.out.println("\nНе нашлось свободных \"крутых\" преподавателей\n" + line1); 
		}
	}

}
