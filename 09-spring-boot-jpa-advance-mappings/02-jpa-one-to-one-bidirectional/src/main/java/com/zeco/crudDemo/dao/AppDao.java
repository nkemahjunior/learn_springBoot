package com.zeco.crudDemo.dao;

import com.zeco.crudDemo.entity.Instructor;
import com.zeco.crudDemo.entity.InstructorDetail;

public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
