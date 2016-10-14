package com.avans.C3;


import com.avans.C3.objects.Course;
import com.avans.C3.objects.DeeltijdStudent;
import com.avans.C3.objects.Department;
import com.avans.C3.objects.Instructor;
import com.avans.C3.objects.Name;
import com.avans.C3.objects.Number;
import com.avans.C3.objects.School;
import com.avans.C3.objects.VoltijdStudent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MijnSpringAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(MijnSpringAppApplication.class, args);
        
            School prinswillem = new School(new Name("Prins Willem II College"), "Janlaan 14, Wijk en Aalburg", new Number(64));
            Department landbouw = new Department(new Name("Landbouw"), new Number(16));
            

            Instructor leraar = new Instructor(new Name("Martijn de Vries"), new Number(14));
            VoltijdStudent voltijdstudent = new VoltijdStudent(new Name("Felix van der Wal"), new Number(20));
            DeeltijdStudent deeltijdstudent = new DeeltijdStudent(new Name("Hennie de Wit"), new Number(21)); //Ik kreeg de name en de number classes niet voor elkaar, met string werkt het uiteraard wel
            Course tuinieren = new Course(new Name("Tuinieren"), new Number(12));
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
}
