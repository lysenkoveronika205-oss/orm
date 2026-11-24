import jakarta.persistence.*;

public class StudentService {

    EntityManagerFactory emf;

    public StudentService(EntityManagerFactory emf) {
        this.emf = emf;
    }


    public void saveStudent(Student student) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(student);
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
