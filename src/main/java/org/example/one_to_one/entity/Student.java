package org.example.one_to_one.entity;

import jakarta.persistence.*;

@Entity                                 // это Java Класс, который отображает информацию определенной таблицы в БД
@Table(name = "students")               // имя таблицы в БД. Показывает к какой именно таблице мы привязываем Класс
public class Student {

    @Id                                 // указывает какой столбец таблицы является PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // IDENTITY - стратегия, при которой PRIMARY KEY изменяется в соответствии с правилами, прописанными при создании таблицы
    @Column(name = "id")                // имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private Long id;

    @Column(name = "name")              // имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private String name;

    @Column(name = "surname")           // имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private String surname;

    @Column(name = "avg_grade")         // имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private Double avgGrade;

    @OneToOne(cascade = CascadeType.ALL)    // @OneToOne - показывает тип отношений между объектами   // cascade = CascadeType.ALL - связывает действия с двумя таблицами
    @JoinColumn(name = "passport_id")       // @JoinColumn - показывает нам столбец, с помощью которого осуществляется связь с другим объектом
    private Passport passport;

    public Student() {
    }

    public Student(String name, String surname, Double avgGrade) {
        this.name = name;
        this.surname = surname;
        this.avgGrade = avgGrade;
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

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getAvgGrade() {
        return avgGrade;
    }
    public void setAvgGrade(Double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", avgGrade=" + avgGrade +
                '}';
    }
}
