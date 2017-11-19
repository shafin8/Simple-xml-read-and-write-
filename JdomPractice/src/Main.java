import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Text;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
 
public class Main {
	public static void main(String[] args) {
 
		 writeXML();
		
		readXML();
	}
	
	private static void readXML(){
		
		SAXBuilder builder = new SAXBuilder();
		try {
			
			// Parses the file supplied into a JDOM document
			
			Document readDoc = builder.build(new File("./src/jdomMade.xml"));
			
			// Returns the root element for the document
			
			//System.out.println("Title: " + readDoc.getRootElement());
			
			// Gets the text found between the name tags
			
			//System.out.println("Name: " + readDoc.getRootElement().getChild("show").getChildText("name"));
			
			// Gets the attribute value for show_id assigned to name
			
			//System.out.println(" ID: " + readDoc.getRootElement().getChild("show").getChild("name").getAttributeValue("show_id") + "\n");
		
			Element root = readDoc.getRootElement();
			
			// Cycles through all of the children in show and prints them
			
			for (Element curEle : root.getChildren("show")) {
				System.out.println("\n");
			  System.out.println("Name: " + curEle.getChildText("name"));
			  System.out.println("ID: " + curEle.getChild("name").getAttributeValue("show_id"));
			  System.out.print("University:  " + curEle.getChildText("network") +"\n" + "Address: ");
			  System.out.println(curEle.getChild("network").getAttributeValue("country") + "\n");
			}
			
		} 
		
		catch (JDOMException e) {
			e.printStackTrace();
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	private static void writeXML(){
	try{
		
		// Creates a JDOM document
		
		Document doc = new Document();
		
		
		
		Element theRoot = new Element("Address");
		doc.setRootElement(theRoot);
		
		
		
		Element show = new Element("show");
		Element name = new Element("name");
		
		// Assigns an attribute to name and gives it a value
		
		name.setAttribute("show_id", "1111111111111");
		
		// Adds text between the name tags
		
		name.addContent(new Text("Shafin"));
		
		Element network = new Element("network");
		
		network.addContent(new Text("NSU"));
		
		network.setAttribute("country", "Dhaka");
		
		// Adds name and network to the show tag
		
		show.addContent(name);
		show.addContent(network);
		
		// Adds the show tag and all of its children to the root
		
		theRoot.addContent(show);
		
		// Add a new show element like above
		
		Element show2 = new Element("show");
		
		Element name2 = new Element("name");
		
		name2.setAttribute("show_id", "2222222222");
		
		name2.addContent(new Text("Alex"));
		
		Element network2 = new Element("network");
		
		network2.addContent(new Text("NSU"));
		
		network2.setAttribute("country", "Dhaka");
		
		show2.addContent(name2);
		show2.addContent(network2);
		
		theRoot.addContent(show2);
		
		
		// Add a new show element like above
		
				Element show3 = new Element("show");
				
				Element name3 = new Element("name");
				
				name3.setAttribute("show_id", "33333333333");
				
				name3.addContent(new Text("Jiban"));
				
				Element network3 = new Element("network");
				
				network3.addContent(new Text("NSU"));
				
				network3.setAttribute("country", "Dhaka");
				
				show3.addContent(name3);
				show3.addContent(network3);
				
				theRoot.addContent(show3);
		
		
		// Uses indenting with pretty format
		
		XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
		
		// Create a new file and write XML to it
		
		xmlOutput.output(doc, new FileOutputStream(new File("./src/jdomMade.xml")));
		
		System.out.println("Wrote to file");
		
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
}

