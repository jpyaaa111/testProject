package model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author : JinPeiyao
 * @version : V1.0
 * @Title : People.java
 * @date : 2020年09月08日 20:40
 */
public class People {

    private String name;
    private Integer age;
    private BigDecimal grades;

    public People() {
    }

    public People(String name, Integer age, BigDecimal grades) {
        this.name = name;
        this.age = age;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getGrades() {
        return grades;
    }

    public void setGrades(BigDecimal grades) {
        this.grades = grades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;
        People people = (People) o;
        return Objects.equals(getName(), people.getName()) &&
               Objects.equals(getAge(), people.getAge()) &&
               Objects.equals(getGrades(), people.getGrades());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getGrades());
    }

    @Override
    public String toString() {
        return "People{" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", grades=" + grades +
               '}';
    }
}
