package org.example.one_to_many.entity;

import jakarta.persistence.*;

import java.sql.Date;
//import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

@Entity                                 // это Java Класс, который отображает информацию определенной таблицы в БД
@Table(name = "universities")           // имя таблицы в БД. Показывает к какой именно таблице мы привязываем Класс
public class University {

    @Id                                 // указывает какой столбец таблицы является PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // IDENTITY - стратегия, при которой PRIMARY KEY изменяется в соответствии с правилами, прописанными при создании таблицы
    @Column(name = "id")                // имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private Long id;

    @Column(name = "name")              // имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private String name;

    @Column(name = "founding_date")              // имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private Date foundingDate;
                                                               // (cascade = CascadeType.ALL) — это значение параметра cascade, которое означает, что все действия (ALL), выполненные с родительским объектом, нужно повторить и для его зависимых объектов
    @OneToMany(mappedBy = "university",                        // (mappedBy = "company") - указывает на столбец FOREIGN KEY (внешний ключ) другой таблицы по которому мы Мапимся (делаем связь)
            cascade = CascadeType.ALL)                         // @OneToMany - показывает тип отношений между объектами
    private List<Student2> student2List = new ArrayList<>();

    public void addStudentToUniversity(Student2 student) {
        student2List.add(student);
        student.setUniversity(this);                           // this - означает эта Сущность (этот Класс) - в этом University
    }

    public University() {
    }

    public University(String name, Date foundingDate) {
        this.name = name;
        this.foundingDate = foundingDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(Date foundingDate) {
        this.foundingDate = foundingDate;
    }

    public List<Student2> getStudent2List() {
        return student2List;
    }

    public void setStudent2List(List<Student2> student2List) {
        this.student2List = student2List;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", foundingDate=" + foundingDate +
                '}';
    }
}
