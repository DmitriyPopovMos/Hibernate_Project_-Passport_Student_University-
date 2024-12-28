package org.example.one_to_one.entity;

import jakarta.persistence.*;
import org.example.one_to_one.EyeColor;

@Entity                                 // это Java Класс, который отображает информацию определенной таблицы в БД
@Table(name = "passports")              // имя таблицы в БД. Показывает к какой именно таблице мы привязываем Класс
public class Passport {

    @Id                                 // указывает какой столбец таблицы является PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // IDENTITY - стратегия, при которой PRIMARY KEY изменяется в соответствии с правилами, прописанными при создании таблицы
    @Column(name = "id")                // имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private Long id;

    @Column(name = "email")                // имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private String email;

    @Column(name = "height")                // имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private int height;

    @Enumerated(EnumType.STRING)               // Сохраняет Строковую презентацию Enum
    @Column(name = "eye_color")                // имя столбца в таблице. Делает привязку (mapping) переменной класса к столбцу таблицы ДБ
    private EyeColor eyeColor;
                                                                     // cascade = CascadeType.PERSIST - связывает действия с двумя таблицами
    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)           // @OneToOne - показывает тип отношений между объектами
    private Student student;

    public Passport() {
    }

    public Passport(String email, int height, EyeColor eyeColor) {
        this.email = email;
        this.height = height;
        this.eyeColor = eyeColor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", height=" + height +
                ", eyeColor='" + eyeColor + '\'' +
                '}';
    }
}
