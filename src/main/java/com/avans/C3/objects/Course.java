package com.avans.C3.objects;

import java.util.ArrayList;

public class Course {
    Name name;
    Number courseID;
    Instructor instructor;
    ArrayList<Student> students;
    
    public Course (Name name, Number courseID)
    {
        this.name = name;
        this.courseID = courseID;
        this.students = new ArrayList<Student>();
    }
    
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
         
    public void addStudent(Student student)
    {
        students.add(student);
    }
    
    public void removeStudent(Number studentID)
    {
        for(Student currentStudent : students)
        {
            if(currentStudent.studentID == studentID)
            {
                students.remove(currentStudent);
            }
        }
    }
    
    public ArrayList<Student> getAllStudents()
    {
        return students;
    }
}
