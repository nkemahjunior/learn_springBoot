package com.zeco.crudDemo;

import com.zeco.crudDemo.dao.StudentDAO;
import com.zeco.crudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){


		return  (runner) ->{
			//createStudent(studentDAO);
			SaveMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	public void deleteAllStudents(StudentDAO studentDAO){
		System.out.println("deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("deleted " + numRowsDeleted + " rows");
	}

	public void deleteStudent(StudentDAO studentDAO){
		int studentId = 3;
		System.out.println("deleting student: " + studentId);
		studentDAO.delete(studentId);
	}

	public void updateStudent(StudentDAO studentDAO){
		//retrieve student base on the id:primary key
		int studentId = 1;
		System.out.println("getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to scooby
		System.out.println("updating the student......");
		myStudent.setFirstName("scooby");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("updated student " + myStudent);
	}

	public void queryForStudentByLastName(StudentDAO studentDAO){
		List<Student>  theStudents = studentDAO.findByLastName("parafin");

		theStudents.forEach( (studs)->{
			System.out.println(studs);
		} );
	}


	public void queryForStudents(StudentDAO studentDAO){
		//get list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		theStudents.forEach( (stud)->{
			System.out.println(stud);
		} );
	}

	private void readStudent(StudentDAO studentDAO){
		//create a student object
		System.out.println("creatig a new student object");
		Student tempStudent = new Student("zeco","parafin","jj@gmail.com");

		//save the student
		System.out.println("saving the student");
		studentDAO.save(tempStudent);


		//display id of saved student
		int theId = tempStudent.getId();
		System.out.println("saved student. Generated id: " + theId);


		//retrieve student based on id : primary key
		System.out.println("retriving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);


		//display student
		System.out.println("found the student " + myStudent);
	}


	//creating this method to test the autoincrement feature of mysql
	private  void SaveMultipleStudents(StudentDAO studentDAO){
		//create the student object
		System.out.println("creating new student object.....");
		Student tempStudent = new Student("Zeco","junior","zeco@gmail.com");
		Student tempStudent2 = new Student("Zeco1","junior1","zeco@gmail.com");
		Student tempStudent3 = new Student("Zeco2","junior2","zeco@gmail.com");
		Student tempStudent4 = new Student("Zeco3","junior3","zeco@gmail.com");


		//save the student object
		System.out.println("saving the student....");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);


	}

	private void createStudent(StudentDAO studentDAO){
		//create the student object
		System.out.println("creating new student object.....");
		Student tempStudent = new Student("Zeco","junior","zeco@gmail.com");


		//save the student object
		System.out.println("saving the student....");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("saved student .generated id: "+ tempStudent.getId());
	}

	/* syntax 1
		return new CommandLineRunner() {
			@Override
			public void run(String[] args)  {
				System.out.println("hello world");
			}
		};*/

		/* syntax 2
		CommandLineRunner obj =  new CommandLineRunner() {
			@Override
			public void run(String[] args)  {
				System.out.println("hello world");
			}
		};

		return  obj;
		*/

	/*
	 * those two syntax are the same thing as that  lambda expression above inside that method boy
	 *
	 **/



}
