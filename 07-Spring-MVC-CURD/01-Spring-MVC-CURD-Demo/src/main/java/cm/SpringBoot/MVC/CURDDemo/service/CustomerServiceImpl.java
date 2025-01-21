package cm.SpringBoot.MVC.CURDDemo.service;

import cm.SpringBoot.MVC.CURDDemo.dao.CustomerRepository;
import cm.SpringBoot.MVC.CURDDemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private List<Customer> theCustomers;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {

        theCustomers = customerRepository.findAll();

        return theCustomers;
    }

    @Override
    public Optional<Customer> findById(Integer id) {

        return customerRepository.findById(id);

    }

    @Override
    public Customer save(Customer customer) {
        Customer theCustomer = customerRepository.save(customer);
        return theCustomer;
    }

    @Transactional
    @Override
    public Customer deleteById(Integer id) {
        customerRepository.deleteById(id);
        return null;
    }

}
