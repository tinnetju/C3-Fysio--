package com.avans.C3;

import com.avans.C3.objects.Course;
import com.avans.C3.objects.DeeltijdStudent;
import com.avans.C3.objects.Department;
import com.avans.C3.objects.Instructor;
import com.avans.C3.objects.Name;
import com.avans.C3.objects.School;
import com.avans.C3.objects.VoltijdStudent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    School prinswillem;
    public GreetingController(){
            Department landbouw = new Department(new Name("Landbouw"), new com.avans.C3.objects.Number(16));
            prinswillem = new School(new Name("Prins Willem II College"), "Janlaan 14, Wijk en Aalburg", new com.avans.C3.objects.Number(64));

            Instructor leraar = new Instructor(new Name("Martijn de Vries"), new com.avans.C3.objects.Number(14));
            VoltijdStudent voltijdstudent = new VoltijdStudent(new Name("Felix van der Wal"), new com.avans.C3.objects.Number(20));
            DeeltijdStudent deeltijdstudent = new DeeltijdStudent(new Name("Hennie de Wit"), new com.avans.C3.objects.Number(21)); //Ik kreeg de name en de number classes niet voor elkaar, met string werkt het uiteraard wel
            Course tuinieren = new Course(new Name("Tuinieren"), new com.avans.C3.objects.Number(12));
            tuinieren.setInstructor(leraar);
            tuinieren.addStudent(voltijdstudent);
            tuinieren.addStudent(deeltijdstudent);
            
            prinswillem.addStudent(voltijdstudent);
            prinswillem.addStudent(deeltijdstudent);
            
            landbouw.addInstructor(leraar);
            landbouw.addcourse(tuinieren);
            
            prinswillem.addDepartment(landbouw);
            System.out.println(prinswillem.getAllDepartments().size());
    }
    

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}
