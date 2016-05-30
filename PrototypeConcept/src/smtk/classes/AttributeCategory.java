package smtk.classes;

import javax.management.Attribute;

/**
 * Created by stk-des01 on 27-05-16.
 */
public class AttributeCategory {


    private int id;
    private String name;
    private int multiplicity;
    private String description;
    private boolean required;



    public AttributeCategory(int id, String name, int multiplicity, String description, boolean required) {
        this.id = id;
        this.name = name;
        this.multiplicity = multiplicity;
        this.description = description;
        this.required = required;
    }

    @Override
    public String toString() {
        return "AttributeCategory { " +
                "id=" + id +
                ", name='" + name + '\'' +
                ", multiplicity=" + multiplicity +
                ", description='" + description + '\'' +
                ", required=" + required +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMultiplicity() {
        return multiplicity;
    }

    public void setMultiplicity(int multiplicity) {
        this.multiplicity = multiplicity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
