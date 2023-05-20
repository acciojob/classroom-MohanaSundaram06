package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository {

    HashMap<String, Student> studentMap;
    HashMap<String, Teacher> teacherMap;
    HashMap<String, List<String>> pairMap;

    public StudentRepository() {
        this.studentMap = new HashMap<>();
        this.teacherMap = new HashMap<>();
        this.pairMap = new HashMap<>();
    }

    public void addStudent(Student theStudent) {
        studentMap.put(theStudent.getName(), theStudent);
    }

    public void addteacher(Teacher theTeacher) {
        teacherMap.put(theTeacher.getName(), theTeacher);
    }

    public void addpair(String theStudent, String theTeacher){
        if(!studentMap.containsKey(theStudent) && !teacherMap.containsKey((theTeacher))) return;

        List<String> studentList = new ArrayList<>();

        if(pairMap.containsKey(theTeacher)) studentList = pairMap.get(theTeacher);

        studentList.add(theStudent);

        pairMap.put(theTeacher,studentList);
    }

    public Optional<Student> getStudent(String theStudent){
        return studentMap.containsKey(theStudent) ? Optional.of(studentMap.get(theStudent)) : Optional.empty();
    }

    public Optional<Teacher> getTeacher(String theTeacher){
        return teacherMap.containsKey(theTeacher) ? Optional.of(teacherMap.get(theTeacher)) : Optional.empty();
    }

    public List<String> getAllStudentsByTeacher(String theTeacher){
        List<String> studentsList;

        if(pairMap.containsKey(theTeacher)) studentsList = pairMap.get(theTeacher);
        else studentsList = new ArrayList<>();

        return studentsList;
    }

    public List<String> getAllStudents(){
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String theTeacher){

        List<String> studentsList = getAllStudentsByTeacher(theTeacher);

        for(String student : studentsList) studentMap.remove(student);

        teacherMap.remove(theTeacher);
        pairMap.remove(theTeacher);
    }

    public void deleteAllTeachers(){

        for(String theTeacher : teacherMap.keySet()){
            deleteTeacher(theTeacher);
        }
        teacherMap.clear();
        pairMap.clear();
    }
}
















