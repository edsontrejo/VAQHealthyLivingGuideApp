/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Classes;

/**
 *
 * @author yessi
 */
public class SourceInfo {

    private String articleName;
    private String websiteName;
    private String PublicationDate;
    private String sponser;
    private String websiteURL;
    
    public SourceInfo(String articleName, String websiteName, 
                      String PublicationDate, 
                      String sponser, String websiteURL){
        this.articleName = articleName;
        this.websiteName = websiteName;
        this.PublicationDate = PublicationDate;
        this.sponser = sponser;
        this.websiteURL = websiteURL;
    }
    
    /**
     * @return the articleName
     */
    public String getArticleName() {
        return articleName;
    }

    /**
     * @param articleName the articleName to set
     */
    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    /**
     * @return the websiteName
     */
    public String getWebsiteName() {
        return websiteName;
    }

    /**
     * @param websiteName the websiteName to set
     */
    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    /**
     * @return the PublicationDate
     */
    public String getPublicationDate() {
        return PublicationDate;
    }

    /**
     * @param PublicationDate the PublicationDate to set
     */
    public void setPublicationDate(String PublicationDate) {
        this.PublicationDate = PublicationDate;
    }

    /**
     * @return the sponser
     */
    public String getSponser() {
        return sponser;
    }

    /**
     * @param sponser the sponser to set
     */
    public void setSponser(String sponser) {
        this.sponser = sponser;
    }

    /**
     * @return the websiteURL
     */
    public String getWebsiteURL() {
        return websiteURL;
    }

    /**
     * @param websiteURL the websiteURL to set
     */
    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }
}
