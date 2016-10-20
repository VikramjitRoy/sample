package com.mindtree.entity;
import java.lang.reflect.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.mindtree.annotation.*;
public class ApplicationMain 
{
	static String tableName;
	static int id=0;
	static String name1=null;
    static Date d=null;
	static String[] name=new String[10];
	static String[] type=new String[10];
	static int i=0;
	
    public static void main(String[] args)
    {
    	try
    	{
    		Employee empObj=null;
        	@SuppressWarnings("resource")
			Scanner sc=new Scanner(System.in);
        	ApplicationMain amObj=new ApplicationMain();
        	amObj.parse();
            String g="Create table "+tableName+"("+name[0]+" ("+type[0]
            		+"),"+name[1]+" ("+type[1]+"),"+name[2]+" ("+type[2]+"))";
            System.out.println(g);
            System.out.println("Press 1 to insert");
            System.out.println("Press 2 to update");
            System.out.println("Press 3 to exit");
            int flag=sc.nextInt();
            if(flag==1)
            {
            	try
            	{
            		System.out.println("Enter id: ");
                	int id=sc.nextInt();
                	sc.nextLine();
                	System.out.println("Enter Employee Name: ");
                	String name=sc.nextLine();
                	System.out.println("Enter hire date: ");
                	while(true)
                	{
                		try
                    	{
                    		String date=sc.nextLine();
                    		SimpleDateFormat d=new SimpleDateFormat("dd-mm-yyyy");
                    		Date d1=new Date();
                    		d1=d.parse(date);
                    		empObj=new Employee(id,name,d1);
                    		amObj.insert(empObj);
                    		break;
                    	}
                    	catch(Exception e)
                    	{
                    		
                    		System.out.println("Format is: dd-mm-yyyy");
                    		System.out.println("Enter again");
                    	}
                	}
                	

            	}
            	catch(Exception e)
            	{
            		System.out.println("Invalid data");
            	}
            }
            else if(flag==2)
            {
            	try
            	{
            		System.out.println("Enter id: ");
                	int id=sc.nextInt();
                	sc.nextLine();
                	System.out.println("Enter Employee Name: ");
                	String name=sc.nextLine();
                	System.out.println("Enter hire date: ");
                	while(true)
                	{
                		try
                    	{
                    		String date=sc.nextLine();
                    		SimpleDateFormat d=new SimpleDateFormat("dd-mm-yyyy");
                    		Date d1=new Date();
                    		d1=d.parse(date);
                    		empObj=new Employee(id,name,d1);
                    		amObj.update(empObj);
                    		break;
                    	}
                    	catch(Exception e)
                    	{
                    		System.out.println(e.getMessage());
                    		System.out.println("Format is: dd-mm-yyyy");
                    		System.out.println("Enter again");
                    	}
                	}
                	
                	
            	}
            	catch(Exception e)
            	{
            		System.out.println("Invalid data");
            	}
            }
            else if(flag==3)
            {
            	System.exit(0);
            }
            else
            {
            	System.out.println("Invalid entry");
            }
    	}
    	catch(Exception e)
    	{
    		System.out.println("Invalid input");
    	}
    }
    public void parse()
    {
    	Class<Employee> c1 = Employee.class;
    	Table t1 = c1.getAnnotation(Table.class);
    	tableName=t1.name();
   	
    	try
    	{
    		for(Method method:c1.getDeclaredMethods())
    		{
    			if(method.isAnnotationPresent(Column.class))
    			{
    				try
    				{
    					Column c=method.getAnnotation(Column.class);
    					if(c.name()!=null)
    					{
    						//System.out.println(c.name());
    						//System.out.println(c.type());
    						name[i]=c.name();
    						type[i]=c.type();
    						i++;
      					}
    					
    				}
    				catch(Exception e)
    				{
    					System.out.println(e.getMessage());
    				}
    			}
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
    	
    }
    public void insert(Employee e)
    {
    	
    	
    	Class<Employee> c1 = Employee.class;
    	//System.out.println(c1.getMethods());
    	for(Method method:c1.getDeclaredMethods())
		{
    		if(method.isAnnotationPresent(Column.class))
			{
				try
				{
					
					Column c=method.getAnnotation(Column.class);
					if(c.name().equals("EMP_ID"))
					{
						id=e.getEmployeeId();
					}
					if(c.name().equals("EMP_NAME"))
					{
						name1=e.getEmployeeName();
					}
					if(c.name().equals("HIRE_DATE"))
					{
						d=e.getHireDate();
					}
					//System.out.println(e.getEmployeeId());
					
					
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		}
    	String q="insert into "+tableName+"("+name[0]+" ("+type[0]
    			+"),"+name[1]+" ("+type[1]+"),"+name[2]+" ("+type[2]+")values("
    			+id+",'"+name1+"','"+d+"')";
    	System.out.println(q);
    }
    public void update(Employee e)
    {
    	
    	
    	Class<Employee> c1 = Employee.class;
    	//System.out.println(c1.getMethods());
    	for(Method method:c1.getDeclaredMethods())
		{
    		if(method.isAnnotationPresent(Column.class))
			{
				try
				{
					
					Column c=method.getAnnotation(Column.class);
					if(c.name().equals("EMP_ID"))
					{
		 				id=e.getEmployeeId();
					}
					if(c.name().equals("EMP_NAME"))
					{
						name1=e.getEmployeeName();
					}
					if(c.name().equals("HIRE_DATE"))
					{
						d=e.getHireDate();
					}
					//System.out.println(e.getEmployeeId());
					
					
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		}
    	String q="update "+tableName+" set "+name[0]+"='"+name1+"',"
		+name[2]+"='"+d+"' where "+name[0]+"="+id+"";
    	System.out.println(q);
    }
    
    
    
}
