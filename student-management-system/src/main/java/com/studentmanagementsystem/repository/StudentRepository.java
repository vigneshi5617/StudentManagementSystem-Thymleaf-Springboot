package com.studentmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanagementsystem.entity.Student;


/*@Repository -->This is not needed because the JpaRepository 
// has a default implementation class "SimpleJpaRepository"

//So the class "SimpleJpaRepository" is the implementation of JpaRespository and that class already has @Repositry over that class

//So we dont need to add @Repsitory in this .

//Note:JpaRepository by default provides "Transaction" to alll the methods it provides
 * 
 * */

 
public interface StudentRepository  extends JpaRepository<Student,Long>{

}
