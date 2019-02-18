/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile.Converter;

import com.lowagie.text.DocumentException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.xhtmlrenderer.pdf.ITextRenderer;

/**
 *
 * @author MQ0162246
 */
public class HTML2PDF {

    private String htmlFileName;
    private String pdfFileName;

    // constructors
    public HTML2PDF(String htmlFileName, String pdfFileName) {
        this.htmlFileName = htmlFileName;
        this.pdfFileName = pdfFileName;
    }

    String convert2Pdf(String htmlFileName, String pdfFileName,String directory) {
        try {
            String url = new File(htmlFileName).toURI().toURL().toString();
            //Debugging: System.out.println(""+url);
            OutputStream os = new FileOutputStream(directory+File.separator+pdfFileName);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(url);
            renderer.layout();
            renderer.createPDF(os);
            os.close();
        } catch (DocumentException e) {
            System.out.println("Error in the html to pdf converter");
        } catch (IOException e) {
            System.out.println("Error in the html to pdf converter");
        } catch (Exception e) {
            System.out.println("Error in the html to pdf converter");
        }
        return pdfFileName;
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

    /**
     * @return the pdfFileName
     */
    public String getPdfFileName() {
        return pdfFileName;
    }

    /**
     * @param pdfFileName the pdfFileName to set
     */
    public void setPdfFileName(String pdfFileName) {
        this.pdfFileName = pdfFileName;
    }
}
