/**
 * ЗАДАНИЕ № 1.
	1. Разработать иерархию людей, начиная от общего понятия «Человек» (абстрактный класс):
		a. Слушатель
		b. Преподаватель
		c. Отличник
		d. Крутой преподаватель (ставит одни 5-ки)
	2. Переопределить для каждого класса метод toString, возвращающий соответствующее описание человека (имя, возраст, пол, карманные деньги, среднюю оценку за сессию)
	3. Cделать правильную реализацию метода CreatePair, создающего пару для данного человека по следующим правилам:
		a. По слушателю — преподавателя
		b. По отличнику — крутого преподавателя
	4. Разработать программу для демонстрации классов.*/

package lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import static lab2.Interfaces.*;	//Импортируем все статические константы и методы из класса Interfaces
import static lab2.FileWriterAndReader.*;

public class Demonstration {
	
	static Scanner in = new Scanner(System.in);
	public static final int numberOfLineBreaks = 22;
	
	private static ArrayList<Lecturer> lecturersFromFile = new ArrayList<>(10);
	private static ArrayList<Student> studentsFromFile = new ArrayList<>(10);
	
	private static ArrayList<Lecturer> lecturerDataBase = new ArrayList<>(10);
	private static ArrayList<Student> studentDataBase = new ArrayList<>(10);
	private static ArrayList<CoolLecturer> coolLecturerDataBase = new ArrayList<>(10);
	private static ArrayList<ExcellentStudent> excellentStudentDataBase = new ArrayList<>(10);
	
	
	public static void main (String[] args) throws InterruptedException, IOException, InputMismatchException {
		
		try {
			
			lecturersFromFile = FileWriterAndReader.readFromFileWithLectors();
			studentsFromFile = FileWriterAndReader.readFromFileWithStudents();
		}
		
		catch (IOException ex) {
			
			System.out.println("\n [Ошибка файла]");
		}
		
		System.out.println("\nОбнаружены базы данных студентов и преподавателей: " + UniversityStaff.getNameUniversity());
		
		while (true) {
			
			try {
				
				//Начало стартовой страницы
				callStartPage();
			}
		
			catch (InputMismatchException ex) {
				
				clearConsole();
				System.out.println("\n !!! Ошибка ввода - возврат в главное меню \n");
				in.next();
			}
		
			catch (IOException ex) {
			
				System.out.println("\n [Ошибка файла]");
			}
		}
	}
	
	public static void callStartPage () throws InterruptedException, IOException, InputMismatchException {
		
		System.out.print(startPageString);
		
		byte choose = in.nextByte();
		
		clearConsole();
		
		switch (choose) {
		
		case 1: 
			
			System.out.println("\nВывод файла lecturers: " + "\n" 
								+ headerDataBaseString + lecturersFromFile.toString().replace("[", "").replace(",", "").replace("]", "") + "\n" + line2 + "\n");
			
			clearConsoleForPrintData(numberOfLineBreaks);
			break;
		
		case 2:
			
			System.out.println("\nВывод файла students: " + "\n" 
								+ headerDataBaseString + studentsFromFile.toString().replace("[", "").replace(",", "").replace("]", "") + "\n" + line2 + "\n");
			
			clearConsoleForPrintData(numberOfLineBreaks);
			break;
		
		case 3:
			
			lecturerDataBase = getToLecturerDataBase(lecturersFromFile);
			studentDataBase = getToStudentDataBase(studentsFromFile);
			coolLecturerDataBase = getToCoolLecturerDataBase(lecturersFromFile);
			excellentStudentDataBase = getToExcellentStudentDataBase(studentsFromFile);
			
			System.out.println ("\nУспешно создано 4 массива данных: lecturerDataBase, studentDataBase, coolLecturerDataBase, excellentStudentDataBase");
			clearConsoleForPrintData(numberOfLineBreaks);
			
			Thread.sleep(2000);
			callDatabaseFileSelection();
			
			break;
			
		case 4:
			
			if (lecturerDataBase.size() == 0) 
				System.out.println ("\n !!! Массивы данных ещё не были созданы\n");
			else 
				callDatabaseFileSelection();
			break;
		
		case 0:
			System.out.println("\nВыход из программы");
			System.exit(0);
			break;
		
		default: 
			System.out.println("\nПовторите попытку ввода");
		}
		
		
	}
	
