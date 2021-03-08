package service;

import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.net.ssl.SSLContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@Transactional
public class StudentService implements IStudentService {
//    public static Map<Integer, Student> list = new HashMap<>();
//
//    static {
//        list.put(1, new Student(1, "thanh", "hn", 27));
//        list.put(2, new Student(2, "hieu", "hn", 27));
//        list.put(3, new Student(3, "toàn", "tb", 27));
//    }

    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    private SessionFactory sessionFactory;

    @Override
    public List<Student> findAll() {
        String query = "SELECT s from Student AS s";
        TypedQuery<Student> query1 = entityManager.createQuery(query, Student.class);
        return query1.getResultList();
    }

    @Override
    public List<Student> findID(int id) {
//        String query = "SELECT s FROM Student AS s WHERE s.id = :id";
//        TypedQuery<Student> query1 = entityManager.createQuery(query, Student.class);
//        query1.setParameter("id", id);

        return null;
    }

    @Override
    public void remote(int id) {
//        String query = "DELETE s FROM Student AS s WHERE s.id = :id";
//        TypedQuery<Student> query1 = entityManager.createQuery(query, Student.class);
//        query1.setParameter("id", id);
//        query1.getResultList();
    }

    @Override
    public void create(Student student) {
        if (student.getId() != 0){
            entityManager.merge(student);
        }
        else {
            entityManager.persist(student);
        }
//        Session session = null;
//        Transaction transaction = null;
//        try {
//            session = sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            session.update(student);
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                session.close();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
    }

    @Override
    public void edit(Student student) {
//        Session session = null;
//        Transaction transaction = null;
//        try {
//            session = sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            session.save(session);
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }

    }
}
