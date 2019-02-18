package Environment.Classes;

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
