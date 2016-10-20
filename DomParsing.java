package MainApp;

import java.io.File;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParsing 
{
   public static void main(String[] args)
   {
	   try
	   {
		   File file=new File("Book.xml");
		   DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
		   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		   Document doc=dBuilder.parse(file);
		   doc.getDocumentElement().normalize();
		   System.out.println("Root element: "+doc.getDocumentElement().getNodeName()); 
		   NodeList node=doc.getElementsByTagName("book");
		   for(int i=0;i<node.getLength();i++)
		   {
			   Node n=node.item(i);
			   Element eleObj=(Element)n;
			   System.out.println("Book id: "+eleObj.getAttribute("id"));
			   System.out.println("Book title: "+eleObj.getElementsByTagName("title").item(0).getTextContent());
			   System.out.println("Author Name: "+eleObj.getElementsByTagName("author").item(0).getTextContent());
			   System.out.println("Price: "+eleObj.getElementsByTagName("price").item(0).getTextContent());
		   }
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
   }
}
