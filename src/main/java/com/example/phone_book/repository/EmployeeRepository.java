package com.example.phone_book.repository;

import com.example.phone_book.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT e FROM Employee e WHERE e.name LIKE %:keyword% " +
            "or e.position like %:keyword% " +
            "or e.department like %:keyword% " +
            "or e.phone like %:keyword% " +
            "or e.email like %:keyword%")

    public List<Employee> search(@Param("keyword") String keyword);

}
