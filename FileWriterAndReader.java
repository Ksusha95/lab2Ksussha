package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static lab2.Interfaces.clearConsole;

public class FileWriterAndReader {
	
	//Чтение из файла
	public static ArrayList<Lecturer> readFromFileWithLectors() throws IOException {
		// открываем файл
		BufferedReader reader = new BufferedReader(new FileReader(File.separator+"home"+File.separator+"ksussha"+File.separator+"lecturers.csv"));
		 
		// считываем построчно
		String line = null;
		String data;
		
		int lineNumber = 0;
		int wordIndex = 0;
		
		Scanner scanner = null;
		ArrayList<Lecturer> lecturerDataBase = new ArrayList<>();
		 
		while ((line = reader.readLine()) != null) {
			
			Lecturer lecturer = new Lecturer();
		    scanner = new Scanner(line);
		    scanner.useDelimiter(",");
		            
		    while (scanner.hasNext()) {
		                
		    	data = scanner.next();
		    	
		    	if (lineNumber == 0) 
			    	UniversityStaff.setNameUniversity(data);
		    	
		    	else if (lineNumber > 1) {
		    		
		    		switch (wordIndex) {
		    		
		    			case 0: 
		    				lecturer.setSurname(data);
		    				break;
		        
		    			case 1:
		    				lecturer.setName(data);
		    				break;
		        
		    			case 2:
		    				lecturer.setPatronymic(data);
		    				break;
		                
		    			case 3:
		    				lecturer.setAge(Integer.parseInt(data));
		    				break;
		    	
		    			case 4:
		    				lecturer.setSex(data);
		    				break;
		         
		    			case 5:
		    				lecturer.setMoney(Integer.parseInt(data));
		    				break;
		    	
		    			case 6:
		    				lecturer.setAverageRatingSession(Double.parseDouble(data));
		    				break;
		    	
		    			default:
		    				System.out.println("Некорректные данные:" + data);
		    				break;
		    		}
		    		
		    		wordIndex++;
		    	}
		    }        
		    
		    wordIndex = 0;
		    
		    if (lineNumber == 0 || lineNumber == 1) ;
		    
		    else {
		   
		    	lecturerDataBase.add(lecturer);
		    	lecturer.setID(lecturerDataBase.indexOf(lecturer) + 1);
		    }
		    
		    lineNumber++;
		}
		         
		//закрываем ридер
		reader.close();
		
		return lecturerDataBase;
		         
	}
	
	
	public static ArrayList<Student> readFromFileWithStudents() throws IOException {
		// открываем файл
		BufferedReader reader = new BufferedReader(new FileReader(File.separator+"home"+File.separator+"ksussha"+File.separator+"students.csv"));
		 
		// считываем построчно
		String line = null;
		String data;
		
		int lineNumber = 0;
		int wordIndex = 0;
		
		Scanner scanner = null;
		ArrayList<Student> studentDataBase = new ArrayList<>();
		 
		while ((line = reader.readLine()) != null) {
			
			Student student = new Student();
		    scanner = new Scanner(line);
		    scanner.useDelimiter(",");
		            
		    while (scanner.hasNext()) {
		                
		    	data = scanner.next();
		    	
		    	if (lineNumber == 0) 
			    	UniversityStaff.setNameUniversity(data);
		    	
		    	else if (lineNumber > 1) {
		    		
		    		switch (wordIndex) {
		    		
		    			case 0: 
		    				student.setSurname(data);
		    				break;
		        
		    			case 1:
		    				student.setName(data);
		    				break;
		        
		    			case 2:
		    				student.setPatronymic(data);
		    				break;
		                
		    			case 3:
		    				student.setAge(Integer.parseInt(data));
		    				break;
		    	
		    			case 4:
		    				student.setSex(data);
		    				break;
		         
		    			case 5:
		    				student.setMoney(Integer.parseInt(data));
		    				break;
		    	
		    			case 6:
		    				student.setAverageRatingSession(Double.parseDouble(data));
		    				break;
		    	
		    			default:
		    				System.out.println("Некорректные данные:" + data);
		    				break;
		    		}
		    		
		    	wordIndex++;
		    	}
		    }        
		    
		    wordIndex = 0;
		    
		    if (lineNumber == 0 || lineNumber == 1) ;
		    
		    else {
		  
		    	studentDataBase.add(student);
		    	student.setID(studentDataBase.indexOf(student) + 1);
		    }
		    
		    lineNumber++;   
		}
		         
		//закрываем ридер
		reader.close();
		
		return studentDataBase;
		         
	}


	//Запись в файл
	public static void writeLectorersToFile(ArrayList<Lecturer> lecturerDataBase) throws IOException, InterruptedException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(File.separator + "home" + File.separator+ "ksussha" + File.separator + "lecturerDataBase.csv"));
		
		Lecturer [] lecturerArr = new Lecturer[lecturerDataBase.size()];
		lecturerDataBase.toArray(lecturerArr);
		
		oos.writeObject(Arrays.toString(lecturerArr).replace("[", "").replace(",", "").replace("]", ""));
		
		oos.close();
		System.out.println("\n Данные класса " + lecturerDataBase.get(0).getClass().getSimpleName() + " успешно записаны в файл lecturerDataBase.csv");
		Thread.sleep(2000);
		clearConsole();
	}
	
	
	public static void writeStudentsToFile(ArrayList<Student> studentDataBase) throws IOException, InterruptedException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(File.separator + "home" + File.separator+ "ksussha" + File.separator + "studentDataBase.csv"));
		
		Student [] studentArr = new Student[studentDataBase.size()];
		studentDataBase.toArray(studentArr);
		
		oos.writeObject(Arrays.toString(studentArr).replace("[", "").replace(",", "").replace("]", ""));
		
		oos.close();
		System.out.println("\n Данные класса " + studentDataBase.get(0).getClass().getSimpleName() + " успешно записаны в файл studentDataBase.csv");
		Thread.sleep(2000);
		clearConsole();
	}

	
	public static void writeCoolLectorersToFile(ArrayList<CoolLecturer> coolLecturerDataBase) throws IOException, InterruptedException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(File.separator + "home" + File.separator+ "ksussha" + File.separator + "coolLecturerDataBase.csv"));
		
		CoolLecturer [] coolLecturerArr = new CoolLecturer[coolLecturerDataBase.size()];
		coolLecturerDataBase.toArray(coolLecturerArr);
		
		oos.writeObject(Arrays.toString(coolLecturerArr).replace("[", "").replace(",", "").replace("]", ""));
		
		oos.close();
		System.out.println("\n Данные класса " + coolLecturerDataBase.get(0).getClass().getSimpleName() + " успешно записаны в файл lecturerDataBase.csv");
		Thread.sleep(2000);
		clearConsole();
	}

	
	public static void writeExcellentStudentsToFile(ArrayList<ExcellentStudent> excellentStudentDataBase) throws IOException, InterruptedException {
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(File.separator + "home" + File.separator+ "ksussha" + File.separator + "excellentStudentDataBase.csv"));
		
		ExcellentStudent [] excellentStudentArr = new ExcellentStudent[excellentStudentDataBase.size()];
		excellentStudentDataBase.toArray(excellentStudentArr);
		
		oos.writeObject(Arrays.toString(excellentStudentArr).replace("[", "").replace(",", "").replace("]", ""));
		
		oos.close();
		System.out.println("\n Данные класса " + excellentStudentDataBase.get(0).getClass().getSimpleName() + " успешно записаны в файл studentDataBase.csv");
		Thread.sleep(2000);
		clearConsole();
	}
}