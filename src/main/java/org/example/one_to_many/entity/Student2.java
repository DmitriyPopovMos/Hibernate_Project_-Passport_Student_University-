package org.example.one_to_many.entity;

import jakarta.persistence.*;

@Entity                                  // это Java Класс, который отображает информацию определенной таблицы в БД
@Table(name = "students2")               // имя таблицы в БД. Показывает к какой именно таблице мы привязываем Класс
public class Student2 {

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
                                                 // (cascade = CascadeType.ALL) — это значение параметра cascade, которое означает, что все действия (ALL), выполненные с родительским объектом, нужно повторить и для его зависимых объектов
    @ManyToOne                                   // @ManyToOne — создаёт отношение «МНОГИЕ К ОДНОМУ» между двумя сущностями. Указывает, что МНОГИЕ экземпляры 1 (одной) сущности могут быть связаны только с 1 (одним) экземпляром другой сущности.
    @JoinColumn(name = "university_id")          // @JoinColumn(name = "") - показывает нам столбец внешнего ключа в текущей таблице - FOREIGN KEY (id) для связи с Первичным Ключом другой таблицы
    private University university;

    public Student2() {
    }

    public Student2(String name, String surname, Double avgGrade) {
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

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "\nStudent2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", avgGrade=" + avgGrade +
                ", university=" + university +
                '}';
    }
}
