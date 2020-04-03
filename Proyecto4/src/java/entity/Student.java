package entity;

public class Student {

    private int code;
    private String name;
    private int semester;

    public Student() {
    }

    public Student(int code, String name, int semester) {
        this.code = code;
        this.name = name;
        this.semester = semester;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

}
