/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile.Converter;

import java.io.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author MQ0162246
 */
public class XML2HTML {

    private String xmlFileName;
    private String xslFileName;
    private String htmlFileName;

    // constructors

    public XML2HTML(String xmlFileName, String xslFileName, String htmlFileName) {
        this.xmlFileName = xmlFileName;
        this.xslFileName = xslFileName;
        this.htmlFileName = htmlFileName;

    }

    public String convert2Html(String xmlFileName, String xslFileName, String htmlFileName, String folderPath) {
        try {
            // Obtain transformer object
            TransformerFactory tFactory = TransformerFactory.newInstance();

            // Get a stream sources / results
            // xsl
            StreamSource xslStreamSourceObject = new StreamSource(xslFileName);

            //xml
            StreamSource xmlStreamSourceObject = new StreamSource(xmlFileName);
            
            //html
            FileOutputStream fos = new FileOutputStream(folderPath+File.separator+htmlFileName);
            StreamResult htmlStreamSourceObject = new StreamResult(fos);

            //Transform & results
            Transformer transformer = tFactory.newTransformer(xslStreamSourceObject);
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

            transformer.transform(xmlStreamSourceObject, htmlStreamSourceObject);
        } catch (Exception e) {
        }
        return htmlFileName;
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

    /**
     * @return the xslFileName
     */
    public String getXslFileName() {
        return xslFileName;
    }

    /**
     * @param xslFileName the xslFileName to set
     */
    public void setXslFileName(String xslFileName) {
        this.xslFileName = xslFileName;
    }

    /**
     * @return the htmlFileName
     */
    public String getHtmlFileName() {
        return htmlFileName;
    }

    /**
     * @param htmlFileName the htmlFileName to set
     */
    public void setHtmlFileName(String htmlFileName) {
        this.htmlFileName = htmlFileName;
    }

   
}
