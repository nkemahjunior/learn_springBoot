package com.zeco.crudDemo.dao;

import com.zeco.crudDemo.entity.Instructor;

public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    
}
