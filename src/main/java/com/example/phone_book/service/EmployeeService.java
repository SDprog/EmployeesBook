package com.example.phone_book.service;

import java.util.List;

import com.example.phone_book.model.Employee;
import com.example.phone_book.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public void save(Employee employee) {
        repo.save(employee);
    }

    public List<Employee> listAll() {
        return (List<Employee>) repo.findAll();
    }

    public Employee get(long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Employee> search(String keyword) {

        return (List<Employee>) repo.search(keyword);

    }
}


