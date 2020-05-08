package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "course")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
    , @NamedQuery(name = "Course.findByIdentificator", query = "SELECT c FROM Course c WHERE c.identificator = :identificator")
    , @NamedQuery(name = "Course.findByCode", query = "SELECT c FROM Course c WHERE c.code = :code")
    , @NamedQuery(name = "Course.findByDescription", query = "SELECT c FROM Course c WHERE c.description = :description")
    , @NamedQuery(name = "Course.findByProgram", query = "SELECT c FROM Course c WHERE c.program = :program")
    , @NamedQuery(name = "Course.findByTeacher", query = "SELECT c FROM Course c WHERE c.teacher = :teacher")
    , @NamedQuery(name = "Course.findByCredits", query = "SELECT c FROM Course c WHERE c.credits = :credits")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "identificator")
    private Integer identificator;
    @Basic(optional = false)
    @NotNull
    @Column(name = "code")
    private int code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "program")
    private String program;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "teacher")
    private String teacher;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credits")
    private int credits;

    public Course() {
    }

    public Course(Integer identificator) {
        this.identificator = identificator;
    }

    public Course(Integer identificator, int code, String description, String program, String teacher, int credits) {
        this.identificator = identificator;
        this.code = code;
        this.description = description;
        this.program = program;
        this.teacher = teacher;
        this.credits = credits;
    }

    public Integer getIdentificator() {
        return identificator;
    }

    public void setIdentificator(Integer identificator) {
        this.identificator = identificator;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificator != null ? identificator.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.identificator == null && other.identificator != null) || (this.identificator != null && !this.identificator.equals(other.identificator))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Course[ identificator=" + identificator + " ]";
    }

}
