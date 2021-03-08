package controller;

import model.Student;
import org.codehaus.groovy.transform.GroovyASTTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IStudentService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("list");
        List<Student> studentList = studentService.findAll();
        modelAndView.addObject("list", studentList);
        return modelAndView;

    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("s", new Student());
        return modelAndView;

    }

    @PostMapping("/create")
    public ModelAndView createStudent(@ModelAttribute Student student) {
        studentService.create(student);
        return new ModelAndView("redirect:" + "/student");
    }

    @GetMapping("/{id}")
    public ModelAndView findById(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Student student = (Student) studentService.findID(id);
        modelAndView.addObject("s", student);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteStudent(@PathVariable Integer id){
        studentService.remote(id);
        return new ModelAndView("redirect:" + "/student");
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("s", new Student());
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView editStudent(@ModelAttribute Student student){
        studentService.edit(student);
        return new ModelAndView("redirect:" + "/student");
    }


}
