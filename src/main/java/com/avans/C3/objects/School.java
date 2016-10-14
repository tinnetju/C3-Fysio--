package com.avans.C3.objects;

import java.util.ArrayList;

public class School {
    private Name name;
    private String address;
    private Number phone;
    private ArrayList<Student> students;
    private ArrayList<Department> departments;
    
    public School(Name name, String address, Number phone) 
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.students = new ArrayList<Student>();
        this.departments = new ArrayList<Department>();
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
    
    public Student getStudent(Number studentID)
    {
        Student tempStudent = null;
        for(Student currentStudent : students)
        {
            if(currentStudent.studentID == studentID)
            {
                tempStudent = currentStudent;
            }
        }
        
        return tempStudent;
    }
    
    public ArrayList<Student> getAllStudents()
    {
        return students;
    }
    
    public void addDepartment(Department department)
    {
        departments.add(department);
    }
    
    public void removeDepartment(Number departmentID)
    {
        for(Department currentDepartment : departments)
        {
            if(currentDepartment.departmentID == departmentID)
            {
                departments.remove(currentDepartment);
            }
        }
    }
    
    public Department getDepartment(Number departmentID)
    {
        Department tempDepartment = null;
        for(Department currentDepartment : departments)
        {
            if(currentDepartment.departmentID == departmentID)
            {
                tempDepartment = currentDepartment;
            }
        }
        
        return tempDepartment;
    }
    
    public ArrayList<Department> getAllDepartments()
    {
        return departments;
    }
}