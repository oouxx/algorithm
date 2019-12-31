package SimpleFactoryPattern;

import java.io.File;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

class XMLUtil{
    public static String getChartType(){
        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory;
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("config.xml"));

            NodeList nl = doc.getElementsByTagName("ChartType");
            Node classNode = nl.item(0).getFirstChild();
            String chartType = classNode.getNodeValue().trim();
            return chartType;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}