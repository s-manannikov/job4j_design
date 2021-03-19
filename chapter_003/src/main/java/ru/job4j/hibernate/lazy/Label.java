package ru.job4j.hibernate.lazy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "label")
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "label")
    private List<Car> cars = new ArrayList<>();

    public static Label of(String name) {
        Label label = new Label();
        label.name = name;
        return label;
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

    public List<Car> getCars() {
        return this.cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Label label = (Label) o;
        return id == label.id
                && Objects.equals(name, label.name)
                && Objects.equals(cars, label.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cars);
    }

    @Override
    public String toString() {
        return "Label{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
