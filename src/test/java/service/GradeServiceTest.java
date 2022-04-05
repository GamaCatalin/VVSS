package service;

import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

public class GradeServiceTest {

    @org.junit.jupiter.api.Test
    public void saveStudent_Added() {

        Service service = new Service(new StudentXMLRepository(new StudentValidator(),"test_students.xml"),null,null);

        service.deleteStudent("999");

        int initLen[] = {0};
        service.findAllStudents().forEach(s -> initLen[0]++);
        assert(service.saveStudent("999","Gioni Bravo",910) == 1);
        int finLen[] = {0};
        service.findAllStudents().forEach(s -> finLen[0]++);

        assert(initLen[0] + 1 == finLen[0]);

    }


    @org.junit.jupiter.api.Test
    public void addAssignment_Added() {

        Service service = new Service(null,new TemaXMLRepository(new TemaValidator(),"test_assignment.xml"),null);

        service.deleteTema("999");

        int initLen[] = {0};
        service.findAllTeme().forEach(s -> initLen[0]++);
        assert(service.saveTema("999","asta merge",13,7) == 1);
        int finLen[] = {0};
        service.findAllTeme().forEach(s -> finLen[0]++);

        assert(initLen[0] + 1 == finLen[0]);

    }



    @org.junit.jupiter.api.Test
    public void addGrade_Added() {


        Service service = new Service(new StudentXMLRepository(new StudentValidator(),"test_students.xml"),
                new TemaXMLRepository(new TemaValidator(),"test_assignment.xml"),
                new NotaXMLRepository(new NotaValidator(),"test_grade.xml"));


        String idStudent = "999";
        String idAssignment = "999";
        int valGrade = 10;
        int turnIn = 14;
        String feedback = "e bun";


        service.deleteNota(idStudent, idAssignment);

        int initLen[] = {0};
        service.findAllNote().forEach(s -> initLen[0]++);
        assert(service.saveNota(idStudent,idAssignment, valGrade, turnIn, feedback) == 1);
        int finLen[] = {0};
        service.findAllNote().forEach(s -> finLen[0]++);

        assert(initLen[0] + 1 == finLen[0]);

    }


    @org.junit.jupiter.api.Test
    public void addGrade_Integration() {

        saveStudent_Added();
        addAssignment_Added();
        addGrade_Added();

    }





}
