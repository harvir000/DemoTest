package utilsPckg;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class XMLReader {
	
	String path = "";
	
	public XMLReader(String xmlPath)
	{
		path = xmlPath;
	}
	
	  public String readTagVal(String tagName)
	    {	
	    	String tagVal=null;
	        File file = new File(path);
	        try
	        {
	            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	            Document doc = builder.parse(file);
	            tagVal= doc.getElementsByTagName(tagName).item(0).getTextContent();
	        }
	        catch(Exception e)
	        {
	        	System.out.println("Could not get data from config.XML file for the tag "+tagName);
	        }
	        return tagVal;
	    }
	  
	  
}
