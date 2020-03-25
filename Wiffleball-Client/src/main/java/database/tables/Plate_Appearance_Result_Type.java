package database.tables;

import java.util.Objects;

public class Plate_Appearance_Result_Type {
    public static final String ID_COLUMN_NAME = "id";
    public static final String RESULT_TYPE_COLUMN_NAME = "result_type";

    private Integer id;
    private String result_type;

    public Plate_Appearance_Result_Type()
    {

    }

    public Plate_Appearance_Result_Type(Integer id, String result_type) {
        this.id = id;
        this.result_type = result_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResult_type() {
        return result_type;
    }

    public void setResult_type(String result_type) {
        this.result_type = result_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plate_Appearance_Result_Type that = (Plate_Appearance_Result_Type) o;
        return id.equals(that.id) &&
                result_type.equals(that.result_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, result_type);
    }

    @Override
    public String toString() {
        return "plate_appearance_result_type{" +
                "id=" + id +
                ", result_type='" + result_type + '\'' +
                '}';
    }
}
