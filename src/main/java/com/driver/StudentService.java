package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository theStudentRepository;

    public void addStudent(Student theStudent){
        theStudentRepository.addStudent(theStudent);
    }

    public void addTeacher(Teacher theTeacher){
        theStudentRepository.addteacher(theTeacher);
    }

    public void addStudentTeacherPair(String theStudent, String theTeacher){
        theStudentRepository.addpair(theStudent,theTeacher);
    }

    public Student getStudent(String theStudent){

        Optional<Student> student = theStudentRepository.getStudent(theStudent);

        return student.orElseGet(Student::new);
    }

    public Teacher getTeacher(String theTeacher){
        Optional<Teacher> teacher = theStudentRepository.getTeacher(theTeacher);

        return teacher.orElseGet(Teacher::new);
    }

    public List<String> getStudentsByTeacherName(String theTeacher){
        return theStudentRepository.getAllStudentsByTeacher(theTeacher);
    }

    public List<String> getAllStudents(){
        return theStudentRepository.getAllStudents();
    }

    public void deleteTeacher(String theTeacher){
        theStudentRepository.deleteTeacher(theTeacher);
    }

    public void deleteAllTeachers(){
        theStudentRepository.deleteAllTeachers();
    }
}


















