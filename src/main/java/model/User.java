package model;


import java.util.Objects;

/**
 * @author zard
 * @date Created in 27/05/2022 01:50
 */
public class User {

    private Integer id;
    private String name;
    private Integer type;
    private String pwd;
    private String typeName;
    private String studentId;

    public User() {

    }

    public User(Integer id, String name, Integer type, String pwd, String studentId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pwd = pwd;
        this.studentId = studentId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(type, user.type)
                && Objects.equals(pwd, user.pwd) && Objects.equals(typeName, user.typeName) && Objects.equals(studentId, user.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, pwd, typeName, studentId);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", pwd='" + pwd + '\'' +
                ", typeName='" + typeName + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}
