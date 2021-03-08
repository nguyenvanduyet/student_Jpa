package service;

import model.Student;

import java.beans.Customizer;
import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    List<Student> findID(int id);
    void remote(int id);
    void create (Student student);
    void edit(Student student);


}
