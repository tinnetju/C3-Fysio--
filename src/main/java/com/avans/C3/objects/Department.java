package com.avans.C3.objects;

import java.util.ArrayList;

public class Department {
    Name name;
    Number departmentID;
    ArrayList<Instructor> instructors;
    ArrayList<Course> courses;
        
    public Department(Name name, Number departmentID) {
        this.name = name;
        this.departmentID = departmentID;
        this.instructors = new ArrayList<Instructor>();
        this.courses = new ArrayList<Course>();
    }
        
    public void addInstructor(Instructor instructor)
    {
        instructors.add(instructor);
    }
    
    public void removeInstructort(Number instructorID)
    {
        for(Instructor currentInstructor : instructors)
        {
            if(currentInstructor.instructorID == instructorID)
            {
                instructors.remove(currentInstructor);
            }
        }
    }
    
    public Instructor getInstructor(Number instructorID)
    {
        Instructor tempInstructor = null;
        for(Instructor currentInstructor : instructors)
        {
            if(currentInstructor.instructorID == instructorID)
            {
                tempInstructor = currentInstructor;
            }
        }
        
        return tempInstructor;
    }
    
    public ArrayList<Instructor> getAllInstructors()
    {
        return instructors;
    }
    
    
    public void addcourse(Course course)
    {
        courses.add(course);
    }
    
    public void removeCourse(Number courseID)
    {
        for(Course currentCourse : courses)
        {
            if(currentCourse.courseID == courseID)
            {
                courses.remove(currentCourse);
            }
        }
    }
    
    public Course getCourse(Number courseID)
    {
        Course tempCourse = null;
        for(Course currentCourse : courses)
        {
            if(currentCourse.courseID == courseID)
            {
                tempCourse = currentCourse;
            }
        }
        
        return tempCourse;
    }
    
    public ArrayList<Course> getAllCourses()
    {
        return courses;
    }
}