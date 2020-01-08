import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;

public class XMLUtil{
    public static Object getBean(String args){
        try{
            DocumentBuilderFactory dFactory = DocumentBuilderFactory;
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("config.xml"));
            NodelList nl = null;
            String cName = null;
            nl = doc.getElementsByTagName("className");
            if(args.equals("image")){
                classNode = nl.item(0).getFirstChild();
            }else if(args.equals("os")){
                classNode = nl.item(1).getFirstChild();
            }
            cName = classNode.getNodeValue();
            Class c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
