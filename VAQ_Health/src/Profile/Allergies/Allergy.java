/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile.Allergies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ^.^
 */
public class Allergy {

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Allergy(String n, String d) {
        this.name = n;
        this.description = d;
    }

    @Override
    public String toString() {
        return getName();
    }

    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }
        if (!(o instanceof Allergy)) {
            return false;
        }

        Allergy allergy = (Allergy) o;

        return allergy.name.equals(name);
    }

    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        return result;
    }

    private String name;
    private String description;

}
