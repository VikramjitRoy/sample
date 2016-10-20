package com.mindtree.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import com.mindtree.entity.Student;

public class Deserialization {

	public static void main(String[] args) throws IOException,ClassNotFoundException{
		// TODO Auto-generated method stub
		ArrayList<Student> empList = new ArrayList<Student>();
		try
		{
			FileInputStream filein = new FileInputStream("employeeList.ser");
			ObjectInputStream objStream = new ObjectInputStream(filein);
			empList=(ArrayList<Student>) objStream.readObject();
			for(Student std:empList)
			{
				System.out.println(std.toString());
			}
		}catch(IOException |ClassNotFoundException c)
		{
			System.out.println("Following error occurred:"+c);
		}
	}

}
