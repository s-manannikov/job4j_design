package ru.job4j.hibernate.hql;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String experience;

    private BigDecimal salary;

    @OneToOne(fetch = FetchType.LAZY)
    private JobBase jobBase;

    /*
    public Candidate(int id, String name, String experience, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.salary = salary;
    }
    */

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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public JobBase getJobBase() {
        return jobBase;
    }

    public void setJobBase(JobBase jobBase) {
        this.jobBase = jobBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate candidate = (Candidate) o;
        return id == candidate.id
                && Objects.equals(name, candidate.name)
                && Objects.equals(experience, candidate.experience)
                && Objects.equals(salary, candidate.salary)
                && Objects.equals(jobBase, candidate.jobBase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, experience, salary, jobBase);
    }

    @Override
    public String toString() {
        return "Candidate{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", experience='" + experience + '\''
                + ", salary=" + salary
                + ", jobBase=" + jobBase
                + '}';
    }
}