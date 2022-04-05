package service;

import repository.TemaXMLRepository;
import validation.TemaValidator;
import validation.ValidationException;

public class AssignmentServiceTest {

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
    public void addAssignment_NotAdded() {

        Service service = new Service(null,new TemaXMLRepository(new TemaValidator(),"test_assignment.xml"),null);

        service.deleteTema("999");

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

    }


    @org.junit.jupiter.api.Test
    public void addAssignment_nullID_NotAdded() {

        Service service = new Service(null,new TemaXMLRepository(new TemaValidator(),"test_assignment.xml"),null);

        String id = null;
        String description = "merge";
        int deadline = 7;
        int startline = 13;

        try{
            service.deleteTema(id);
        }
        catch (Exception e){
            assert(true);
        }

        int initLen[] = {0};
        service.findAllTeme().forEach(s -> initLen[0]++);
        try{
            service.saveTema(id,description, deadline,startline);
        }
        catch (ValidationException e){
            assert(true);
        }
        int finLen[] = {0};
        service.findAllTeme().forEach(s -> finLen[0]++);

        assert(initLen[0] == finLen[0]);

    }


    @org.junit.jupiter.api.Test
    public void addAssignment_invalidID_NotAdded() {

        Service service = new Service(null,new TemaXMLRepository(new TemaValidator(),"test_assignment.xml"),null);

        String id = "";
        String description = "merge";
        int deadline = 7;
        int startline = 13;

        try{
            service.deleteTema(id);
        }
        catch (Exception e){
            assert(true);
        }

        int initLen[] = {0};
        service.findAllTeme().forEach(s -> initLen[0]++);
        try{
            service.saveTema(id,description, deadline,startline);
        }
        catch (ValidationException e){
            assert(true);
        }
        int finLen[] = {0};
        service.findAllTeme().forEach(s -> finLen[0]++);

        assert(initLen[0] == finLen[0]);

    }



    @org.junit.jupiter.api.Test
    public void addAssignment_nullDescription_NotAdded() {

        Service service = new Service(null,new TemaXMLRepository(new TemaValidator(),"test_assignment.xml"),null);

        String id = "999";
        String description = null;
        int deadline = 7;
        int startline = 13;

        try{
            service.deleteTema(id);
        }
        catch (Exception e){
            assert(true);
        }

        int initLen[] = {0};
        service.findAllTeme().forEach(s -> initLen[0]++);
        try{
            service.saveTema(id,description, deadline,startline);
        }
        catch (ValidationException e){
            assert(true);
        }
        int finLen[] = {0};
        service.findAllTeme().forEach(s -> finLen[0]++);

        assert(initLen[0] == finLen[0]);

    }


    @org.junit.jupiter.api.Test
    public void addAssignment_invalidDescription_NotAdded() {

        Service service = new Service(null,new TemaXMLRepository(new TemaValidator(),"test_assignment.xml"),null);

        String id = "999";
        String description = "";
        int deadline = 7;
        int startline = 13;

        try{
            service.deleteTema(id);
        }
        catch (Exception e){
            assert(true);
        }

        int initLen[] = {0};
        service.findAllTeme().forEach(s -> initLen[0]++);
        try{
            service.saveTema(id,description, deadline,startline);
        }
        catch (ValidationException e){
            assert(true);
        }
        int finLen[] = {0};
        service.findAllTeme().forEach(s -> finLen[0]++);

        assert(initLen[0] == finLen[0]);

    }





    @org.junit.jupiter.api.Test
    public void addAssignment_smallDeadline_NotAdded() {

        Service service = new Service(null,new TemaXMLRepository(new TemaValidator(),"test_assignment.xml"),null);

        String id = "999";
        String description = "merge";
        int deadline = 0;
        int startline = 13;

        try{
            service.deleteTema(id);
        }
        catch (Exception e){
            assert(true);
        }

        int initLen[] = {0};
        service.findAllTeme().forEach(s -> initLen[0]++);
        try{
            service.saveTema(id,description, deadline,startline);
        }
        catch (ValidationException e){
            assert(true);
        }
        int finLen[] = {0};
        service.findAllTeme().forEach(s -> finLen[0]++);

        assert(initLen[0] == finLen[0]);

    }


    @org.junit.jupiter.api.Test
    public void addAssignment_largeDeadline_NotAdded() {

        Service service = new Service(null,new TemaXMLRepository(new TemaValidator(),"test_assignment.xml"),null);

        String id = "999";
        String description = "merge";
        int deadline = 15;
        int startline = 13;

        try{
            service.deleteTema(id);
        }
        catch (Exception e){
            assert(true);
        }

        int initLen[] = {0};
        service.findAllTeme().forEach(s -> initLen[0]++);
        try{
            service.saveTema(id,description, deadline,startline);
        }
        catch (ValidationException e){
            assert(true);
        }
        int finLen[] = {0};
        service.findAllTeme().forEach(s -> finLen[0]++);

        assert(initLen[0] == finLen[0]);

    }




    @org.junit.jupiter.api.Test
    public void addAssignment_smallStartline_NotAdded() {

        Service service = new Service(null,new TemaXMLRepository(new TemaValidator(),"test_assignment.xml"),null);

        String id = "999";
        String description = "merge";
        int deadline = 13;
        int startline = 0;

        try{
            service.deleteTema(id);
        }
        catch (Exception e){
            assert(true);
        }

        int initLen[] = {0};
        service.findAllTeme().forEach(s -> initLen[0]++);
        try{
            service.saveTema(id,description, deadline,startline);
        }
        catch (ValidationException e){
            assert(true);
        }
        int finLen[] = {0};
        service.findAllTeme().forEach(s -> finLen[0]++);

        assert(initLen[0] == finLen[0]);

    }


    @org.junit.jupiter.api.Test
    public void addAssignment_largeStartline_NotAdded() {

        Service service = new Service(null,new TemaXMLRepository(new TemaValidator(),"test_assignment.xml"),null);

        String id = "999";
        String description = "merge";
        int deadline = 20;
        int startline = 15;

        try{
            service.deleteTema(id);
        }
        catch (Exception e){
            assert(true);
        }

        int initLen[] = {0};
        service.findAllTeme().forEach(s -> initLen[0]++);
        try{
            service.saveTema(id,description, deadline,startline);
        }
        catch (ValidationException e){
            assert(true);
        }
        int finLen[] = {0};
        service.findAllTeme().forEach(s -> finLen[0]++);

        assert(initLen[0] == finLen[0]);

    }


    @org.junit.jupiter.api.Test
    public void addAssignment_wrongOrder_NotAdded() {

        Service service = new Service(null,new TemaXMLRepository(new TemaValidator(),"test_assignment.xml"),null);

        String id = "999";
        String description = "merge";
        int deadline = 7;
        int startline = 13;

        try{
            service.deleteTema(id);
        }
        catch (Exception e){
            assert(true);
        }

        int initLen[] = {0};
        service.findAllTeme().forEach(s -> initLen[0]++);
        try{
            service.saveTema(id,description, deadline,startline);
        }
        catch (ValidationException e){
            assert(true);
        }
        int finLen[] = {0};
        service.findAllTeme().forEach(s -> finLen[0]++);

        assert(initLen[0] == finLen[0]);

    }





}
