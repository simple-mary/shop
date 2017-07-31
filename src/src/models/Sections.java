package models;

/**
 * Created by Perets on 26.07.2017.
 */
public enum Sections
{
    ELECTRONICS("/ru/electronics/");

    Sections(String p_value) {
        value = p_value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;


}
