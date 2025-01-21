package cm.SpringBoot.MVC.CURDDemo.service;

import cm.SpringBoot.MVC.CURDDemo.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAll();

    Optional<Customer> findById(Integer id);

    Customer save(Customer customer);

    Customer deleteById(Integer id);
}
