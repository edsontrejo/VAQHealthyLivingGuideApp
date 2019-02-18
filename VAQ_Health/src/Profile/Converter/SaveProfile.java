/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile.Converter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static Profile.Converter.XMLGenerator.mergeMultipleXMLDocs;

/**
 *
 * @author MQ0162246
 */
public class SaveProfile {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void converter(String directory) {

        // input files:
        String xmlFile  = "profileXml.xml";
        String xslFile  = "profileXsl.xsl";
       
        // Output Files
        String htmlFile = "ProfileHtml.htm";
        String pdfFile  = "Profile.pdf";
        
        // Create XML document; you should have the xsl designed for it as well
        XMLGenerator jobXML = new XMLGenerator(xmlFile,directory);
        jobXML.jobXMLGenerator(null);

        // Testing the XML 2 HTML Conversion
        XML2HTML xml2htmlObject = new XML2HTML(xmlFile, xslFile, htmlFile);
        xml2htmlObject.convert2Html(xml2htmlObject.getXmlFileName(), xml2htmlObject.getXslFileName(), xml2htmlObject.getHtmlFileName(),directory);

        // Testing the HTML 2 PDF Conversion
        HTML2PDF html2pdfObject = new HTML2PDF(xml2htmlObject.getHtmlFileName(), pdfFile);
        html2pdfObject.convert2Pdf(html2pdfObject.getHtmlFileName(), html2pdfObject.getPdfFileName(),directory);
       
        // Testing combine xml files into another xml
          List<String> list = new ArrayList<>();
          //list is hard coded...
          list.add("profileXml.xml");
          list.add("profileXml.xml");
          //mergeMultipleXMLDocs(list of files,root node, output file);
          mergeMultipleXMLDocs(list,"Profile", "AlinOne.xml");

    }
    public static void HTML(String directory)
    {
        // input files:
        String xmlFile  = "profileXml.xml";
        String xslFile  = "profileXsl.xsl";
       
        // Output Files
        String htmlFile = "ProfileHtml.htm";
        
        // Create XML document; you should have the xsl designed for it as well
        XMLGenerator jobXML = new XMLGenerator(xmlFile,directory);
        jobXML.jobXMLGenerator(null);

        // Testing the XML 2 HTML Conversion
        XML2HTML xml2htmlObject = new XML2HTML(xmlFile, xslFile, htmlFile);
        xml2htmlObject.convert2Html(xml2htmlObject.getXmlFileName(), xml2htmlObject.getXslFileName(), xml2htmlObject.getHtmlFileName(),directory);

    }
      public static void PDF(String directory)
    {
       
        // input files:
        String xmlFile  = "profileXml.xml";
        String xslFile  = "profileXsl.xsl";
       
        // Output Files
        String htmlFile = "ProfileHtml.htm";
        String pdfFile  = "Profile.pdf";
        
        // Create XML document; you should have the xsl designed for it as well
        XMLGenerator jobXML = new XMLGenerator(xmlFile,directory);
        jobXML.jobXMLGenerator(null);

        // Testing the XML 2 HTML Conversion
        XML2HTML xml2htmlObject = new XML2HTML(xmlFile, xslFile, htmlFile);
        xml2htmlObject.convert2Html(xml2htmlObject.getXmlFileName(), xml2htmlObject.getXslFileName(), xml2htmlObject.getHtmlFileName(),directory);

        // Testing the HTML 2 PDF Conversion
        HTML2PDF html2pdfObject = new HTML2PDF(xml2htmlObject.getHtmlFileName(), pdfFile);
        html2pdfObject.convert2Pdf(html2pdfObject.getHtmlFileName(), html2pdfObject.getPdfFileName(),directory);

    }

    public static void XML(String directoryPath) {
        // input files:
        String xmlFile  = "profileXml.xml";
        
        // Create XML document; you should have the xsl designed for it as well
        XMLGenerator jobXML = new XMLGenerator(xmlFile, directoryPath);
        jobXML.jobXMLGenerator(null);
        
        // Testing combine xml files into another xml
        List<String> list = new ArrayList<>();
        //list is hard coded...
        list.add("profileXml.xml");
        list.add("profileXml.xml");
        //mergeMultipleXMLDocs(list of files,root node, output file);
        mergeMultipleXMLDocs(list, "Profile", "AlinOne.xml");

    }
}
