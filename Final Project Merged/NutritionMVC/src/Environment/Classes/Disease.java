/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment.Classes;

/**
 *
 * @author ^.^
 */
public class Disease {

    /**
     * @return the description
     */
    public String getDiscription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDiscription(String discription) {
        this.description = discription;
    }

    private String name;
    private String description;

    public Disease(String n, String d) {
        this.name = n;
        this.description = d;
    }

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

    @Override
    public String toString() {
        return getName();
    }

    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }
        if (!(o instanceof Disease)) {
            return false;
        }

        Disease disease = (Disease) o;

        return disease.name.equals(name);
    }

    //Idea from effective Java : Item 9
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        return result;
    }

}

