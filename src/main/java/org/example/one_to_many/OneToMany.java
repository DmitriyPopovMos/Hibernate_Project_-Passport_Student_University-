package org.example.one_to_many;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.one_to_many.entity.Student2;
import org.example.one_to_many.entity.University;

import java.sql.Date;


public class OneToMany {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_Project");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();                                                    // начало транзакции

//===========================================================
            // PERSIST заполняем таблицы в Базе Данных

//            University university = new University("МГУ", Date.valueOf("1755-01-12"));
//            Student2 student1 = new Student2("Михаил", "Ломоносов", 9.8);
//            Student2 student2 = new Student2("Владимир", "Жириновский", 8.9);
//            university.addStudentToUniversity(student1);
//            university.addStudentToUniversity(student2);
//            entityManager.persist(university);

//===========================================================
            //FIND получаем данные из таблицы в БД

//            University university = entityManager.find(University.class, 1);
//            System.out.println(university);
//            System.out.println(university.getStudent2List());

//===========================================================
            // ADD добавляем данные

//            University university = entityManager.find(University.class, 1);          // указываем в какой Университет добавляем студента
//            Student2 student = new Student2("Александр", "Невский", 7.8);
//            university.addStudentToUniversity(student);

//===========================================================

            //REMOVE удаляет данные из таблицы в БД

//            Student2 student = entityManager.find(Student2.class, 1);               // Удаление студента из Университета
//            entityManager.remove(student);
//-----------------------------------------------------------
//            University university = entityManager.find(University.class, 1);       // При удалении Университета, так же удалятся все сущности (Entity), которые с ним связаны (Студенты)
//            entityManager.remove(university);

//===========================================================

            transaction.commit();                                                      // конец транзакции
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
                factory.close();
            }
        }
    }
}
