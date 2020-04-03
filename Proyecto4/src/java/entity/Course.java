package entity;

public class Course {

    private int code;
    private String description;
    private String program;
    private String teacher;
    private int credits;

    public Course() {
    }

    public Course(int code, String description, String program, String teacher, int credits) {
        this.code = code;
        this.description = description;
        this.program = program;
        this.teacher = teacher;
        this.credits = credits;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

}