	public static void callDatabaseFileSelection () throws InterruptedException, IOException, InputMismatchException {
		
		clearConsole();
		System.out.print(Interfaces.databaseFileSelectionString);
		byte choose = in.nextByte();	
		
		switch(choose) {
		
		case 1:
			callActionWithLecturerDataBase();
			break;
			
		case 2:
			callActionWithStudentDataBase();
			break;
			
		case 3:
			callActionWithCoolLecturerDataBase();
			break;
			
		case 4:
			callActionWithExcellentStudentDataBase();
			break;
		
		case 8:
			clearConsole();
			callStartPage();
			break;
			
		case 0:
			System.out.println("\nВыход из программы");
			System.exit(0);
		}
	}
	
	
	
	public static void callActionWithLecturerDataBase () throws InterruptedException, IOException, InputMismatchException {
		
		int numberOfLineBreaks = 21;
		boolean whileFlag = true;
		
		clearConsole();
		
		while (whileFlag) {
			
			System.out.print("Выбран массив lecturerDataBase --- Преподаватели\n");
			System.out.print(actionWithDatabaseFile);
			byte choose = in.nextByte();
			
			clearConsole();
			
			switch(choose) {
		
			case 1: //Вывод данных на экран
				
				if (lecturerDataBase.size() == 0) 
					System.out.println ("\n !!! Массив lecturerDataBase --- Преподаватели не содержит никаких данных \n");
				
				else {
					
					System.out.println("\nВывод массива lecturerDataBase --- Преподаватели с типом данных: " + lecturerDataBase.get(0).getClass().getSimpleName() + "\n"
										+ headerDataBaseString + lecturerDataBase.toString().replace("[", "").replace(",", "").replace("]", "") + "\n" + line2 + "\n");
					clearConsoleForPrintData(numberOfLineBreaks);
				}
				
				break;
			
			case 2:	//Добавление в массив
				
				addLecturerData(lecturerDataBase);
				
				if (numberOfLineBreaks > 0)
					numberOfLineBreaks--;
				
				break;
				
			case 3:	//Удаление из массива
				
				if (lecturerDataBase.size() == 0) 
					System.out.println ("\n !!! Массив lecturerDataBase --- Преподаватели не содержит никаких данных \n");
				
				else {
					
					System.out.println(headerDataBaseString + lecturerDataBase.toString().replace("[", "").replace(",", "").replace("]", "") + "\n" + line2 + "\n");
				
					clearConsoleForPrintData(numberOfLineBreaks);
					removeLecturerData(lecturerDataBase);
				
					if (numberOfLineBreaks < 21)
						numberOfLineBreaks++;
				}
				
				break;
				
			case 4:	//Метод CreatePair
				
				if (lecturerDataBase.size() == 0) 
					System.out.println ("\n !!! Массив lecturerDataBase --- Преподаватели не содержит никаких данных \n");
				
				else {
					
					if (studentDataBase.size() == 0) 
						System.out.println ("\n !!! Массив studentDataBase --- Студенты не содержит никаких данных" 
											+ "\n Применение CreatePair невозможно");

					else 
						createPairForLecturers(lecturerDataBase, studentDataBase);
				}
				
				break;
				
			case 5:	//Запись в файл
				
				if (lecturerDataBase.size() == 0) 
					System.out.println ("\n !!! Массив lecturerDataBase --- Преподаватели не содержит никаких данных \n");
				
				else
					writeLectorersToFile(lecturerDataBase);
				
				break;
			
			case 8:
				
				whileFlag = false;
				
				callDatabaseFileSelection();
				
				break;
				
			case 0:
				
				System.out.println("\nВыход из программы");
				System.exit(0);
				
				break;
			}
		}
	}
	
