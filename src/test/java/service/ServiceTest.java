package service;

import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.ValidationException;

public class ServiceTest {

    @org.junit.jupiter.api.Test
    public void saveStudent_Added() {


        Service service = new Service(new StudentXMLRepository(new StudentValidator(),"test_students.xml"),null,null);
//        service.findAllStudents().forEach(s -> service.deleteStudent(s.getID()));

        int initLen[] = {0};
        service.findAllStudents().forEach(s -> initLen[0]++);
        assert(service.saveStudent("999","Gioni Bravo",910) == 1);
        int finLen[] = {0};
        service.findAllStudents().forEach(s -> finLen[0]++);

        assert(initLen[0] + 1 == finLen[0]);

        service.deleteStudent("999");
    }

    @org.junit.jupiter.api.Test
    public void saveStudent_NotAdded() {

        Service service = new Service(new StudentXMLRepository(new StudentValidator(),"test_students.xml"),null,null);
//        service.findAllStudents().forEach(s -> service.deleteStudent(s.getID()));

        int initLen[] = {0};
        service.findAllStudents().forEach(s -> initLen[0]++);
        try{
            service.saveStudent("999","Gioni Bravo",940);
        }
        catch (ValidationException e){
            assert(true);
        }
        int finLen[] = {0};
        service.findAllStudents().forEach(s -> finLen[0]++);

        assert(initLen[0] == finLen[0]);
        service.deleteStudent("999");
    }


    @org.junit.jupiter.api.Test
    public void addAssignment_Added() {


        Service service = new Service(null,new TemaXMLRepository(new TemaValidator(),"test_assignment.xml"),null);

        int initLen[] = {0};
        service.findAllTeme().forEach(s -> initLen[0]++);
        assert(service.saveTema("999","asta merge",13,7) == 1);
        int finLen[] = {0};
        service.findAllTeme().forEach(s -> finLen[0]++);

        assert(initLen[0] + 1 == finLen[0]);

        service.deleteTema("999");
    }


    @org.junit.jupiter.api.Test
    public void addAssignment_NotAdded() {

        Service service = new Service(null,new TemaXMLRepository(new TemaValidator(),"test_assignment.xml"),null);

        int initLen[] = {0};
        service.findAllTeme().forEach(s -> initLen[0]++);
        try{
            service.saveTema("999","nu merge", 7,13);
        }
        catch (ValidationException e){
            assert(true);
        }
        int finLen[] = {0};
        service.findAllTeme().forEach(s -> finLen[0]++);

        assert(initLen[0] == finLen[0]);
        service.deleteTema("999");
    }


}