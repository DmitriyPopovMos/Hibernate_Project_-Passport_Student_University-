package org.example.one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.one_to_one.entity.Passport;
import org.example.one_to_one.entity.Student;

public class OneToOne {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Hibernate_Project");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();                                                    // начало транзакции

//--------------------------------------------------------------------------------------
            // PERSIST автоматическое создание таблиц и заполняем эти таблицы в Базе Данных

//            Student student = new Student("Frankie", "Parry", 5.8);
//            Passport passport = new Passport("frankie.parry@yahoo.com", 185, EyeColor.BROWN);
//
//            passport.setStudent(student);                  // назначаем Паспорту Студента
//            student.setPassport(passport);                 // назначаем Студенту Паспорт
//            entityManager.persist(passport);               // при запуске "Run" таблицы должны автоматически создаться

//--------------------------------------------------------------------------------------

            //FIND получаем данные из таблицы в БД

//            Passport passport = entityManager.find(Passport.class, 1);
//            System.out.println(passport);
//            System.out.println(passport.getStudent());

//--------------------------------------------------------------------------------------

            //REMOVE удаляет данные из таблицы в БД

//            Student student = entityManager.find(Student.class, 1);
//            entityManager.remove(student);

//--------------------------------------------------------------------------------------

            transaction.commit();                                                   // конец транзакции
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
