/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Core;

import Environment.Classes.Allergy;
import Environment.Classes.Disease;
import Environment.Classes.Equipment;
import Environment.Classes.ExerciseProfile;
import Environment.Classes.Medical;
import Environment.Classes.Personal;
import Environment.Classes.Profile;
import Environment.MainApplication;
import Environment.Models.LoginModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Rodriguez
 */
public class XMLGenerator {
    private LoginModel Model = new LoginModel();
    private String xmlFileName,directoryPath;
    private DocumentBuilderFactory icFactory = null;
    private DocumentBuilder icBuilder = null;
    
    public XMLGenerator(String xmlFileName,String directoryPath) {
        this.xmlFileName = xmlFileName;
        this.directoryPath = directoryPath;
    }

    public String jobXMLGenerator(ArrayList<Personal> jobList) {
        //Array list not used yet...jobs hard coded
        //xml
        Document doc = null;
        try {

            FileOutputStream fos = new FileOutputStream(directoryPath+File.separator+getXmlFileName());
            StreamResult xmlStreamSourceObject = new StreamResult(fos);

            icFactory = DocumentBuilderFactory.newInstance();
            icBuilder = icFactory.newDocumentBuilder();

            doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElement("ProfileInformation"); // doc.createElementNS();
            doc.appendChild(mainRootElement);

            // Append child elements to root element
            Profile myProfile = Model.GetProfile(MainApplication.profile.username);
            Personal personal1 = myProfile.personal;
            Medical medical1 = myProfile.medical;
            ExerciseProfile exerciseProfile1 = myProfile.exerciseProfile;
            
            mainRootElement.appendChild(getPersonal(doc, personal1, 1));
            mainRootElement.appendChild(getMedical(doc, medical1, 1));
            mainRootElement.appendChild(getExerciseProfile(doc, exerciseProfile1, 1));

            // Output DOM XML to xml file 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");

            DOMSource source = new DOMSource(doc);
            transformer.transform(source, xmlStreamSourceObject);

            System.out.println("\nXML DOM Created Successfully..");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlFileName;
    }

    public static void mergeMultipleXMLDocs(List<String> list, String jointXmlRootNode, String outName) {
        File in;

        //String xmlFileName;
        try {
            DocumentBuilderFactory dbFactory;
            DocumentBuilder dBuilder;

            Document mergedDoc;

            FileOutputStream fos = new FileOutputStream(outName);
            StreamResult xmlStreamSourceObject = new StreamResult(fos);

            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();

            mergedDoc = dBuilder.newDocument();
            Element mainRootElement = mergedDoc.createElement(jointXmlRootNode); // doc.createElementNS();
            mergedDoc.appendChild(mainRootElement);

            //Get Top Level Node
            for (String inFile : list) {
                in = new File(inFile);
                Document current_doc1 = dBuilder.parse(in);
                Node n = mergedDoc.importNode(current_doc1.getFirstChild(), true);
                mainRootElement.appendChild(n);
            }

            // Output DOM XML to xml file 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");

            DOMSource source = new DOMSource(mergedDoc);
            transformer.transform(source, xmlStreamSourceObject);

            System.out.println("The Merged xml is:");
            System.out.println(xmlDocToString(mergedDoc, "yes"));

        } catch (Exception e) {
        }
    }

    public static String xmlDocToString(Document doc, String omitXmlDeclaration)
            throws Exception {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            //
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, omitXmlDeclaration);
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            //
            StreamResult result = new StreamResult(new StringWriter());
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);
            String xmlString = result.getWriter().toString();
            return xmlString;
        } catch (Exception e) {
            e.printStackTrace();

            throw e;
        }
    }

    public Node getPersonal(Document doc, Personal personalObject, int id) {
        Element personalComponent = doc.createElement("PersonalComponent");
        // Top level attributes
        personalComponent.setAttribute("id", Integer.toString(id));

        // Personal subelements
	personalComponent.appendChild(getJobElements(doc, personalComponent, "firstname", personalObject.getFname()));
        personalComponent.appendChild(getJobElements(doc, personalComponent, "lastname", personalObject.getlName()));
        personalComponent.appendChild(getJobElements(doc, personalComponent, "address", personalObject.getAddress()));
        personalComponent.appendChild(getJobElements(doc, personalComponent, "city", personalObject.getCity()));
        personalComponent.appendChild(getJobElements(doc, personalComponent, "state", personalObject.getState()));
        personalComponent.appendChild(getJobElements(doc, personalComponent, "email", personalObject.getEmail()));
        personalComponent.appendChild(getJobElements(doc, personalComponent, "sex", personalObject.getSex()));
        return personalComponent;
    }
    
    public Node getMedical(Document doc, Medical medicalObject, int id) {
        Element medicalComponent = doc.createElement("MedicalComponent");
        // Top level attributes
        medicalComponent.setAttribute("id", Integer.toString(id));

        // Medical subelements
	medicalComponent.appendChild(getJobElements(doc, medicalComponent, "weight", medicalObject.getWeight()));
        medicalComponent.appendChild(getJobElements(doc, medicalComponent, "height", medicalObject.getHeightFt()));
        String listString_Disease = "";
        for (Disease d : medicalObject.diseaseList)
        {
            listString_Disease += d.toString() + "; ";
        }
        medicalComponent.appendChild(getJobElements(doc, medicalComponent, "disease", listString_Disease));
        String listString_Allergy = "";
        for (Allergy a : medicalObject.allergyList)
        {
            listString_Allergy += a.toString() + "; ";
        }
        medicalComponent.appendChild(getJobElements(doc, medicalComponent, "allergy", listString_Allergy));
        return medicalComponent;
    }
    
    public Node getExerciseProfile(Document doc, ExerciseProfile exerciseObject, int id) {
        Element exerciseComponent = doc.createElement("ExerciseComponent");
        // Top level attributes
        exerciseComponent.setAttribute("id", Integer.toString(id));

        // Exercise Equipment subelements
        String listString_Equipment = "";
        for (Equipment e : exerciseObject.equipmentList)
        {
            listString_Equipment += e.toString() + "; ";
        }
	exerciseComponent.appendChild(getJobElements(doc, exerciseComponent, "exercise", listString_Equipment));
        return exerciseComponent;
    }

    // utility method to create text node
    public Node getJobElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    /**
     * @return the xmlFileName
     */
    public String getXmlFileName() {
        return xmlFileName;
    }

    /**
     * @param xmlFileName the xmlFileName to set
     */
    public void setXmlFileName(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }
}
