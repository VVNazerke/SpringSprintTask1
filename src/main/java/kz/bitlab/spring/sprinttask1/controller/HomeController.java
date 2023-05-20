package kz.bitlab.spring.sprinttask1.controller;

import kz.bitlab.spring.sprinttask1.db.DBManager;
import kz.bitlab.spring.sprinttask1.db.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String index(Model model) {
        ArrayList<Student> students = DBManager.getStudents();
        model.addAttribute("studenty", students);
        return "index";
    }

    @GetMapping(value = "/add-student")
    public String addStudentGet() {
        return "addStudent";
    }

    @PostMapping(value = "/add-student")
    public String addStudentPost(
            @RequestParam(name = "s_name") String name,
            @RequestParam(name = "s_surname") String surname,
            @RequestParam(name = "s_exam") int exam
    ) {
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        if (exam >= 90) {
            student.setMark("A");
        } else if (exam >= 75) {
            student.setMark("B");
        } else if (exam >= 60) {
            student.setMark("C");
        } else if (exam >= 50) {
            student.setMark("D");
        } else {
            student.setMark("F");
        }
        DBManager.addStudents(student);
        return "redirect:/";
    }
}
