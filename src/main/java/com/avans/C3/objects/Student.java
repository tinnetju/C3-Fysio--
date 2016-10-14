package com.avans.C3.objects;

import java.util.ArrayList;

public abstract class Student {
    Name name;
    Number studentID;
    ArrayList<Course> courses = new ArrayList<Course>();
    
    public Student (Name name, Number studentID)
    {
        this.name = name;
        this.studentID = studentID;
        this.courses = new ArrayList<Course>();
    }
    
    public Name getName()
    {
        return name;
    }
    
    public Number getStudentID()
    {
        return studentID;
    }
    
    public void addCourse(Course course)
    {
        this.courses.add(course);
    }
    
    public ArrayList getCourses()
    {
        return courses;
    }
}