	public static void callActionWithStudentDataBase () throws InterruptedException, IOException {
		
		int numberOfLineBreaks = 21;
		boolean whileFlag = true;
		
		clearConsole();
		
		while (whileFlag) {
			
			System.out.print("Выбран массив studentDataBase --- Студенты\n");
			System.out.print(actionWithDatabaseFile);
			byte choose = in.nextByte();
			
			clearConsole();
			
			switch(choose) {
		
			case 1: //Вывод данных на экран
				
				if (studentDataBase.size() == 0) 
					System.out.println ("\n !!! Массив studentDataBase --- Студенты не содержит никаких данных \n");
				
				else {
					
					System.out.println("\nВывод массива studentDataBase --- Студенты с типом данных: " + studentDataBase.get(0).getClass().getSimpleName() + "\n"
										+ headerDataBaseString + studentDataBase.toString().replace("[", "").replace(",", "").replace("]", "") + "\n" + line2 + "\n");
					clearConsoleForPrintData(numberOfLineBreaks);
				}
				
				break;
			
			case 2:	//Добавление в массив
				
				addStudentData(studentDataBase);
				
				if (numberOfLineBreaks > 0)
					numberOfLineBreaks--;
				
				break;
				
			case 3:	//Удаление из массива
				
				if (studentDataBase.size() == 0) 
					System.out.println ("\n !!! Массив studentDataBase --- Студенты не содержит никаких данных \n");
				
				else {
					
					System.out.println(headerDataBaseString + studentDataBase.toString().replace("[", "").replace(",", "").replace("]", "") + "\n" + line2 + "\n");
				
					clearConsoleForPrintData(numberOfLineBreaks);
					removeStudentData(studentDataBase);
				
					if (numberOfLineBreaks < 21)
						numberOfLineBreaks++;
				}
				
				break;
				
			case 4:	//Метод CreatePair
				
				if (studentDataBase.size() == 0) 
					System.out.println ("\n !!! Массив studentDataBase --- Студенты не содержит никаких данных \n");
				
				else {
					
					if (lecturerDataBase.size() == 0) 
						System.out.println ("\n !!! Массив lecturerDataBase --- Преподаватели не содержит никаких данных" 
											+ "\n Применение CreatePair невозможно");

					else 
						createPairForStudents(lecturerDataBase, studentDataBase);
				}
				
				break;
				
			case 5:	//Запись в файл
				
				if (studentDataBase.size() == 0) 
					System.out.println ("\n !!! Массив studentDataBase --- Студенты не содержит никаких данных \n");
				
				else
					writeStudentsToFile(studentDataBase);
				
				break;
			
			case 8:
				
				whileFlag = false;
				
				callDatabaseFileSelection();
				
				break;
				
			case 0:
				
				System.out.println("\nВыход из программы");
				System.exit(0);
				
				break;
			}
		}
	}
	
	public static void callActionWithCoolLecturerDataBase () throws InterruptedException, IOException {
		
		int numberOfLineBreaks = 21;
		boolean whileFlag = true;
		
		clearConsole();
		
		while (whileFlag) {
			
			System.out.print("Выбран массив CoolLecturerDataBase --- \"Крутые\" преподаватели\n");
			System.out.print(actionWithDatabaseFile);
			byte choose = in.nextByte();
			
			clearConsole();
			
			switch(choose) {
		
			case 1: //Вывод данных на экран
				
				if (coolLecturerDataBase.size() == 0) 
					System.out.println ("\n !!! Массив CoolLecturerDataBase --- \"Крутые\" преподаватели не содержит никаких данных \n");
				
				else {
					
					System.out.println("\nВывод массива CoolLecturerDataBase --- \"Крутые\" преподаватели с типом данных: " + coolLecturerDataBase.get(0).getClass().getSimpleName() + "\n"
										+ headerDataBaseString + coolLecturerDataBase.toString().replace("[", "").replace(",", "").replace("]", "") + "\n" + line2 + "\n");
					clearConsoleForPrintData(numberOfLineBreaks);
				}
				
				break;
			
			case 2:	//Добавление в массив
				
				addCoolLecturerData(coolLecturerDataBase);
				
				if (numberOfLineBreaks > 0)
					numberOfLineBreaks--;
				
				break;
				
			case 3:	//Удаление из массива
				
				if (coolLecturerDataBase.size() == 0) 
					System.out.println ("\n !!! Массив CoolLecturerDataBase --- \"Крутые\" преподаватели не содержит никаких данных \n");
				
				else {
					
					System.out.println(headerDataBaseString + coolLecturerDataBase.toString().replace("[", "").replace(",", "").replace("]", "") + "\n" + line2 + "\n");
				
					clearConsoleForPrintData(numberOfLineBreaks);
					removeCoolLecturerData(coolLecturerDataBase);
				
					if (numberOfLineBreaks < 22)
						numberOfLineBreaks++;
				}
				
				break;
				
			case 4:	//Метод CreatePair
				
				if (coolLecturerDataBase.size() == 0) 
					System.out.println ("\n !!! Массив CoolLecturerDataBase --- \"Крутые\" преподаватели не содержит никаких данных \n");
				
				else {
					
					if (excellentStudentDataBase.size() == 0) 
						System.out.println ("\n !!! Массив excellentStudentDataBase --- Студенты-отличники не содержит никаких данных" 
											+ "\n Применение CreatePair невозможно");

					else 
						createPairForCoolLecturers(coolLecturerDataBase, excellentStudentDataBase);
				}
				
				break;
				
			case 5:	//Запись в файл
				
				if (coolLecturerDataBase.size() == 0) 
					System.out.println ("\n !!! Массив CoolLecturerDataBase --- \"Крутые\" преподаватели не содержит никаких данных \n");
				
				else
					writeCoolLectorersToFile(coolLecturerDataBase);
				
				break;
			
			case 8:
				
				whileFlag = false;
				
				callDatabaseFileSelection();
				
				break;
				
			case 0:
				
				System.out.println("\nВыход из программы");
				System.exit(0);
				
				break;
			}
		}	
	}
	
