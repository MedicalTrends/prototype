package smtk.classes;

/**
 * Created by stk-des01 on 07-06-16.
 */
public class TypeDescription {
    String id;
    String type;

    public TypeDescription(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
