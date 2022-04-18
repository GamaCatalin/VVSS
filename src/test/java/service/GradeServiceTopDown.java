package service;

import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

public class GradeServiceTopDown {


    @org.junit.jupiter.api.Test
    public void saveStudent_Added() {

        Service service = new Service(new StudentXMLRepository(new StudentValidator(),"test_students.xml"),
                null,
                null);

        String idStudent = "999";
        String nameStudent = "Gioni Bravo";
        int groupStudent = 910;

        service.deleteStudent(idStudent);


        int initLen[] = {0};
        int finLen[] = {0};


        service.findAllStudents().forEach(s -> initLen[0]++);
        assert(service.saveStudent(idStudent,nameStudent,groupStudent) == 1);
        service.findAllStudents().forEach(s -> finLen[0]++);
        assert(initLen[0] + 1 == finLen[0]);

    }


    @org.junit.jupiter.api.Test
    public void addAssignment_Added() {

        Service service = new Service(new StudentXMLRepository(new StudentValidator(),"test_students.xml"),
                new TemaXMLRepository(new TemaValidator(),"test_assignment.xml"),
                null);


        String idStudent = "999";
        String nameStudent = "Gioni Bravo";
        String idAssignment = "999";
        String descriptionAssignment = "asta merge";
        int deadlineAssignment = 13;
        int startlineAssignmenet = 7;
        int groupStudent = 910;


        service.deleteStudent(idStudent);
        service.deleteTema(idAssignment);


        int initLen[] = {0,0};
        int finLen[] = {0,0};



        service.findAllStudents().forEach(s -> initLen[0]++);
        assert(service.saveStudent(idStudent,nameStudent,groupStudent) == 1);
        service.findAllStudents().forEach(s -> finLen[0]++);
        assert(initLen[0] + 1 == finLen[0]);



        service.findAllTeme().forEach(s -> initLen[1]++);
        assert(service.saveTema(idAssignment,descriptionAssignment,deadlineAssignment,startlineAssignmenet) == 1);
        service.findAllTeme().forEach(s -> finLen[1]++);
        assert(initLen[1] + 1 == finLen[1]);

    }



    @org.junit.jupiter.api.Test
    public void addGrade_Added() {


        Service service = new Service(new StudentXMLRepository(new StudentValidator(),"test_students.xml"),
                new TemaXMLRepository(new TemaValidator(),"test_assignment.xml"),
                new NotaXMLRepository(new NotaValidator(),"test_grade.xml"));


        String idStudent = "999";
        String nameStudent = "Gioni Bravo";
        int groupStudent = 910;

        String idAssignment = "999";
        String descriptionAssignment = "asta merge";
        int deadlineAssignment = 13;
        int startlineAssignmenet = 7;

        int valGrade = 10;
        int turnIn = 14;
        String feedback = "e bun";


        service.deleteNota(idStudent, idAssignment);
        service.deleteStudent(idStudent);
        service.deleteTema(idAssignment);


        int initLen[] = {0,0,0};
        int finLen[] = {0,0,0};



        service.findAllStudents().forEach(s -> initLen[0]++);
        assert(service.saveStudent(idStudent,nameStudent,groupStudent) == 1);
        service.findAllStudents().forEach(s -> finLen[0]++);
        assert(initLen[0] + 1 == finLen[0]);



        service.findAllTeme().forEach(s -> initLen[1]++);
        assert(service.saveTema(idAssignment,descriptionAssignment,deadlineAssignment,startlineAssignmenet) == 1);
        service.findAllTeme().forEach(s -> finLen[1]++);
        assert(initLen[1] + 1 == finLen[1]);




        service.findAllNote().forEach(s -> initLen[2]++);
        assert(service.saveNota(idStudent,idAssignment, valGrade, turnIn, feedback) == 1);
        service.findAllNote().forEach(s -> finLen[2]++);
        assert(initLen[2] + 1 == finLen[2]);

    }



}