	public static void callActionWithExcellentStudentDataBase () throws InterruptedException, IOException {
		
		int numberOfLineBreaks = 21;
		boolean whileFlag = true;
		
		clearConsole();
		
		while (whileFlag) {
			
			System.out.print("Выбран массив excellentStudentDataBase --- Студенты-отличники\n");
			System.out.print(actionWithDatabaseFile);
			byte choose = in.nextByte();
			
			clearConsole();
			
			switch(choose) {
		
			case 1: //Вывод данных на экран
				
				if (excellentStudentDataBase.size() == 0) 
					System.out.println ("\n !!! Массив excellentStudentDataBase --- Студенты-отличники не содержит никаких данных \n");
				
				else {
					
					System.out.println("\nВывод массива excellentStudentDataBase --- Студенты-отличники с типом данных: " + excellentStudentDataBase.get(0).getClass().getSimpleName() + "\n"
										+ headerDataBaseString + excellentStudentDataBase.toString().replace("[", "").replace(",", "").replace("]", "") + "\n" + line2 + "\n");
					clearConsoleForPrintData(numberOfLineBreaks);
				}
				
				break;
			
			case 2:	//Добавление в массив
				
				addExcellentStudentData(excellentStudentDataBase);
				
				if (numberOfLineBreaks > 0)
					numberOfLineBreaks--;
				
				break;
				
			case 3:	//Удаление из массива
				
				if (excellentStudentDataBase.size() == 0) 
					System.out.println ("\n !!! Массив excellentStudentDataBase --- Студенты-отличники не содержит никаких данных \n");
				
				else {
					
					System.out.println(headerDataBaseString + excellentStudentDataBase.toString().replace("[", "").replace(",", "").replace("]", "") + "\n" + line2 + "\n");
				
					clearConsoleForPrintData(numberOfLineBreaks);
					removeExcellentStudentData(excellentStudentDataBase);
				
					if (numberOfLineBreaks < 22)
						numberOfLineBreaks++;
				}
				
				break;
				
			case 4:	//Метод CreatePair
				
				if (excellentStudentDataBase.size() == 0) 
					System.out.println ("\n !!! Массив excellentStudentDataBase --- Студенты-отличники не содержит никаких данных \n");
				
				else {
					
					if (coolLecturerDataBase.size() == 0) 
						System.out.println ("\n !!! Массив CoolLecturerDataBase --- \"крутые\" преподаватели не содержит никаких данных" 
											+ "\n Применение CreatePair невозможно");

					else 
						createPairForExcellentStudents(coolLecturerDataBase, excellentStudentDataBase);
				}
				
				break;
				
			case 5:	//Запись в файл
				
				if (excellentStudentDataBase.size() == 0) 
					System.out.println ("\n !!! Массив excellentStudentDataBase --- Студенты-отличники не содержит никаких данных \n");
				
				else
					writeExcellentStudentsToFile(excellentStudentDataBase);
				
				break;
			
			case 8:
				
				whileFlag = false;
				
				callDatabaseFileSelection();
				
				break;
				
			case 0:
				
				System.out.println("\nВыход из программы");
				System.exit(0);
				
				break;
			}
		}
	}	

}