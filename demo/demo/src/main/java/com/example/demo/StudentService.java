package com.example.demo;

import jakarta.persistence.*;

public class StudentService {

    EntityManagerFactory emf;

    public StudentService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // a) CREATE
    public void saveStudent() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student student1 = new Student();
        student1.setName("Veronika");
        student1.setAge(17);
        student1.setEmail("veronika@ivkhk.ee");

        em.persist(student1);

        em.getTransaction().commit();
        em.close();
    }

    public void updateStudentAge(Long id, int age) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student s = em.find(Student.class, id);

        if (s != null) {
            s.setAge(age);
        }

        em.getTransaction().commit();
        em.close();
    }


    public void deleteStudent(Long id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student s = em.find(Student.class, id);

        if (s != null) {
            em.remove(s);
        }

        em.getTransaction().commit();
        em.close();
    }
}