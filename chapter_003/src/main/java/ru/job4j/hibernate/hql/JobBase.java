package ru.job4j.hibernate.hql;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "job_base")
public class JobBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Job> jobs = new ArrayList<>();

    /*
    public JobBase(int id, String name) {
        this.id = id;
        this.name = name;
    }
     */

    public void addJob(Job job) {
        this.jobs.add(job);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JobBase jobBase = (JobBase) o;
        return id == jobBase.id
                && Objects.equals(name, jobBase.name)
                && Objects.equals(jobs, jobBase.jobs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, jobs);
    }

    @Override
    public String toString() {
        return "JobBase{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", jobs=" + jobs
                + '}';
    }
}
