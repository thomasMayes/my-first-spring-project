package com.myproject.demo.dao;

import com.myproject.demo.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeDao")
public class FakeStudentDaoImpl implements  StudentDao{

    private final Map<UUID, Student> database;

    public FakeStudentDaoImpl() {

        database = new HashMap<>();
        UUID studentId = UUID.randomUUID();
        database.put(
                studentId,
                new Student(studentId, 24, "test", "McTester",  "something")
        );
    }

    @Override
    public int insertNewStudent(UUID studentId, Student student) {
        database.put(studentId, student);
        return 1;
    }

    @Override
    public Student selectStudentById(UUID studentId) {
        return database.get(studentId);
    }

    @Override
    public List<Student> selectAllStudents() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateStudentByID(UUID studentId, Student studentUpdate) {
        database.put(studentId, studentUpdate);
        return 1;
    }

    @Override
    public int deleteStudentById(UUID studentId) {
        database.remove(studentId);
        return 1;
    }
}
