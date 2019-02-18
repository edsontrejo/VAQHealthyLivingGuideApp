/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Models;

import java.util.ArrayList;
import Environment.Classes.SourceInfo;

/**
 *
 * @author yessi
 */
public class AboutModel {
       
    private ArrayList<SourceInfo> Sources = new ArrayList<>();
    
    public AboutModel(){
        SourceInfo mySource1 = new SourceInfo("Choose MyPlate","ChooseMyPlate","n.d.",
                                                "United States Department of Agriculture (USDA)",
                                                "https://www.choosemyplate.gov/");
        SourceInfo mySource2 = new SourceInfo("President's Council on Fitness, Sports & Nutrition (PCFSN)",
                                                "HHS.gov","April 25, 2017","U.S. Department of Health & Human Services",
                                                "https://www.hhs.gov/fitness/index.html");
        SourceInfo mySource3 = new SourceInfo("Team Nutrition","Food and Nutrition Service","n.d.",
                                                "United States Department of Agriculture (USDA)",
                                                "https://www.fns.usda.gov/tn/team-nutrition");
        SourceInfo mySource4 = new SourceInfo("Welcome","Nutrition.gov","n.d.",
                                                "United States Department of Agriculture (USDA)",
                                                "https://www.nutrition.gov/");
        SourceInfo mySource5 = new SourceInfo("Eating Well in Brownsville","Eating Well in Brownsville","January 01, 1970",
                                                "n.s.",
                                                "http://ewb.cob.us/");
        SourceInfo mySource6 = new SourceInfo("Home","Women, Infant, Children","n.d",
                                                "UTHealth",
                                                "https://med.uth.edu/wic/");
        SourceInfo mySource7 = new SourceInfo("Living Well - Make it a Priority","University of Texas System","n.d.",
                                                "The University of Texas SYstem",
                                                "https://www.utsystem.edu/offices/employee-benefits/living-well-make-it-priority");
        SourceInfo mySource8 = new SourceInfo("Office of Disease Prevention and Health Promotion","Home of the Office of Health Promotion and Disease Prevention","n.d",
                                                "U.S. Department of Health and Human Services",
                                                "https://health.gov/");
        SourceInfo mySource9 = new SourceInfo("Dietary Guidelines for Americans 2015-2020 8th Edition","2015-2020 Dietary Guidelines","December 2015",
                                                "U.S. Department of Health and Human Services and U.S. Department of Agriculture",
                                                "https://health.gov/dietaryguidelines/2015/guidelines/");
        
        Sources.add(mySource1); Sources.add(mySource2); Sources.add(mySource3); 
        Sources.add(mySource4); Sources.add(mySource5); Sources.add(mySource6); 
        Sources.add(mySource7); Sources.add(mySource8); Sources.add(mySource9);
    }
    
        /**
     * @return the Sources
     */
    public ArrayList<SourceInfo> getSources() {
        return Sources;
    }

    /**
     * @param Sources the Sources to set
     */
    public void setSources(ArrayList<SourceInfo> Sources) {
        this.Sources = Sources;
    }
}
