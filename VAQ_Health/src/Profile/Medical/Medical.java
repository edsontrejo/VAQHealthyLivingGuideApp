/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile.Medical;

import Disease.Disease;
import Profile.Allergies.Allergy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ^.^
 */
public class Medical {

    /**
     * @return the heightInches
     */
    public String getHeightInches() {
        return heightInches;
    }

    /**
     * @param heightInches the heightInches to set
     */
    public void setHeightInches(String heightInches) {
        this.heightInches = heightInches;
    }

    /**
     * @return the hasHighBloodPressure
     */
    public Boolean getHasHighBloodPressure() {
        return hasHighBloodPressure;
    }

    /**
     * @param hasHighBloodPressure the hasHighBloodPressure to set
     */
    public void setHasHighBloodPressure(Boolean hasHighBloodPressure) {
        this.hasHighBloodPressure = hasHighBloodPressure;
    }

    /**
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * @return the height
     */
    public String getHeight() {
        return heightFt;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(String height) {
        this.heightFt = height;
    }

    /**
     * @return the hasDiabetes
     */
    public Boolean getHasDiabetes() {
        return hasDiabetes;
    }

    /**
     * @param hasDiabetes the hasDiabetes to set
     */
    public void setHasDiabetes(Boolean hasDiabetes) {
        this.hasDiabetes = hasDiabetes;
    }

    /**
     * @return the hasHighColesterol
     */
    public Boolean getHasHighCholesterol() {
        return hasHighCholesterol;
    }

    /**
     * @param hasHighColesterol the hasHighColesterol to set
     */
    public void setHasHighCholesterol(Boolean hasHighColesterol) {
        this.hasHighCholesterol = hasHighColesterol;
    }

    /**
     * @return the hasCeliacDisease
     */
    public Boolean getHasCeliacDisease() {
        return hasCeliacDisease;
    }

    /**
     * @param hasCeliacDisease the hasCeliacDisease to set
     */
    public void setHasCeliacDisease(Boolean hasCeliacDisease) {
        this.hasCeliacDisease = hasCeliacDisease;
    }

    /**
     * @return the hasKidneyDisease
     */
    public Boolean getHasKidneyDisease() {
        return hasKidneyDisease;
    }

    /**
     * @param hasKidneyDisease the hasKidneyDisease to set
     */
    public void setHasKidneyDisease(Boolean hasKidneyDisease) {
        this.hasKidneyDisease = hasKidneyDisease;
    }

    /**
     * @return the hasGout
     */
    public Boolean getHasGout() {
        return hasGout;
    }

    /**
     * @param hasGout the hasGout to set
     */
    public void setHasGout(Boolean hasGout) {
        this.hasGout = hasGout;
    }
    /**
     * Add all values one can make medical inferences from 
     * that's not allergies
     * 
     * Maybe make into activation switches for more options?
     */

    public List<Disease>  diseaseList = new ArrayList<>();
    public List<Allergy> allergyList = new ArrayList<>();
    private String weight;
    private String heightFt;
    private String heightInches;
    private Boolean hasDiabetes;
    private Boolean hasHighCholesterol;
    private Boolean hasCeliacDisease;
    private Boolean hasKidneyDisease;
    private Boolean hasHighBloodPressure;
    private Boolean hasGout;
    
     @Override
    public String toString(){
        return "\nMedical Information:"+
               "\n\tWeight: "+getWeight()+
               "\n\tHeight : "+getHeight()+
               "\n\tHas Diabetes : "+getHasDiabetes()+
               "\n\tHas High Cholestorl : "+getHasHighCholesterol()+
               "\n\tHas Celiac Disease : "+getHasCeliacDisease()+              
               "\n\tHas Kidney Disease : "+getHasKidneyDisease()+
               "\n\tHas High Blood Pressure : "+getHasHighBloodPressure()+
               "\n\tHas Gout : "+getHasGout();

    }
}
