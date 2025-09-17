package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.entity.Employee;

public class EmployeeRepositoryImpl {

    private SessionFactory getSessionFactory() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        return meta.getSessionFactoryBuilder().build();
    }

    public Employee addEmployee(Employee emp) {
        SessionFactory factory = getSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        session.persist(emp);

        t.commit();
        session.close();
        factory.close();
        return emp;
    }

    public List<Employee> getAllEmployees() {
        SessionFactory factory = getSessionFactory();
        Session session = factory.openSession();

        List<Employee> empList = session.createQuery("from Employee", Employee.class).getResultList();

        session.close();
        factory.close();
        return empList;
    }

    public Employee getEmployeeById(int empId) {
        SessionFactory factory = getSessionFactory();
        Session session = factory.openSession();

        Employee emp = session.get(Employee.class, empId);

        session.close();
        factory.close();
        return emp;
    }

    public Employee updateEmployee(Employee emp) {
        SessionFactory factory = getSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        session.merge(emp); 

        t.commit();
        session.close();
        factory.close();
        return emp;
    }

    public void deleteEmployeeById(int empId) {
        SessionFactory factory = getSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Employee emp = session.get(Employee.class, empId);
        if (emp != null) {
            session.remove(emp);
        }

        t.commit();
        session.close();
        factory.close();
    }
}
