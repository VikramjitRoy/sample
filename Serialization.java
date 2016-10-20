package com.mindtree.client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.mindtree.entity.Student;

/**
 * @author M1037743
 * 
 */
public class Serialization {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub			
		ArrayList<Student> studentList = new ArrayList<Student>();
		serialize(studentList);
		System.out.println("Object has been written into a file");
	}

	/**
	 * 
	 * @param studentList
	 * @throws IOException
	 * returns an arraylist of students
	 * @since 13th October
	 */
	
	public static void serialize(ArrayList<Student> studentList) throws IOException
	{
		try{
			Student std1=new Student(1, "Rahul", 78);
			studentList.add(std1);
			Student std2=new Student(9,"Supratim",87);
			studentList.add(std2);
			Student std3=new Student(5, "Aranya", 85);
			studentList.add(std3);
			FileOutputStream fout=new FileOutputStream("employeeList.ser");
			ObjectOutputStream objStream = new ObjectOutputStream(fout);
			objStream.writeObject(studentList);
			fout.close();
			objStream.close();
		}catch(IOException e){
			throw new IOException("Exception occurred!!");
		}
	}

}
